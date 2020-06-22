package com.mys.dy_program;

import java.util.Arrays;

/**
 * 	给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 	输入: [10,9,2,5,3,7,101,18]
 *	输出: 4 
 *	解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 */
public class demo93_最长上升子序 {

	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		int len = Solution93.lengthOfLIS(nums);
		System.out.println(len);
	}

}
class Solution93 {
	/**
	 * 	解法1：动态规划
	 * 		用一个长度为N的数组dp记录每个状态的最优解
	 * 		dp[i]表示以第i个元素作为子序列的最后一个元素，可以得到的最大上升子序长度
	 * @param nums
	 * @return
	 */
    public static int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(nums[j] < nums[i] && dp[j]+1 > dp[i])
					dp[i] = dp[j]+1;
			}
		}
        int max = 0;
        for (int i = 0; i < N; i++) {
			if(max < dp[i])
				max = dp[i];
		}
    	return max;
    }
}