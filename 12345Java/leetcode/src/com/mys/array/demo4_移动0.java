package com.mys.array;

import java.util.Arrays;

public class demo4_移动0 {

	public static void main(String[] args) {
		int[] arr= {0,1,0,0,0,1,2,5,7,9,0,8};
		Solution4.moveZeroes1(arr);
		System.out.println(Arrays.toString(arr));
	}

}

class Solution4 {
	
	/*
	 * 	从后往前遍历数组
	 * 	每次找到一个0
	 */
    public static void moveZeroes(int[] nums) {
    	int k=nums.length-1;
        for (int i = nums.length-1; i >= 0 ; i--) {
			if(nums[i]==0) {
				swap(nums,i,k);
				k--;
			}
		}
    }

	private static void swap(int[] nums, int i, int k) {
		for (int j = i; j < k; j++) {
			int temp=nums[j];
			nums[j]=nums[j+1];
			nums[j+1]=temp;
		}
	}

	/*
	 * 	直接将非0数字往前移，然后统计0出现的次数，最后补0即可
	 */
	public static void moveZeroes1(int[] nums) {
		int j=0;
		//指针i用来遍历数组的每一个元素，如果碰到非0的数组，往前移动
		//指针j用来指向第一个0，j之前的元素都是非0的，
        for (int i = 0; i < nums.length; i++) {
        	if(nums[i]!=0) {
        		if (j!=i) {
        			nums[j]=nums[i];
				}
        		j++;
        	}
        }
        for (int i = j; i < nums.length; i++) {
			nums[i]=0;
		}
	}
}