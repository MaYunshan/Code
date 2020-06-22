package com.mys.design;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class demo1_打乱一个数组 {

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
	//声明一个数组对象，保存原始数据，每次打乱数组时都重新声明一个新数组
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
    	
    	//将索引打乱
    	Set<Integer> set = new LinkedHashSet<Integer>();
    	while(set.size() < length) {
    		int x = rd.nextInt(length);
    		System.out.print(x+" ");
    		set.add(rd.nextInt(length));
    		
    	}
    	System.out.println(set);
    	int i = 0;
    	//对新数组进行赋值，每一个位置时打乱后的索引
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