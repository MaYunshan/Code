package com.mys.easy;

import java.util.Arrays;

public class demo9_向右旋转数组 {

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6};
		Solution9.rotate(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

}
class Solution9 {
    public static void rotate(int[] nums, int k) {
    	//如果移动的位数大于数组的长度，则循环移动
    	int length=nums.length;
        int n=k%(length);
        int m=length-n;  //前面m个元素不需要掉头
        int value=0;
        for (int i = 0; i < m; i++) {
        	value=nums[length-1-i];
        	nums[length-1-i]=nums[length-1-i-n];
        }
        
        for (int i = 0; i < n; i++) {
			value=nums[i];
			nums[i]=nums[m+i];
		}
        
    }
}