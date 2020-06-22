package com.mys.array;

/**
 * ����һ��δ��������飬�ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�
	��ѧ���ʽ����:
		������������� i, j, k,  ������ 0 �� i < j < k �� n-1��
		ʹ�� arr[i] < arr[j] < arr[k] ������ true ; ���򷵻� false ��
 *
 */
public class demo93_��������Ԫ������ {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int[] nums1 = {5,4,3,2,1};
		int[] nums2 = {5,8,4,7,9};
		int[] nums3 = {5,8,3,9,5};
		int[] nums4 = {1,2,3,4,5};
		int[] nums5 = {1,2,3,4,5};
		boolean flag = Solution93.increasingTriplet1(nums3);
		System.out.println(flag);
	}

}
class Solution93 {
	/**
	 * 	�ⷨ1�������ⷨ������forѭ��
	 * @param nums
	 * @return
	 */
    public static boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				if(nums[i] < nums[j]) {
					for (int k = j + 1; k < nums.length; k++) {
						if(nums[j] < nums[k])
							return true;
					}
				}
			}
		}
    	return false;
    }
    
    /**
     * 	�ⷨ2��ֻ��Ҫ����һ������
     * 	low ��������¼��һ����С��
     * 	mid ��������¼�ڱ�low�����
     * 	x 	������Ѿ��ҵ���һ��low��mid�������ַ�����һ����low��С��������ô����x��¼
     * @param nums
     * @return
     */
    public static boolean increasingTriplet1(int[] nums) {
    	if(nums == null ||nums.length < 3)
    		return false;
    	//low������¼��һ�η��ֵĽ�С��
    	int low = nums[0];
    	//mid������¼��low�����
    	int mid = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
        	if(nums[i] < low) {
        		//�����ǰ����low����С������low
        		low = nums[i];
        	}else if (nums[i] > low && nums[i] < mid) {
        		//�����ǰ���ֽ���low��mid֮�䣬����mid
				mid = nums[i];
			}else {
				//��mid���ҵ�����Ԫ��
				if(nums[i] > mid)
					return true;
			}
		}
    	return false;
    }
}