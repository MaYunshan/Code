package com.mys.string;

import java.util.Arrays;

/**
 * 	����һ������ nums����һ����СΪ k �Ļ������ڴ������������ƶ�����������Ҳࡣ
 * 		��ֻ���Կ����ڻ������� k �ڵ����֡���������ÿ��ֻ�����ƶ�һλ�����ػ����������ֵ��
 *	ʾ��:
 *	����: nums = [1,3,-1,-3,5,3,6,7], �� k = 3
 *	���: [3,3,5,5,6,7] 
 */
public class demo93_�������� {

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
        	//����¼��봰�ڵ�Ԫ�ر���һ�����ڵ����ֵ��Ҫ����ô�´��ڵ����ֵ�����¼����ֵ
        	if(left != 0 && nums[right] > nums[index]) {
        		ret[left] = nums[right];
        		index = right;
        	}
        	//�����һ�����ڵ����ֵ����һ�����ڵĵ�һ��ֵ���´��ڵ����ֵҪ����Ѱ��
        	else if(left == 0 || index == left-1) {
        		index = getMaxIndex(nums, left, right);
        		ret[left] = nums[index];
        	}
        	//�����´��ڵ����ֵ����
        	else
				ret[left] = nums[index];
        	
        	//�������һ���һλ
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