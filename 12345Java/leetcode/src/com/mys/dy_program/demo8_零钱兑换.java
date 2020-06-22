package com.mys.dy_program;

import java.util.Arrays;



/**
 * 	给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 	如果没有任何一种硬币组合能组成总金额，返回 -1。
 *	
 *	这个问题是一个完全背包问题，但是不同点是，这个背包必须装满,将其归纳为数学问题就是
 *		v[i]:代表每种硬币的价值
 *		x[i]:代表每种硬币拿的个数，0<=x[i]<=amount/v[i]
 *	所求问题可以归纳为：
 *		在满足：amount=v1x1+v2x2+v3x3+...+vnxn 的条件下
 *		求：min{x1+x2+x3+....xn}
 */
public class demo8_零钱兑换 {

	public static void main(String[] args) {
		int[] coins = {2,3,4};
		
		//解法1，递归
		int count = Solution8.coinChange(coins, 8);
		System.out.println(count);
		
		//解法2，动态规划(二维数组)
		int count1 = Solution8.coinChange1(coins, 8);
		System.out.println(count1);
		
		//解法3，动态规划(一维数组)
		int count2 = Solution8.coinChange2(coins, 8);
		System.out.println(count2);
	}

}
class Solution8 {
	
	/**
	 * 	解法2:动态规划(二维数组)
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange1(int[] coins, int amount) {
		if(coins.length == 0)
            return -1;
		int N = coins.length;
		//声明一个二维数组dp,用来记录每个状态的最小硬币数目
    	int [][] dp = new int[N][amount+1];
    	
    	//除了第一列，对应j=0，其它值全部为无穷大
    	for (int i = 0; i < N; i++) {
    		Arrays.fill(dp[i],1,dp[i].length, Integer.MAX_VALUE);
		}
    	
    	//为动态数组的第一行赋值，对应只有一个硬币，装满各个背包时需要的硬币数目
    	//如果j能被coins[0]整除，就在对应位置上放置对应数目个coins[0]
    	for (int j = 1; j <= amount; j++) {
			if(j % coins[0] == 0)
				dp[0][j] = j/coins[0];
		}
    	
    	//如果dp[i][j]为无穷大，说明当前状态无法凑出总金额
    	for (int i = 1; i < N; i++) {
			for (int j = 1; j <= amount; j++) {
				/**
				 * 在放置第i个硬币的时候，最多能够放k=j/coins[i]个第i个硬币
				 * 	如果放0个，那么当前硬币个数为：v0=dp[i-1][j]
				 * 	如果放1个，那么当前硬币个数为：v1=dp[i-1][j-coins[i]*1]+1【前提是dp[i-1][j-coins[i]*1]有值，即状态(i-1,j-coins[i]*1)有解】
				 * 	如果放2个，那么当前硬币个数为：v2=dp[i-1][j-coins[i]*2]+2【前提是dp[i-1][j-coins[i]*2]有值，即状态(i-1,j-coins[i]*2)有解】
				 * 	......
				 * 	如果放k个，那么当前硬币个数为：vk=dp[i-1][j-coins[i]*k]+k【前提是dp[i-1][j-coins[i]*k]有值，即状态(i-1,j-coins[i]*k)有解】
				 * 	那么dp[i][j]最后的值为min{v0,v1,v2...vk}
				 */
				
				for (int k = 0; k <= j/coins[i]; k++) {
					if(dp[i-1][j-coins[i]*k] != Integer.MAX_VALUE)
						dp[i][j] = Math.min(dp[i][j], dp[i-1][j-coins[i]*k]+k);
				}
			}
		}
    	if(dp[N-1][amount] != Integer.MAX_VALUE)
    		return dp[N-1][amount];
    	return -1;
    }
	
	/**
	 * 	解法3，动态规划(一维数组)
	 * @param coins
	 * @param amount
	 * @return
	 */
    public static int coinChange2(int[] coins, int amount) {
    	if(coins.length == 0)
            return -1;
    	
    	//声明一个amount+1长度的数组dp，代表各个价值的钱包，第0个钱包可以容纳的总价值为0，其它全部初始化为无穷大
    	//dp[j]代表当钱包的总价值为j时，所需要的最少硬币的个数
    	int[] dp = new int[amount+1];
    	Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);
    	
    	//i代表可以使用的硬币索引，i=2代表只在第0个，第1个，第2个这三个硬币中选择硬币
    	for (int i = 0; i < coins.length; i++) {
    		/**
    		 * 	当外层循环执行一次以后，说明在只使用前i-1个硬币的情况下，各个钱包的最少硬币个数已经得到，
    		 * 		有些钱包的值还是无穷大，说明在仅使用前i-1个硬币的情况下，不能凑出钱包的价值
    		 * 	现在开始再放入第i个硬币，要想放如w[i]，钱包的价值必须满足j>=w[i]，所以在开始放入第i个硬币时，j从w[i]开始
    		 */
			for (int j = coins[i]; j <= amount; j++) {
				/**
				 * 	如果钱包当前的价值j仅能允许放入一个w[i]，那么就要进行权衡，以获得更少的硬币数
				 * 		如果放入0个：此时钱包里面硬币的个数保持不变： v0=dp[j]
				 * 		如果放入1个：此时钱包里面硬币的个数为：		v1=dp[j-coins[i]]+1
				 * 		 【前提是dp[j-coins[i]]必须有值，如果dp[j-coins[i]]是无穷大，说明无法凑出j-coins[i]价值的钱包，
				 * 	              那么把w[i]放进去以后，自然也凑不出dp[j]的钱包】
				 * 	所以，此时当钱包价值为j时，里面的硬币数目为 dp[j]=min{v0,v1}
				 * 	如果钱包当前价值j能够放入2个w[i]，就要再进行一次权衡
				 * 		如果不放人第2个w[i]，此时钱包里面硬币数目为，v1=dp[j]=min{v0,v1}
				 * 		如果放入第2个w[i],  此时钱包里面硬币数目为，v2=dp[j-coins[i]]+1
				 * 	所以，当钱包的价值为j时，里面的硬币数目为dp[j]=min{v1,v2}=min{v0,v1,v2}
				 * 	钱包价值j能允许放入3个，4个.........w[i]，不断更新dp[j]，最后得到在仅使用前i个硬币的时候，每个钱包里的最少硬币数目
				 */
				if(dp[j-coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
				}
			}
		}
    	if(dp[amount] != Integer.MAX_VALUE)
    		return dp[amount];
    	return -1;
    }
	
	/**
	 * 	解法1，递归查找，不断更新更小的值
	 * @param coins
	 * @param amount
	 * @return
	 */
    public static int coinChange(int[] coins, int amount) {
    	Arrays.sort(coins);
    	int[] count = new int[1];
    	count[0] = Integer.MAX_VALUE;
    	int index = coins.length - 1;
    	dfs(coins, amount, 0,count,index);
    	if(count[0] != Integer.MAX_VALUE)
    		return count[0];
        return -1;
    }

	private static void dfs(int[] coins, int amount, int nowCount, int[] count, int index) {
		if(nowCount >= count[0] || nowCount + amount/coins[index] >= count[0])
			return;
		if(amount == 0) {
			count[0] = Math.min(count[0], nowCount);
			return;
		}
		for (int i = index; i >= 0; i--) {
			if(coins[i] > amount || amount/coins[index] + nowCount > count[0])
				continue;
			dfs(coins, amount-coins[i], nowCount+1, count, i);
		}
	}
}