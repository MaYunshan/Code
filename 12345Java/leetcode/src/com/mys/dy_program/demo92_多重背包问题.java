package com.mys.dy_program;

/**
 * /**
 * 	多重背包问题	
 * 	有N种物品和一个容量为V的背包，每种物品都是有限的。物品的质量分别为w[i]，物品的价格为v[i]，物品的数量为c[i]。
 * 	求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * 	多重背包问题和01背包问题相似，而且可以转换为01背包，如果某一件物品有两件，那么可以认为它们是两件物品，只不过质量和价格都是一样的
 * 	最后物品的总个数为c[0]+c[1]+.....c[N-1]
 *
 */
 
public class demo92_多重背包问题 {

	public static void main(String[] args) {
		int N = 6;
		int C = 12;
		int[] w = {4, 6, 2, 2, 5, 1};
		int[] v = {8, 10, 6, 3, 7, 2};
		int[] c = {2, 2, 2, 2, 2, 2};
		
		//解法1
		int ret = MultipleBag.bag(N, C, w, v, c);
		System.out.println(ret);
		
		//解法2
		int ret1 = MultipleBag.bag1(N, C, w, v, c);
		System.out.println(ret1);
		
		//解法3
		int ret2 = MultipleBag.bag2(N, C, w, v, c);
		System.out.println(ret2);
	}

}

class MultipleBag{
	/**
	 * 	解法1：转换为01背包问题
	 * 	采用动态规划
	 */
	public static int bag(int N,int C,int[] w,int[] v,int[] c) {
		int n = 0;
		//所有的物品个数的和就是最后物品的个数
		for (int i = 0; i < c.length; i++) {
			n += c[i];
		}
		
		//重新定义重量数组和价值数组
		int[] weight = new int[n];
		int[] value = new int[n];
		int i = 0;
		int k = 0;
		
		//把原来的数组按照个数展开
		while(i < N) {
			for (int j = 0; j < c[i]; j++) {
				weight[k] = w[i];
				value[k] = v[i];
				k++;
			}
			i++;
		}
		
		//声明一个长度为C+1的数组dp
		int[] dp = new int[C+1];
		
		//在前i个物品之间选择物品放入背包
		for (int ii = 0; ii < n; ii++) {
			for (int j = C; j >= weight[ii]; j--) {
				/**
				 * 	可以选择放入当前物品，也可以选择不放
				 *		不放，背包的价值v0=dp[j]
				 *		放入，背包的价值v1=dp[j-weight[ii]]+value[ii]
				 *	那么，当状态(ii,j)结束时，背包的最大价值为dp[j]=max{v0,v1}
				 */
				dp[j] = Math.max(dp[j], dp[j-weight[ii]]+value[ii]);
			}
		}
		
		return dp[C];
	}
	
	/**
	 * 	解法2：动态规划
	 * 	二维数组
	 */
	public static int bag1(int N,int C,int[] w,int[] v,int[] c) {
		
		int[][] dp = new int[N][C+1];
		
		//仅选择放入第一件物品时，背包的价值
		for (int j = 1; j <= C; j++) {
			if(j/w[0] <= c[0]) {
				dp[0][j] = j/w[0]*v[0];
			}else {
				dp[0][j] = c[0]*v[0];
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= C; j++) {
				//如果当前背包不能容纳w[i]，背包的最大价值跟不放入w[i]的价值一样
				if(j < w[i])
					dp[i][j] = dp[i-1][j];
				//如果当前背包的容量j能够容纳w[i]，就要看能容纳几个w[i]，
				else {
					/**
					 * 	k=0，放入0个w[i]，背包的价值为：v0=dp[i-1][j]
					 * 	k=1，放入1个w[i]，背包的价值为：v1=dp[i-1][j-w[i]]+v[i]
					 * 	则背包的最大价值为：v01=dp[i][j]=max{v0,v1},继续放入w[i]
					 * 	k=2，放入2个w[i]，背包的价值为：v2=dp[i-1][j-2*w[i]]+2*v[i]
					 * 	......
					 * 	则背包的容量dp[i][j]=max{v01，v1}=max{v0,v1,v2}
					 * 	k<=c[i]
					 * 	最后，背包的价值为dp[i][j]=max{v0,v1,v2...vk}
					 */
					for (int k = 1; k <= c[i] && j >= k*w[i]; k++) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k*w[i]]+k*v[i]);
					}
				}
				
			}
		}
		return dp[N-1][C];
	}
	
	/**
	 * 	解法3：动态规划
	 * 	一维数组
	 */
	public static int bag2(int N,int C,int[] w,int[] v,int[] c) {
		
		int[] dp = new int[C+1];
		
		for (int i = 0; i < N; i++) {
			for (int j = C; j >= w[i]; j--) {
				if(j >= w[i]) {
					//如果当前背包能够放下w[i]，并且放置的个数不超过c[i]，那就一直放，并且取最大值
					for (int k = 1; k <= c[i] && j >= k*w[i]; k++) {
						dp[j] = Math.max(dp[j], dp[j-k*w[i]]+k*v[i]);
					}
				}
			}
		}
		return dp[C];
	}
}
