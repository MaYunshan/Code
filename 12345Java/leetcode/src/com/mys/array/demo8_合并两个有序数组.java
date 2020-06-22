package com.mys.array;

import java.util.Arrays;

public class demo8_�ϲ������������� {
	public static void main(String[] args) {
		int[] nums1 = {1,2,4,5,6,0};
		int[] nums2 = {3,0,0};
		
		Solution8.merge(nums1, 5, nums2, 1);
		
		System.out.println(Arrays.toString(nums1));
	}
}
class Solution8 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	//������1�е�����Ԫ�غ���nλ
        for (int i = m-1; i >= 0; i--) {
			nums1[n+i] = nums1[i];
		}
        
        //��ʼ�鲢
        int i = 0;    				//ָ��iָ��nums2�е�ǰ���ڱ�����Ԫ��
        int j = n;					//ָ��jָ��nums1�е�ǰ���ڱ�����Ԫ��
        int k = 0;					//ָ��kָ���������Ԫ��
        
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