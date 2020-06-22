package com.mys.dy_program;


/**
 * 	����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 * @author dell
 *
 */
public class demo3_�������� {

	public static void main(String[] args) {
		int[] arrs = {-2,1,-3,4,-1,2,1,-5,4};
		int ret = Solution4.maxSubArray2(arrs);
		System.out.println(ret);
	}

}
class Solution4 {
	/**
	 * 	�����ⷨ��������п��ܵ����򣬽���������ӣ��ҳ����ֵ
	 * @param nums
	 * @return
	 */
    public static int maxSubArray(int[] nums) {
    	int sum = 0;
    	//��Ϊ���������ٰ���һ��Ԫ�أ����max�ĳ�ʼֵ��Ϊnums[0]
    	int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
        	sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if(sum > max) {
					max = sum;
				}
			}
		}
    	return max;
    }
    
    /**
     * 	����˼��
     * 	����һ������dp����¼ÿһ��λ�ô������������
     * 		dp[i]��ʾ�Ե�i���ַ�Ϊ��β��������������
     * 		��ô��dp[i+1]���ҽ����������
     * 			���dp[i]>0����ôdp[i+1]=dp[i]+nums[i+1]
     * 			���dp[i]<0,��ôdp[i+1]=nums[i+1]
     * 		����ҳ�dp�����е����ֵ�Ϳ�����
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
    	//�˴��ǽ�arr���鵱��dp������ʹ��
    	int n = nums.length;
    	for (int i = 1; i < n; i++) {
			if (nums[i-1] > 0) {
				nums[i] = nums[i-1] + nums[i];
			}
		}
    	int max = nums[0];
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i] > max) {
				max = nums[i];
			}
		}
        
    	return max;
    }
    
    
    public static int maxSubArray2(int[] nums) {
    	int n = nums.length;
    	int max = nums[0];
    	int sum = 0;
    	for (int i = 0; i < n; i++) {
			if(sum > 0) {
				sum = sum + nums[i];
			}
			else {
				sum = nums[i];
			}
			max = Math.max(max, sum);
		}
    	return max;
    }
}