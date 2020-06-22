package com.mys.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class demo4_�ж�����Ԫ���Ƿ��ظ� {

	public static void main(String[] args) {
		int[] arrs= {1,2,3,1};
		System.out.println(Solution4.containsDuplicate2(arrs));
	}

}
class Solution4 {
	/**
	 * 	������Ԫ��ȫ������set��
	 * 	������set�ĳ���С��nums�ĳ��ȣ�˵�����ظ�Ԫ�أ�����˵�����������ظ�Ԫ��
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
     * ������Ȼ���ж�
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