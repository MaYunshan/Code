package com.mys.dy_program;

/**
 * 完全背包问题	
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。物品的质量分别为w[i]，物品的价格为v[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * 完全背包和01背包十分相像， 区别就是完全背包物品有无限件。由之前的选或者不选转变成了选或者不选，选几件
 *
 */
public class demo91_完全背包问题 {

	public static void main(String[] args) {
		int N = 6;
		int C = 12;
		int[] w = {4, 6, 2, 2, 5, 1};
		int[] v = {8, 10, 6, 3, 7, 2};
		
		//解法1：递归
		int[] finalValue = new int[1];
		CompleteBag.bag(0, C, w, v,finalValue,0);
		System.out.println(finalValue[0]);
		
		//解法2：dp[N][C+1]
		int ret = CompleteBag.bag1(N, C, w, v);
		System.out.println(ret);
		
		//解法3:dp[C+1]
		int ret2 = CompleteBag.bag2(N, C, w, v);
		System.out.println(ret2);
		
		//解法4:dp[C+1]
		int ret3 = CompleteBag.bag3(N, C, w, v);
		System.out.println(ret3);
	}

}

class CompleteBag{
	/**
	 * 	解法1：递归
	 * 		从第一件物品开始装，一直装到背包再不能装下物品时，即C<w[i]，记录此时的总价值，
	 * 		然后再从背包里面取出一个第一件物品，分别再装剩下的每一件物品，直到背包容量为0，与上一次的总价值比较取最大值
	 * 		整个递归过程就像一棵树
	 * 		此过程的状态方程是
	 * 			max{x1v1+x2v2+x3v3+....xnvn}
	 * 			其中xi的取值范围分别是，0<=x1<=C/w1, 0<=x2<=C/w2,.......0<=xn<=C/wn
	 * 			然后穷举{x1,x2,x3....xn}，找到最大价值
	 * 		递归的思路虽然很简单，但是时间复杂度很高，
	 * @param nowValue 
	 * @param totalValue 
	 */
	public static void bag(int index,int C,int[] w,int[] v, int[] finalValue, int nowValue) {
		//如果最后一件物品已经取完了，返回
		if(index >= w.length)
			return;
		
		//如果背包现在的容量已经装不下第index个物品，并且背包现在的总价值比上一次的总价值还要大，那么就更新背包的总价值
		if (C < w[index] && nowValue > finalValue[0]) {
			finalValue[0] = nowValue;
			return;
		}
		
		for (int i = index; i < v.length; i++) {
			//如果装不下第i个物品，剪枝，直接试着装下一个
			if(C < w[i]) continue;
			//如果能装的下第i个物品，背包当前容量－w[i],背包当前价值+v[i]
			bag(i, C-w[i], w, v, finalValue, nowValue+v[i]);
		}
	}
	
	/**
	 * 	解法2：动态规划
	 * 		用一个N*(C+1)的二维数组dp来记录每一个状态点的最优解，
	 * 			dp[i][j]表示在背包容量为C，只在前i个物品之中选取所能获得的最大价值
	 * 		因为每一件物品可以多次放置，当背包容量为j时，它能放置0到j/w[i]个第i件物品，
	 * 			如果放0件，那么此时背包的价值为:v0=dp[i-1][j]
	 * 			如果放1件，那么此时背包的价值为:v1=dp[i-1][j-w[i]*1]
	 * 			如果放2件，那么此时背包的价值为:v2=dp[i-1][j-w[i]*2]
	 * 			如果放3件，那么此时背包的价值为:v3=dp[i-1][j-w[i]*3]
	 * 			......
	 * 			如果放k=j/w[i]，那么此时背包的价值为：vk=v3=dp[i-1][j-w[i]*k]
	 * 			所以，dp[i][j]=max{v0,v1,v2,v3.....vk}
	 */
	
	public static int bag1(int N,int C,int[] w,int[] v) {
		
		int[][] dp = new int[N][C+1];
		
		//只选择放第1件物品，当背包容量为j时，最优解为j/w[0]*v[0]
		for (int j = 0; j < C+1; j++) {
			dp[0][j] = j/w[0]*v[0];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < C+1; j++) {
				//前i-1个物品时的最优解一件得到，现在加入第i个物品，
				//在背包容量为j的情况下，向背包中分别放置0件，1件....j/w[i]件第i件物品,最后得到的最大值就是dp[i][j]
				for(int k = 0; k <= j/w[i]; k++) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k*w[i]]+k*v[i]);
				}
			}
		}
		return dp[N-1][C];
	}
	
	/**
	 * 	解法3，动态规划(一维数组)dp[C+1]
	 * 		在放置第i个物品的时候，当背包容量为j时
	 * 			如果放0个：那么背包的价值与i-1状态时一样：v0=dp[j]
	 * 			如果放1个：那么背包的价值为：v1=dp[j-w[i]*1]+v[i]*1
	 * 			如果放2个：那么背包的价值为：v2=dp[j-w[i]*2]+v[i]*2
	 * 			......
	 * 			如果放k=j/w[i]个:那么背包的价值为：vk=dp[j-w[i]*k]+v[i]*k
	 */
	public static int bag2(int N,int C,int[] w,int[] v) {
		
		int[] dp = new int[C+1];
		
		//只选择放第1件物品，当背包容量为j时，最优解为j/w[0]*v[0]
//		for (int j = 0; j < C+1; j++) {
//			dp[j] = j/w[0]*v[0];
//		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= C; j++) {
				//前i-1个物品时的最优解已经得到，现在加入第i个物品，
				//在背包容量为j的情况下，向背包中分别放置0件，1件....j/w[i]件第i件物品,最后得到的最大值就是dp[i][j]
				for(int k = 1; k <= j/w[i]; k++) {
					dp[j] = Math.max(dp[j], dp[j-k*w[i]]+k*v[i]);
				}
			}
		}
		return dp[C];
	}
	
	/**
	 * 	解法4，动态规划(一维数组,降一层循环)dp[C+1]
	 * 		在放置第i个物品的时候，当背包容量为j时
	 * 			如果放0个：那么背包的价值与i-1状态时一样：v0=dp[j]
	 * 			如果放1个：那么背包的价值为：v1=dp[j-w[i]*1]+v[i]*1
	 * 			如果放2个：那么背包的价值为：v2=dp[j-w[i]*2]+v[i]*2
	 * 			......
	 * 			如果放k=j/w[i]个:那么背包的价值为：vk=dp[j-w[i]*k]+v[i]*k
	 */
	public static int bag3(int N,int C,int[] w,int[] v) {
		
		int[] dp = new int[C+1];
		
		for (int i = 0; i < N; i++) {
			//如果背包容量<w[i]时，肯定放不下w[i]，所以背包容量直接从w[i]开始，
			for (int j = w[i]; j <= C; j++) {
				/**
				 * 	进入到这里，背包j至少能够放下一个w[i]，但是此时背包的价值要权衡一下
				 * 		如果放0个，v0=dp[j]
				 * 		如果放1个，v1=dp[j-w[i]]+v[i]
				 * 	所以，此时，dp[j]=max{v0,v1};
				 * 	如果背包容量能放下两个w[i],那么，此时背包的价值也要权衡一下
				 * 		如果不放进去第2个w[i]，v1=dp[j]=max{v0,v1};
				 * 		如果放进去第2个w[i]，    v2=dp[j-w[i]]+v[i]
				 * 	所以，此时，dp[j]=max{v1,v2}=max{v0,v1,v2}
				 * 	依此类推，就能得到，在前i个物品中选择物品时，各个容量的背包的最大价值
				 * 	最后，当所有的N个物品都遍历完以后，各个背包的最大的价值也就得到了，
				 */
				dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
			}
		}
		return dp[C];
	}
}