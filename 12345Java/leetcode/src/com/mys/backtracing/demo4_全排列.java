package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;

public class demo4_全排列 {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> list = Solution4.permute(nums);
		System.out.println(list);
	}

}
class Solution4 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        perm(lists,nums,0);
        return lists;
    }

    /**
     * 	如果只有一个元素a，那么只有一种组合
     * 	如果有两个元素a,b,a在b之前，a在b之后，两种组合
     * 	如果有三个元素a,b,c,分别以a，b，c开头，然后后面两个元素相互交换顺序，一共6种
     * @param lists
     * @param nums
     * @param index
     */
	private static void perm(List<List<Integer>> lists, int[] nums, int index) {
		if(index == nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			lists.add(list);
			return;
		}
		
		for (int i = index; i < nums.length; i++) {
			swap(nums, i, index);
			perm(lists, nums, index+1);
			swap(nums, i, index);
		}
		
		
	}
	
	//数组中交换两个位置处的元素
	private static void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}