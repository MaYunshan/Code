package com.mys.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class demo4_判断数组元素是否重复 {

	public static void main(String[] args) {
		int[] arrs= {1,2,3,1};
		System.out.println(Solution4.containsDuplicate2(arrs));
	}

}
class Solution4 {
	/**
	 * 	将数组元素全部放入set。
	 * 	如果最后set的长度小于nums的长度，说明有重复元素，否则，说明数组中无重复元素
	 */
    public static boolean containsDuplicate(int[] nums) {
    	HashSet<Integer> set=new HashSet<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
        if (set.size()<nums.length) {
			return true;
		}
        return false;
    }
    
    public static boolean containsDuplicate1(int[] nums) {
    	HashMap<Integer, Boolean> map=new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
			if(map.get(nums[i])!=null) {
				return true;
			}
			map.put(nums[i], true);
		}
        return false;
    }
    
    /**
     * 先排序，然后判断
     */
    public static boolean containsDuplicate2(int[] nums) {
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]==nums[i+1]) {
				return true;
			}
		}
    	return false;
    }
    
}