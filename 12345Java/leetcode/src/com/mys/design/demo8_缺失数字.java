package com.mys.design;

import java.util.Arrays;
/**
 * ����һ������ 0, 1, 2, ..., n �� n ���������У��ҳ� 0 .. n ��û�г����������е��Ǹ�����
 * 	����: [3,0,1]
 *	���: 2
 * @author dell
 *
 */
public class demo8_ȱʧ���� {

	public static void main(String[] args) {

	}

}
class Solution8 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				return i;
			}
		}
    	return nums.length;
    }
    
    public int missingNumber1(int[] nums) {
    	
    	return nums.length;
    }
}