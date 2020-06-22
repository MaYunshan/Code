package com.mys.array;

/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
	数学表达式如下:
		如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
		使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *
 */
public class demo93_递增的三元子序列 {

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
	 * 	解法1：暴力解法，三层for循环
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
     * 	解法2：只需要遍历一遍数组
     * 	low ：用来记录第一个较小数
     * 	mid ：用来记录第比low大的数
     * 	x 	：如果已经找到了一组low和mid，但是又发现了一个比low更小的数，那么就用x记录
     * @param nums
     * @return
     */
    public static boolean increasingTriplet1(int[] nums) {
    	if(nums == null ||nums.length < 3)
    		return false;
    	//low用来记录第一次发现的较小数
    	int low = nums[0];
    	//mid用来记录比low大的数
    	int mid = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
        	if(nums[i] < low) {
        		//如果当前数比low更加小，更新low
        		low = nums[i];
        	}else if (nums[i] > low && nums[i] < mid) {
        		//如果当前数字介于low和mid之间，更新mid
				mid = nums[i];
			}else {
				//比mid大，找到了三元组
				if(nums[i] > mid)
					return true;
			}
		}
    	return false;
    }
}