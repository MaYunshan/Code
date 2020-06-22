package com.mys.array;

import java.util.ArrayList;
import java.util.Arrays;

public class demo1_只出现一次的数字 {

	public static void main(String[] args) {
		int[] arrs= {2,2,1,3,4,5,5,4,3};
		System.out.println(Solution1.singleNumber1(arrs));
	}

}

class Solution1 {
	/**
	 * 遍历一遍数组，并逐个将元素放入list中，如果当前元素已经存在于list中，则将已经存在的元素删除
	 * 最后list中剩下的一个元素就是唯一的
	 */
    public static int singleNumber(int[] nums) {
    	int value=0;
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	for (int i = 0; i < nums.length; i++) {
			if(list.contains(nums[i])) {
				list.remove(list.indexOf(nums[i]));
			}
			else {
				list.add(nums[i]);
			}
		}
    	value=list.get(0);
    	return value;
    }
    
    /**
     * 两个相同数相异或，其结果为0
     * 把所有的元素累异或，相同的元素会被消除，剩下的就是出现一次的元素
     */
    public static int singleNumber1(int[] nums) {
    	int value=nums[0];
    	for (int i = 1; i < nums.length; i++) {
			value=value ^ nums[i];
		}
    	return value;
    }
}