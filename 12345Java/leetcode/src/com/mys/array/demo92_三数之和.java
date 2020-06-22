package com.mys.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 要求：
 * 		元素可以重复使用
 * 		三元组不可以重复
 * @author dell
 *
 */
public class demo92_三数之和 {

	public static void main(String[] args) {

		int[] nums = {0,-1,0,1,0};
		Arrays.sort(nums);
		List<List<Integer>> sum = Solution92.threeSum(nums);
		System.out.println(sum);
	}

}
class Solution92 {
	/**
	 * 解法1：暴力解法，三层for循环,
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> threeSum(int[] nums) {
    	boolean flag0 = false;
    	List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        for (int i = 0; i < nums.length -2; i++) {
        	if(nums[i] > 0)
        		break;
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if(nums[i] + nums[j] + nums[k] == 0) {
						if(nums[i] == 0 && nums[k] == 0) {
							flag0 = true;
						}else {
							List<Integer> list1 = new ArrayList<Integer>();
							list1.add(nums[i]);
							list1.add(nums[j]);
							list1.add(nums[k]);
							
							int m = 0;
							for (; m < list.size(); m++) {
								List<Integer> keyList = list.get(m);
								if(keyList.containsAll(list1)) {
									break;
								}
							}
							if(m == list.size()) {
								list.add(list1);
							}
						}
						
					}
				}
			}
		}
        if(flag0 == true) {
        	list.add(Arrays.asList(0,0,0));
        }
        return list;
    }
    
    /**
     * 解法2：先把n个数中选出3个进行组合
     * 		然后把所有组合遍历一遍，找出符合条件的组合
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>(); 
    	Stack< Integer> stack = new Stack<Integer>();
    	perm(nums, 0, list, 3, stack);
        return list;
    }
    
    private static void perm(int[] nums,int i, List<List<Integer>> list, int m, Stack<Integer> stack) {
		if(m == 0) {
			if (stack.get(0) + stack.get(1) + stack.get(2) == 0) {
				List<Integer> listNew = new ArrayList<Integer>();
				listNew.addAll(stack);
				int j = 0;
				for (; j < list.size(); j++) {
					List<Integer> keyList = list.get(j);
					if(keyList.containsAll(listNew) && listNew.containsAll(keyList)) {
						break;
					}
				}
				if(j == list.size()) {
					list.add(listNew);
				}
			}
			return;
		}
		if(i == nums.length)
			return;
		
		stack.push(nums[i]);
		perm(nums, i+1, list, m-1, stack);
		stack.pop();
		
		perm(nums, i+1, list, m, stack);
	}
}