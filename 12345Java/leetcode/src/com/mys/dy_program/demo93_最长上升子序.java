package com.mys.dy_program;

import java.util.Arrays;

/**
 * 	����һ��������������飬�ҵ���������������еĳ��ȡ�
 * 	����: [10,9,2,5,3,7,101,18]
 *	���: 4 
 *	����: ��������������� [2,3,7,101]�����ĳ����� 4��
 *
 */
public class demo93_��������� {

	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		int len = Solution93.lengthOfLIS(nums);
		System.out.println(len);
	}

}
class Solution93 {
	/**
	 * 	�ⷨ1����̬�滮
	 * 		��һ������ΪN������dp��¼ÿ��״̬�����Ž�
	 * 		dp[i]��ʾ�Ե�i��Ԫ����Ϊ�����е����һ��Ԫ�أ����Եõ�������������򳤶�
	 * @param nums
	 * @return
	 */
    public static int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if(nums[j] < nums[i] && dp[j]+1 > dp[i])
					dp[i] = dp[j]+1;
			}
		}
        int max = 0;
        for (int i = 0; i < N; i++) {
			if(max < dp[i])
				max = dp[i];
		}
    	return max;
    }
}