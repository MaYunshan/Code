package com.mys.dy_program;

import java.util.Arrays;

/**
 * 	����һ���������� nums ���ҳ�һ�������г˻��������������У����������ٰ���һ��������
 *	ʾ����
 *		����: [2,3,-2,4]
 *		���: 6
 *		����: ������ [2,3] �����˻� 6��
 */
public class demo95_�˻��������������� {

	public static void main(String[] args) {
		int[] nums = {2,-3,2,-4};
		Solution95 solution95 = new Solution95();
		int ret = solution95.maxProduct(nums);
		System.out.println(ret);
		
		int ret1 = solution95.maxProduct1(nums);
		System.out.println(ret1);
	}

}
class Solution95 {
	/**
	 * 	�����ⷨ��
	 * 		�������п��ܵ����������У�����˻���ȡ���ֵ
	 * @param nums
	 * @return
	 */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int mul = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
			dp[i] = nums[i];
		}
        
        for (int i = 0; i < nums.length; i++) {
        	mul = 1;
			for (int j = i; j < nums.length; j++) {
				mul = mul * nums[j];
				dp[j] = dp[j] > mul ? dp[j] : mul;
			}
		}
        
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
			max = max > dp[i] ? max : dp[i];
		}
        return max;
    }
    
    /**
     * 	��̬�滮��
     * 		��һ������imax��¼nums[0...i]�˻������ֵ����һ������imin��¼nums[0...i]�˻�����Сֵ����һ������ret��¼nums[0...i]�˻������ֵ
     * 		����Ѿ��õ���nums[0...i]�����ֵret����ô������nums[i+1]ʱ���п���ʹ�ý����ø���(��������)��Ҳ�п��ܱ�ø�С(���Ը���)
     * 		���ԣ���������i����ʱ�����ֵ����Сֵ��Ҫ�ֱ��¼
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        int min = nums[0];
        int max = nums[0];
        int ret = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	if(nums[i] < 0) {
        		int temp = min;
        		min = max;
        		max = temp;
        	}
			min = Math.min(min*nums[i], nums[i]);
			max = Math.max(max*nums[i], nums[i]);
			ret = Math.max(ret, max);
		}
        return ret;
    }
}