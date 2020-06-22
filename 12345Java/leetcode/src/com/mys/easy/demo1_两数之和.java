package com.mys.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class demo1_两数之和 {

	/**
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 */
	public static void main(String[] args) {
		int[] nums= {2,2};
		int[] nums1= {3,4,6,7,8,9};
		int target=15;
		int[] result=Solution.twoSum2(nums1, target);
		System.out.println(Arrays.toString(result));
	}

}
class Solution {
	
	/**
	   *  第一种方法，两层for循环。暴力解法。
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] twoSum(int[] nums, int target) {
        
        for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length && j != i ; j++) {
				if(nums[i]+nums[j]==target) {
					return new int[]{i,j};
				}
			}
		}
        throw new IllegalArgumentException("No Find!");
    }
    
    /**
     *  方法2：采用hashMap，第一遍先将所有的数组元素放入map中，第二遍寻找
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        LinkedHashMap<Integer, Integer> map=new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],i);
		}
        System.out.println(map);
        for (Integer key : map.keySet()) {
			int other=target-key;
			
			if( map.containsKey(other) ) {
				return new int[]{map.get(key),map.get(other)};
			}
		}
        
        throw new IllegalArgumentException("No Find!");
    }
    
    /**
     * 方法3：终极方法，
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
    	Integer[] result=new Integer[2];
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        
        //第一次遍历数组
        for (int i = 0; i < nums.length; i++) {
        	//如果target为偶数，那么有可能在数组中存在两个相同的数使得和为target，这种情况下不能加入map，因为map中的key是无重复的。
        	if(target%2==0 && target/2==nums[i]) {
        		if(result[0]==null) {
        			//第一次找到target/2的数，将其保存，因为数组中有可能还存在这个数
        			result[0]=i;
        		}
        		else {
        			//第二次找到target/2，这时候就找到了两个相同的数，它们的和为target
        			result[1]=i;
        		}
        	}
        	else {
        		//如果不存在上述满足条件的数组元素，以数组元素作为key，下标作为value，加入map
        		map.put(nums[i],i);
        	}
		}
        
        //第二次遍历数组
        if(result[0]==null || result[1]==null) {
        	for (Integer key : map.keySet()) {
    			int other=target-key;
    			
    			if(map.containsKey(other) ) {
    				return new int[]{map.get(key),map.get(other)};
    			}
    		}
        }
        else {
        	//如果在数组中找到了相同的两个数，它们的和为target,返回即可
        	return new int[] {result[0],result[1]};
        }
        throw new IllegalArgumentException("No Find!");
    }
}