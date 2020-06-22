package com.mys.array;

import java.util.Arrays;

public class demo8_合并两个有序数组 {
	public static void main(String[] args) {
		int[] nums1 = {1,2,4,5,6,0};
		int[] nums2 = {3,0,0};
		
		Solution8.merge(nums1, 5, nums2, 1);
		
		System.out.println(Arrays.toString(nums1));
	}
}
class Solution8 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	//把数组1中的所有元素后移n位
        for (int i = m-1; i >= 0; i--) {
			nums1[n+i] = nums1[i];
		}
        
        //开始归并
        int i = 0;    				//指针i指向nums2中当前正在遍历的元素
        int j = n;					//指针j指向nums1中当前正在遍历的元素
        int k = 0;					//指针k指向新数组的元素
        
        while(i < n && j < m+n) {
        	if(nums1[j] < nums2[i]) {
        		nums1[k] = nums1[j];
        		j++;
        	}
        	else {
        		nums1[k] = nums2[i];
        		i++;
        	}
        	k++;
        }
        while(i < n) {
        	nums1[k] = nums2[i];
    		i++;
    		k++;
        }
        while(j < m+n) {
        	nums1[k] = nums1[j];
    		j++;
    		k++;
        }
    }
}