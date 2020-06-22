package com.mys.dy_program;

import java.util.Arrays;



/**
 * 	������ͬ����Ӳ�� coins ��һ���ܽ�� amount����дһ��������������Դճ��ܽ����������ٵ�Ӳ�Ҹ�����
 * 	���û���κ�һ��Ӳ�����������ܽ����� -1��
 *	
 *	���������һ����ȫ�������⣬���ǲ�ͬ���ǣ������������װ��,�������Ϊ��ѧ�������
 *		v[i]:����ÿ��Ӳ�ҵļ�ֵ
 *		x[i]:����ÿ��Ӳ���õĸ�����0<=x[i]<=amount/v[i]
 *	����������Թ���Ϊ��
 *		�����㣺amount=v1x1+v2x2+v3x3+...+vnxn ��������
 *		��min{x1+x2+x3+....xn}
 */
public class demo8_��Ǯ�һ� {

	public static void main(String[] args) {
		int[] coins = {2,3,4};
		
		//�ⷨ1���ݹ�
		int count = Solution8.coinChange(coins, 8);
		System.out.println(count);
		
		//�ⷨ2����̬�滮(��ά����)
		int count1 = Solution8.coinChange1(coins, 8);
		System.out.println(count1);
		
		//�ⷨ3����̬�滮(һά����)
		int count2 = Solution8.coinChange2(coins, 8);
		System.out.println(count2);
	}

}
class Solution8 {
	
	/**
	 * 	�ⷨ2:��̬�滮(��ά����)
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange1(int[] coins, int amount) {
		if(coins.length == 0)
            return -1;
		int N = coins.length;
		//����һ����ά����dp,������¼ÿ��״̬����СӲ����Ŀ
    	int [][] dp = new int[N][amount+1];
    	
    	//���˵�һ�У���Ӧj=0������ֵȫ��Ϊ�����
    	for (int i = 0; i < N; i++) {
    		Arrays.fill(dp[i],1,dp[i].length, Integer.MAX_VALUE);
		}
    	
    	//Ϊ��̬����ĵ�һ�и�ֵ����Ӧֻ��һ��Ӳ�ң�װ����������ʱ��Ҫ��Ӳ����Ŀ
    	//���j�ܱ�coins[0]���������ڶ�Ӧλ���Ϸ��ö�Ӧ��Ŀ��coins[0]
    	for (int j = 1; j <= amount; j++) {
			if(j % coins[0] == 0)
				dp[0][j] = j/coins[0];
		}
    	
    	//���dp[i][j]Ϊ�����˵����ǰ״̬�޷��ճ��ܽ��
    	for (int i = 1; i < N; i++) {
			for (int j = 1; j <= amount; j++) {
				/**
				 * �ڷ��õ�i��Ӳ�ҵ�ʱ������ܹ���k=j/coins[i]����i��Ӳ��
				 * 	�����0������ô��ǰӲ�Ҹ���Ϊ��v0=dp[i-1][j]
				 * 	�����1������ô��ǰӲ�Ҹ���Ϊ��v1=dp[i-1][j-coins[i]*1]+1��ǰ����dp[i-1][j-coins[i]*1]��ֵ����״̬(i-1,j-coins[i]*1)�н⡿
				 * 	�����2������ô��ǰӲ�Ҹ���Ϊ��v2=dp[i-1][j-coins[i]*2]+2��ǰ����dp[i-1][j-coins[i]*2]��ֵ����״̬(i-1,j-coins[i]*2)�н⡿
				 * 	......
				 * 	�����k������ô��ǰӲ�Ҹ���Ϊ��vk=dp[i-1][j-coins[i]*k]+k��ǰ����dp[i-1][j-coins[i]*k]��ֵ����״̬(i-1,j-coins[i]*k)�н⡿
				 * 	��ôdp[i][j]����ֵΪmin{v0,v1,v2...vk}
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
	 * 	�ⷨ3����̬�滮(һά����)
	 * @param coins
	 * @param amount
	 * @return
	 */
    public static int coinChange2(int[] coins, int amount) {
    	if(coins.length == 0)
            return -1;
    	
    	//����һ��amount+1���ȵ�����dp�����������ֵ��Ǯ������0��Ǯ���������ɵ��ܼ�ֵΪ0������ȫ����ʼ��Ϊ�����
    	//dp[j]����Ǯ�����ܼ�ֵΪjʱ������Ҫ������Ӳ�ҵĸ���
    	int[] dp = new int[amount+1];
    	Arrays.fill(dp,1,dp.length,Integer.MAX_VALUE);
    	
    	//i�������ʹ�õ�Ӳ��������i=2����ֻ�ڵ�0������1������2��������Ӳ����ѡ��Ӳ��
    	for (int i = 0; i < coins.length; i++) {
    		/**
    		 * 	�����ѭ��ִ��һ���Ժ�˵����ֻʹ��ǰi-1��Ӳ�ҵ�����£�����Ǯ��������Ӳ�Ҹ����Ѿ��õ���
    		 * 		��ЩǮ����ֵ���������˵���ڽ�ʹ��ǰi-1��Ӳ�ҵ�����£����ܴճ�Ǯ���ļ�ֵ
    		 * 	���ڿ�ʼ�ٷ����i��Ӳ�ң�Ҫ�����w[i]��Ǯ���ļ�ֵ��������j>=w[i]�������ڿ�ʼ�����i��Ӳ��ʱ��j��w[i]��ʼ
    		 */
			for (int j = coins[i]; j <= amount; j++) {
				/**
				 * 	���Ǯ����ǰ�ļ�ֵj�����������һ��w[i]����ô��Ҫ����Ȩ�⣬�Ի�ø��ٵ�Ӳ����
				 * 		�������0������ʱǮ������Ӳ�ҵĸ������ֲ��䣺 v0=dp[j]
				 * 		�������1������ʱǮ������Ӳ�ҵĸ���Ϊ��		v1=dp[j-coins[i]]+1
				 * 		 ��ǰ����dp[j-coins[i]]������ֵ�����dp[j-coins[i]]�������˵���޷��ճ�j-coins[i]��ֵ��Ǯ����
				 * 	              ��ô��w[i]�Ž�ȥ�Ժ���ȻҲ�ղ���dp[j]��Ǯ����
				 * 	���ԣ���ʱ��Ǯ����ֵΪjʱ�������Ӳ����ĿΪ dp[j]=min{v0,v1}
				 * 	���Ǯ����ǰ��ֵj�ܹ�����2��w[i]����Ҫ�ٽ���һ��Ȩ��
				 * 		��������˵�2��w[i]����ʱǮ������Ӳ����ĿΪ��v1=dp[j]=min{v0,v1}
				 * 		��������2��w[i],  ��ʱǮ������Ӳ����ĿΪ��v2=dp[j-coins[i]]+1
				 * 	���ԣ���Ǯ���ļ�ֵΪjʱ�������Ӳ����ĿΪdp[j]=min{v1,v2}=min{v0,v1,v2}
				 * 	Ǯ����ֵj���������3����4��.........w[i]�����ϸ���dp[j]�����õ��ڽ�ʹ��ǰi��Ӳ�ҵ�ʱ��ÿ��Ǯ���������Ӳ����Ŀ
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
	 * 	�ⷨ1���ݹ���ң����ϸ��¸�С��ֵ
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