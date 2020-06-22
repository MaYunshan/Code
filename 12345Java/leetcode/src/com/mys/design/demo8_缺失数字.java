package com.mys.design;

import java.util.Arrays;
/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 	输入: [3,0,1]
 *	输出: 2
 * @author dell
 *
 */
public class demo8_缺失数字 {

	public static void main(String[] args) {

	}

}
class Solution8 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				return i;
			}
		}
    	return nums.length;
    }
    
    public int missingNumber1(int[] nums) {
    	
    	return nums.length;
    }
}