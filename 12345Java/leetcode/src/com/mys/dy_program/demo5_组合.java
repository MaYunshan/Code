package com.mys.dy_program;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class demo5_×éºÏ {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Stack<Integer> stack = new Stack<Integer>();
		perm(nums,0,list,3,stack);
		System.out.println(list);
	}

	private static void perm(int[] nums,int i, List<List<Integer>> list, int m, Stack<Integer> stack) {
		if(m == 0) {
			List<Integer> listNew = new ArrayList<Integer>();
			listNew.addAll(stack);
			list.add(listNew);
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
