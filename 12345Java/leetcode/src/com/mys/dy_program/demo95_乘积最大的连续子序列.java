package com.mys.dy_program;

import java.util.Arrays;

/**
 * 	给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *	示例：
 *		输入: [2,3,-2,4]
 *		输出: 6
 *		解释: 子数组 [2,3] 有最大乘积 6。
 */
public class demo95_乘积最大的连续子序列 {

	public static void main(String[] args) {
		int[] nums = {2,-3,2,-4};
		Solution95 solution95 = new Solution95();
		int ret = solution95.maxProduct(nums);
		System.out.println(ret);
		
		int ret1 = solution95.maxProduct1(nums);
		System.out.println(ret1);
	}

}
class Solution95 {
	/**
	 * 	暴力解法：
	 * 		遍历所有肯能的连续子序列，算出乘积，取最大值
	 * @param nums
	 * @return
	 */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int mul = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
			dp[i] = nums[i];
		}
        
        for (int i = 0; i < nums.length; i++) {
        	mul = 1;
			for (int j = i; j < nums.length; j++) {
				mul = mul * nums[j];
				dp[j] = dp[j] > mul ? dp[j] : mul;
			}
		}
        
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
			max = max > dp[i] ? max : dp[i];
		}
        return max;
    }
    
    /**
     * 	动态规划：
     * 		用一个变量imax记录nums[0...i]乘积的最大值，用一个变量imin记录nums[0...i]乘积的最小值，用一个变量ret记录nums[0...i]乘积的最大值
     * 		如果已经得到了nums[0...i]的最大值ret，那么当计算nums[i+1]时，有可能使得结果变得更大(乘以正数)，也有可能变得更小(乘以负数)
     * 		所以，当遍历第i个数时，最大值和最小值需要分别记录
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int min = nums[0];
        int max = nums[0];
        int ret = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	if(nums[i] < 0) {
        		int temp = min;
        		min = max;
        		max = temp;
        	}
			min = Math.min(min*nums[i], nums[i]);
			max = Math.max(max*nums[i], nums[i]);
			ret = Math.max(ret, max);
		}
        return ret;
    }
}