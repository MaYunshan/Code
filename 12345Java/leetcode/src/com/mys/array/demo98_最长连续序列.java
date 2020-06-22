package com.mys.array;

import java.util.Arrays;

/**
 * 	����һ��δ������������飬�ҳ���������еĳ��ȡ�
 */
public class demo98_��������� {

	public static void main(String[] args) {
		int[] nums = {0,-1};
		int ret = Solution98.longestConsecutive(nums);
		System.out.println(ret);
		
	}

}

class Solution98 {
	/**
	 * 	�Ƚ���������Ȼ����Ѱ��ÿ����������У����ϸ�����󳤶�
	 * @param nums
	 * @return
	 */
    public static int longestConsecutive(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	
        int ret = 1;
        int maxLength = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
        	//���ǰ������Ԫ����ȣ���Ȼ��Ч������ֻ����һ��
        	if (nums[i-1] == nums[i]) {
				continue;
			}
        	else if(nums[i-1] + 1 == nums[i])
				ret++;
			else {
				maxLength = Math.max(ret, maxLength);
				ret = 1;
			}
		}
        maxLength = Math.max(ret, maxLength);
        return maxLength;
    }
}