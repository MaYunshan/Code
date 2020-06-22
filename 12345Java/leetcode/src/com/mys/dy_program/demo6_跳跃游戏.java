package com.mys.dy_program;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 *	�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 *	�ж����Ƿ��ܹ��������һ��λ�á�
 * @author dell
 *
 */
public class demo6_��Ծ��Ϸ {

	public static void main(String[] args) {
		int[] nums = {3,0,0,5,4};
		boolean ret = Solution6.canJump(nums);
		System.out.println(ret);
	}

}
class Solution6 {
	public static boolean canJump1(int[] nums) {
		//��һ��dp��������ʾ��ÿ��λ�ô��ܹ���������Χ��
		//������ÿһ��λ�ô��ܹ���������Χ�����maxstep>=nums.length-1��˵���ܹ��������һ��λ��
    	int maxStep = 0;
    	for (int i = 0; i < nums.length; i++) {
    		//�����ǰλ��i����һ���ĸ��Ƿ�Χ�ڣ�˵�����ܹ�����λ��i��ͬʱ�������λ��i���ĸ��Ƿ�Χ������һ��λ�õĸ��Ƿ�Χ������maxStep
			if(maxStep >= i && i+nums[i] > maxStep) {
				maxStep = i + nums[i];
			}
			//���λ��i���ĸ��Ƿ�Χ�Ѿ����������һ��λ�ã�˵���ܹ�����
			if(maxStep >= nums.length - 1)
				return true;
		}
    	return false;
    }
	
	//int[] nums = {7,5,9,4,2,6,8,3,5,4,3,9};
			//{7 5 9 4 2 6 8 3 5 4 3 9}
	
	
    public static boolean canJump(int[] nums) {
    	//�ⷨ1���ݹ�����
    	//return dfs(0,nums);
    	
    	//�ⷨ2
    	if(nums.length < 2)
    		return true;
    	int length = nums.length;
    	int step = 1;
    	//�ӵ�����2��Ԫ�ؿ�ʼ��ǰ���������������2��Ԫ���ܵ������һ��Ԫ�أ���ô�����һ��Ԫ��ɾ��������ת��Ϊ�Ƿ��ܵ��ﵹ����2��Ԫ��
    	for (int i = length - 2; i > 0 ; i--) {
    		//���i����Ԫ��ֵ����1��˵�����ܵ���i+1��
			if(nums[i] >= step) {
				step = 1;
			}
			//������ܴ�i��i+1����ô��ȥ�ж��Ƿ��ܹ���i��i+2����������Ϊ2
			else {
				step++;
			}
		}
    	//�������һ���ж��Ƿ��ܹ���λ��0�ߵ�λ��1�����nums[0]����ֵ����step��˵���ܹ��߹�ȥ������֮��˵�������߹�ȥ
    	if(nums[0] < step)
    		return false;
    	
    	return true;
    }

    /**
     * 	�����ĵݹ鷽��
     * 		����Ѿ�����indexλ�ã���С��nums[index]���Ĳ�������ǰ�߾Ϳ���
     * @param index
     * @param nums
     * @return
     */
	private static boolean dfs(int index, int[] nums) {
		//������������һ��������˵���ܹ��������һ��λ�ã�����true
		if(index == nums.length-1)
			return true;
		
		//������ĵ�ǰindexλ�ô����ֱ���ǰ��1.2....nums[index]��������ܹ��ߵ��յ㣬����true
		for (int i = 1; i <= nums[index]; i++) {
			if(dfs(index+i, nums))
				return true;
		}
		
		//����ӵ�ǰλ�ó������߲����յ㣬����false
		return false;
	}
}