package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;

public class demo4_ȫ���� {

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
     * 	���ֻ��һ��Ԫ��a����ôֻ��һ�����
     * 	���������Ԫ��a,b,a��b֮ǰ��a��b֮���������
     * 	���������Ԫ��a,b,c,�ֱ���a��b��c��ͷ��Ȼ���������Ԫ���໥����˳��һ��6��
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
	
	//�����н�������λ�ô���Ԫ��
	private static void swap(int[] nums,int i,int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}