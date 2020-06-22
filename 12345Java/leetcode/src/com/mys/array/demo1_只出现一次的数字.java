package com.mys.array;

import java.util.ArrayList;
import java.util.Arrays;

public class demo1_ֻ����һ�ε����� {

	public static void main(String[] args) {
		int[] arrs= {2,2,1,3,4,5,5,4,3};
		System.out.println(Solution1.singleNumber1(arrs));
	}

}

class Solution1 {
	/**
	 * ����һ�����飬�������Ԫ�ط���list�У������ǰԪ���Ѿ�������list�У����Ѿ����ڵ�Ԫ��ɾ��
	 * ���list��ʣ�µ�һ��Ԫ�ؾ���Ψһ��
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
     * ������ͬ�����������Ϊ0
     * �����е�Ԫ���������ͬ��Ԫ�ػᱻ������ʣ�µľ��ǳ���һ�ε�Ԫ��
     */
    public static int singleNumber1(int[] nums) {
    	int value=nums[0];
    	for (int i = 1; i < nums.length; i++) {
			value=value ^ nums[i];
		}
    	return value;
    }
}