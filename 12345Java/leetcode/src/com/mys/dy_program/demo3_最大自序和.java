package com.mys.dy_program;


/**
 * 	给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author dell
 *
 */
public class demo3_最大自序和 {

	public static void main(String[] args) {
		int[] arrs = {-2,1,-3,4,-1,2,1,-5,4};
		int ret = Solution4.maxSubArray2(arrs);
		System.out.println(ret);
	}

}
class Solution4 {
	/**
	 * 	暴力解法，穷举所有可能的子序，将子序结果相加，找出最大值
	 * @param nums
	 * @return
	 */
    public static int maxSubArray(int[] nums) {
    	int sum = 0;
    	//因为子数组最少包括一个元素，因此max的初始值设为nums[0]
    	int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
        	sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if(sum > max) {
					max = sum;
				}
			}
		}
    	return max;
    }
    
    /**
     * 	分治思想
     * 	利用一个数组dp来记录每一个位置处的最大的子序和
     * 		dp[i]表示以第i个字符为结尾的最大连续子序和
     * 		那么，dp[i+1]有且仅有两种情况
     * 			如果dp[i]>0，那么dp[i+1]=dp[i]+nums[i+1]
     * 			如果dp[i]<0,那么dp[i+1]=nums[i+1]
     * 		最后，找出dp数组中的最大值就可以了
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
    	//此处是将arr数组当做dp数组来使用
    	int n = nums.length;
    	for (int i = 1; i < n; i++) {
			if (nums[i-1] > 0) {
				nums[i] = nums[i-1] + nums[i];
			}
		}
    	int max = nums[0];
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i] > max) {
				max = nums[i];
			}
		}
        
    	return max;
    }
    
    
    public static int maxSubArray2(int[] nums) {
    	int n = nums.length;
    	int max = nums[0];
    	int sum = 0;
    	for (int i = 0; i < n; i++) {
			if(sum > 0) {
				sum = sum + nums[i];
			}
			else {
				sum = nums[i];
			}
			max = Math.max(max, sum);
		}
    	return max;
    }
}