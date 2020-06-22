package com.mys.design;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class demo1_����һ������ {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		Solution obj = new Solution(nums);
		int[] param_1 = obj.reset();
		int[] param_2 = obj.shuffle();
		
		System.out.println(Arrays.toString(param_1));
		System.out.println(Arrays.toString(param_2));
	}

}
class Solution {
	//����һ��������󣬱���ԭʼ���ݣ�ÿ�δ�������ʱ����������һ��������
	private int[] arrs = null;
    public Solution(int[] nums) {
        arrs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
			arrs[i] = nums[i];
		}
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
		return arrs;
        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int length = arrs.length;
    	int[] nums = new int[length];
    	Random rd = new Random();
    	
    	//����������
    	Set<Integer> set = new LinkedHashSet<Integer>();
    	while(set.size() < length) {
    		int x = rd.nextInt(length);
    		System.out.print(x+" ");
    		set.add(rd.nextInt(length));
    		
    	}
    	System.out.println(set);
    	int i = 0;
    	//����������и�ֵ��ÿһ��λ��ʱ���Һ������
    	for (Integer integer : set) {
			nums[i++] = arrs[integer]; 
		}
		return nums;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */