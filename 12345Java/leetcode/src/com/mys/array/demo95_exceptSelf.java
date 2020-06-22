package com.mys.array;

import java.util.Arrays;

/**
 * 	给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *	输入： [ 1,2,3,4]
 *	输出：[ 24,12,8,6]
 */
public class demo95_exceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] exceptSelf = Solution95.productExceptSelf(nums);
		System.out.println(Arrays.toString(exceptSelf));
		
		int[] exceptSelf1 = Solution95.productExceptSelf1(nums);
		System.out.println(Arrays.toString(exceptSelf1));
	}

}
class Solution95 {
	/**
	 * 	解法1：使用两个数组，分别记录位置i左边的累积和右边的累积，最后，对应位置处的累积相乘即可得到结果
	 * @param nums
	 * @return
	 */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
			return nums;
		}
        
        int length = nums.length;
        
        //记录数组中第i个元素左边所有元素的乘积
        int[] leftNums = new int[nums.length];
        //记录数组中第i个元素右边所有元素的乘积
        int[] rightNums = new int[nums.length];
        
        //累积变量
        int left = 1;
        int right = 1;
        
        for (int i = 0; i < length; i++) {
        	//记录第i个元素左边之前的累积变量，不包括nums[i]
			leftNums[i] = left;
			//左边累积变量乘以num[i],在下一次循环中赋给leftNums[i+1]
			left = left*nums[i];
			
			//将第i个元素之后所有元素的累积结果赋给rightNums[length-1-i]，不包括nums[length-1-i]
			rightNums[length-1-i] = right;
			//右边累积变量乘以nums[length-1-i],在下一次循环中赋给rightNums[length-1-i-1]
			right = right *nums[length-1-i];
		}
        
        //每一个位置处的结果，应该是当前位置左边所有元素的累积乘以当前位置右边所有元素的累积
        for (int i = 0; i < length; i++) {
			leftNums[i] = leftNums[i] * rightNums[i];
		}
    	return leftNums;
    }
    
    /**
	 * 	解法2：使用两个数组，分别记录位置i左边的累积和右边的累积，最后，对应位置处的累积相乘即可得到结果
	 * @param nums
	 * @return
	 */
    public static int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) {
			return nums;
		}
        
        int length = nums.length;
        
        //记录数组中第i个元素左边所有元素的乘积
        int[] leftNums = new int[nums.length];
        
        //累积变量
        int left = 1;
        int right = 1;
        
        for (int i = 0; i < length; i++) {
        	//记录第i个元素左边之前的累积变量，不包括nums[i]
			leftNums[i] = left;
			//左边累积变量乘以num[i],在下一次循环中赋给leftNums[i+1]
			left = left*nums[i];
		}
        
        //因为每个位置i处的左边的累积已经得到，从后往前遍历数组，用right记录位置i右边的累积
        for (int i = length-1; i >=0; i--) {
        	leftNums[i] = leftNums[i]*right;
        	right = right*nums[i];
		}
    	return leftNums;
    }
}