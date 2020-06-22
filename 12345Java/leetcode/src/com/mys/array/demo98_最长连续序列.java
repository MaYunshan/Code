package com.mys.array;

import java.util.Arrays;

/**
 * 	给定一个未排序的整数数组，找出最长连续序列的长度。
 */
public class demo98_最长连续序列 {

	public static void main(String[] args) {
		int[] nums = {0,-1};
		int ret = Solution98.longestConsecutive(nums);
		System.out.println(ret);
		
	}

}

class Solution98 {
	/**
	 * 	先将数组排序，然后再寻找每个最长的子序列，不断更新最大长度
	 * @param nums
	 * @return
	 */
    public static int longestConsecutive(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	
        int ret = 1;
        int maxLength = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
        	//如果前后两个元素相等，依然有效，但是只计算一次
        	if (nums[i-1] == nums[i]) {
				continue;
			}
        	else if(nums[i-1] + 1 == nums[i])
				ret++;
			else {
				maxLength = Math.max(ret, maxLength);
				ret = 1;
			}
		}
        maxLength = Math.max(ret, maxLength);
        return maxLength;
    }
}