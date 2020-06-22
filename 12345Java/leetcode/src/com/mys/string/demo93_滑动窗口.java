package com.mys.string;

import java.util.Arrays;

/**
 * 	给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 		你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。返回滑动窗口最大值。
 *	示例:
 *	输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 *	输出: [3,3,5,5,6,7] 
 */
public class demo93_滑动窗口 {

	public static void main(String[] args) {
		int[] nums = {-7,-8,7,5,7,1,6,0};
		int k = 4;
		
		int[] ret = Solution93.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(ret));
		
	}

}
class Solution93 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums.length == 0 || k == 0)
    		return new int[0];
        int[] ret = new int [nums.length - k + 1]; 
        int left = 0;
        int right = k-1;
        int index = 0;
        
        while(right < nums.length) {
        	//如果新加入窗口的元素比上一个窗口的最大值还要大，那么新窗口的最大值就是新加入的值
        	if(left != 0 && nums[right] > nums[index]) {
        		ret[left] = nums[right];
        		index = right;
        	}
        	//如果上一个窗口的最大值是上一个窗口的第一个值，新窗口的最大值要重新寻找
        	else if(left == 0 || index == left-1) {
        		index = getMaxIndex(nums, left, right);
        		ret[left] = nums[index];
        	}
        	//否则，新窗口的最大值不变
        	else
				ret[left] = nums[index];
        	
        	//窗口向右滑动一位
        	left++;
        	right++;
        	
        }
         
        return ret;
    }
    
    public static int getMaxIndex(int[] nums, int left, int right) {
    	int index = left;
		for (int i = left+1; i <= right; i++) {
			if(nums[i] > nums[index])
				 index = i;
		}
		return index;
	}
}