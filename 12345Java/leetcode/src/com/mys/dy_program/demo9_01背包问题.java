package com.mys.dy_program;

/**
 * 01背包问题
 * 	给定N件物品和一个容量为C的背包，物品的质量分别为w[i]，物品的价格为v[i],求将那些物品放到背包里可以使得价值最大
 * 	对于每一件物品，要么选，要么不选，用数组x[i]表示，x[i]的取值是0或者1，所以称之为01背包问题
 * 	因此问题归结为：
 * 		在约束：w1x1+w2x2+...wnxn<=C
 * 		求：max{v1x1+v2x2+...vnxn}
 * @author dell
 *
 */
public class demo9_01背包问题 {

	public static void main(String[] args) {
		int N = 6;
		int C = 12;
		int[] w = {4, 6, 2, 2, 5, 1};
		int[] v = {8, 10, 6, 3, 7, 2};
		int ret = Bag01.bag2(N, C, w, v);
		System.out.println(ret);
	}

}

class Bag01{
	
	/**
	 * 	解法3：动态规划
	 * 		用一维数组dp来记录背包所能容纳的最大价值,
	 * 		根据状态方程，dp(i,C)=max(dp(i-1,C),v(i)+dp(i-1,C-w(i)))
	 * 			当前i-1个物品分别放入背包中时，得到一维数组dp，dp[j]代表背包容量为j时的最大价值
	 * 			当背包容量为j时，dp[j]要么是i-1状态的dp[j],要么是i-1状态时的dp[j-w[i]]与v[i]的和
	 * 			不过j要从后往前遍历，不然，dp[j-w[i]]是当前i状态的新值，而不是i-1状态时的值了
	 * 		此时，状态方程为		 
	 * 			dp(j)= max(dp[j], dp[j-w[i]]+v[i])
	 */
	public static int bag2(int N,int C,int[] w,int[] v) {
		//用一维数组来解决问题
		int[] dp = new int[C+1]; 
				
		//外层循环用来控制物品索引状态
		for (int i = 0; i < N; i++) {
			//程序执行到这里，dp数组已经被赋值了，它是i-1状态时，各个背包的最大价值，
			
			//背包从后往前遍历
			//如果当前背包能够放得下第i个物品，那么就根据i-1状态的dp[j]和dp[j-w[i]]更新i状态的dp[j]
			//如果放不下第i个物品，说明dp[j]还是i-1状态时的dp[i-1],即dp[j]=dp[j]
			for (int j = C; j >= w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
			}
		}
		 return dp[C];
	}
	
	/**
	 * 	解法2：递归法
	 * 
	 */
	public static int bag1(int N,int C,int[] w,int[] v) {
		//动态数组dp用来记录子问题的解
		int[][] dp = new int[N][C+1]; 
		 int ret = dfs(C,N-1,w,v,dp);
		 return ret;
	}
	
	
	/**
	 * 	
	 * @param capacity
	 * @param index
	 * @param w
	 * @param v
	 * @param dp
	 * @return
	 */
	private static int dfs(int capacity, int index, int[] w, int[] v, int[][] dp) {
		//如果索引为负或者背包容量已经为空了，返回0
		if(index < 0 || capacity <= 0)
			return 0;
		
		//如果子问题已经有最优解，直接返回就可以了
		if(dp[index][capacity] != 0)
			return dp[index][capacity];
		
		//如果当前背包的容量能放下第index位置处的物品，那么背包总价值就是，当背包容量为capacity-w[index]时的最大价值加上index位置处物品的价值
		int v1 = 0;
		if(capacity >= w[index]) {
			v1 = v[index] + dfs(capacity-w[index], index-1, w, v,dp);
		}
		
		//如果不放当前物品时的代价
		int v2 = dfs(capacity, index-1, w, v,dp);
		
		dp[index][capacity] = Math.max(v1, v2);
		return dp[index][capacity];
	}


	/**
	 * 	解法1：动态规划
	 * 	声明一个(N+1)*(C+1)的数组dp,行索引的范围是0~N，列的索引范围是0~C，第0行、第0列用0填充，
	 * 		dp[i][j]表示在背包容量为C的情况下，从第1个、第2个...第i个物品中选取物品时获得的最大代价
	 * 	dp[i][j]的计算过程如下：
	 * 		1.如果j<w[i],也就是当前背包不能放得下第i个物品，那就不能拿这个物品了，此时背包获得的最大价值和和dp[i-1][j]是一样的
	 * 			dp[i][j]=dp[i-1][j]
	 * 		2.如果j>=w[i],也就是当前背包可以放得下第i个物品，那么dp[i][j]是下面两种可能中的最大值
	 * 			1). 从背包中拿出w[i]的东西，腾出j-w[i]的空闲容量，然后把第i个物品放进去，此时，v1=dp[i-1][j-w[i]]+v[i]
	 * 			2). 不往背包里放第i个物品，此时，v2=dp[i-1][j]
	 * 	状态转移方程
	 * 		dp(i,C)=max(dp(i-1,C),v(i)+dp(i-1,C-w(i)))
	 * 
	 * @param N
	 * @param C
	 * @param w
	 * @param v
	 * @return
	 */
	public static int bag(int N,int C,int[] w,int[] v) {
		
		//
		int[][] dp = new int[N+1][C+1];
		
		//i的索引是从1开始的，对应的物品索引为i-1
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= C; j++) {
				//当前背包无法装下第i-1个物品，那么此时它的最大价值就是跟只装了上一件物品的价值是一样的
				if(j < w[i-1]) {
					dp[i][j] = dp[i-1][j];
				}
				
				//如果此时背包的容量能够装的下第i-1个物品，就要做出一些决策了
				else {
					int v1 = dp[i-1][j];					//不拿时的总价值
					int v2 = dp[i-1][j-w[i-1]]+v[i-1];		//拿了以后的总价值
					dp[i][j] = Math.max(v1, v2);			//取最大值
				}
			}
		}
		return dp[N][C];
	}
}