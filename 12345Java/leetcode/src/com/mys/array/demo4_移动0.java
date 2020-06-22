package com.mys.array;

import java.util.Arrays;

public class demo4_�ƶ�0 {

	public static void main(String[] args) {
		int[] arr= {0,1,0,0,0,1,2,5,7,9,0,8};
		Solution4.moveZeroes1(arr);
		System.out.println(Arrays.toString(arr));
	}

}

class Solution4 {
	
	/*
	 * 	�Ӻ���ǰ��������
	 * 	ÿ���ҵ�һ��0
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
	 * 	ֱ�ӽ���0������ǰ�ƣ�Ȼ��ͳ��0���ֵĴ��������0����
	 */
	public static void moveZeroes1(int[] nums) {
		int j=0;
		//ָ��i�������������ÿһ��Ԫ�أ����������0�����飬��ǰ�ƶ�
		//ָ��j����ָ���һ��0��j֮ǰ��Ԫ�ض��Ƿ�0�ģ�
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