package com.mys.array;

import java.util.Arrays;

/**
 * 	��������Ϊ n ���������� nums������ n > 1������������� output ������ output[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻���
 *	���룺 [ 1,2,3,4]
 *	�����[ 24,12,8,6]
 */
public class demo95_exceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] exceptSelf = Solution95.productExceptSelf(nums);
		System.out.println(Arrays.toString(exceptSelf));
		
		int[] exceptSelf1 = Solution95.productExceptSelf1(nums);
		System.out.println(Arrays.toString(exceptSelf1));
	}

}
class Solution95 {
	/**
	 * 	�ⷨ1��ʹ���������飬�ֱ��¼λ��i��ߵ��ۻ����ұߵ��ۻ�����󣬶�Ӧλ�ô����ۻ���˼��ɵõ����
	 * @param nums
	 * @return
	 */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
			return nums;
		}
        
        int length = nums.length;
        
        //��¼�����е�i��Ԫ���������Ԫ�صĳ˻�
        int[] leftNums = new int[nums.length];
        //��¼�����е�i��Ԫ���ұ�����Ԫ�صĳ˻�
        int[] rightNums = new int[nums.length];
        
        //�ۻ�����
        int left = 1;
        int right = 1;
        
        for (int i = 0; i < length; i++) {
        	//��¼��i��Ԫ�����֮ǰ���ۻ�������������nums[i]
			leftNums[i] = left;
			//����ۻ���������num[i],����һ��ѭ���и���leftNums[i+1]
			left = left*nums[i];
			
			//����i��Ԫ��֮������Ԫ�ص��ۻ��������rightNums[length-1-i]��������nums[length-1-i]
			rightNums[length-1-i] = right;
			//�ұ��ۻ���������nums[length-1-i],����һ��ѭ���и���rightNums[length-1-i-1]
			right = right *nums[length-1-i];
		}
        
        //ÿһ��λ�ô��Ľ����Ӧ���ǵ�ǰλ���������Ԫ�ص��ۻ����Ե�ǰλ���ұ�����Ԫ�ص��ۻ�
        for (int i = 0; i < length; i++) {
			leftNums[i] = leftNums[i] * rightNums[i];
		}
    	return leftNums;
    }
    
    /**
	 * 	�ⷨ2��ʹ���������飬�ֱ��¼λ��i��ߵ��ۻ����ұߵ��ۻ�����󣬶�Ӧλ�ô����ۻ���˼��ɵõ����
	 * @param nums
	 * @return
	 */
    public static int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) {
			return nums;
		}
        
        int length = nums.length;
        
        //��¼�����е�i��Ԫ���������Ԫ�صĳ˻�
        int[] leftNums = new int[nums.length];
        
        //�ۻ�����
        int left = 1;
        int right = 1;
        
        for (int i = 0; i < length; i++) {
        	//��¼��i��Ԫ�����֮ǰ���ۻ�������������nums[i]
			leftNums[i] = left;
			//����ۻ���������num[i],����һ��ѭ���и���leftNums[i+1]
			left = left*nums[i];
		}
        
        //��Ϊÿ��λ��i������ߵ��ۻ��Ѿ��õ����Ӻ���ǰ�������飬��right��¼λ��i�ұߵ��ۻ�
        for (int i = length-1; i >=0; i--) {
        	leftNums[i] = leftNums[i]*right;
        	right = right*nums[i];
		}
    	return leftNums;
    }
}