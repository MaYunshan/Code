package com.mys.dy_program;

/**
 * 
 * 	����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�
 * 	Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * 	����һ������ÿ�����ݴ�Ž��ķǸ��������飬�������ڲ���������װ�õ�����£��ܹ�͵�Ե�����߽�
 *
 */
public class demo4_��ҽ��� {

	public static void main(String[] args) {
		int[] arr1 = {2,5,1,2};
		int[] arr2 = {2,7,9,3,1,5,4,6};
		
		System.out.println(Solution5.rob1(arr1));
		System.out.println(Solution5.rob1(arr2));
	}

}
class Solution5 {
	/**
	 * 	��ÿһ�������ȥ�ܻ�õ���������ǹ̶���
	 * 	����һ��dp�����¼��ÿһ�������ȥ���Ի�õ��������
	 * 	dp[i]��ʾ�ӵ�i�������ȥ�����͵���Ժ���������
	 * @param nums
	 * @return
	 */
    public static int rob(int[] nums) {
    	//����һ������Ϊn��dp���鲢�ҳ�ʼ��Ϊ-1
    	int[] dp = new int[nums.length];
    	for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
    	//�ӵ�0�������ȥ��õ�����
        recuRob(nums,0,nums.length,dp);
        //�ӵ�1�������ȥ��õ�����
        recuRob(nums,1,nums.length,dp);
        //��Ƚϣ��õ����ֵ
        return dp[0] > dp[1] ? dp[0] : dp[1];
    }

	private static int recuRob(int[] nums, int i,int n, int[] dp) {
		//�ݹ�Ľ�����������ǰ�����ķ���ų����������ݹ����������0
		if(i >= n) {
			return 0;
		}
		//��Ϊdp[i]�ϼ�¼�˴�i�����ȥ��������룬��ˣ����dp[i]��Ϊ��ʼֵ-1��
		//˵���ӷ���i��ȥ�Ժ����������Ѿ����ˣ�����Ҫ�ٱ�����ֱ�ӷ���
		if(dp[i] > -1) {
			return dp[i];
		}
		//a������¼�ӷ���i��ȥ��Ȼ���ٴ�i+2�����ȥ�Ժ������
		int a = nums[i]+recuRob(nums, i+2,n,dp);
		//b������¼�ӷ���i��ȥ��Ȼ���ٴ�i+3�����ȥ�Ժ������
		int b = nums[i]+recuRob(nums, i+3,n,dp);
		//dp[i]����a��b�еĽϴ�ֵ
		dp[i] = a > b ? a : b;
		return dp[i];
	}
	
	
	/**
	 * 	�ⷨ2������
	 * 	Ҳ��һ��dp�����¼�ӵ�ǰ�������ʱ���Ի�õ�����
	 * 	dp[i]��ʾ͵���i�������Ժ��õ�������
	 * 		dp[0]��ʾ�ӵ�0���������ʱ��õ����룺dp[0]=nums[0]
	 * 		dp[1]��ʾ�ӵ�1���������ʱ��õ����룺dp[1]Ϊnums[0]��nums[1]�е����ֵ
	 * 		�ڼ���dp[i]ʱ��Ҫ��������ֵ
	 * 				����Ǵ���һ����������ģ���ô��ǰ���䲻��͵���������dp[i-1]��
	 * 				����Ǵ�����һ����������ģ���ǰ�������͵���������Ϊdp[i]+nums[i]
	 * 		������ֵ�����ֵ���Ǵ�i�������ʱ���������
	 * 
	 */
	public static int rob1(int[] nums) {
    	if(nums.length == 0)
    		return 0;
    	else if(nums.length == 1)
    		return nums[0];
    	else {
    		int n = nums.length;
    		int[] dp = new int[n];
    		dp[0] = nums[0];
    		dp[1] = dp[0] > nums[1] ? dp[0] :nums[1];
    		for (int i = 2; i < dp.length; i++) {
				dp[i] = dp[i-1] > (nums[i] + dp[i-2]) ? dp[i-1] : (nums[i] + dp[i-2]);
			}
    		return dp[n-1];
    	}
    }
}