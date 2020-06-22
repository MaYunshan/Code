package com.mys.dy_program;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *	数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *	判断你是否能够到达最后一个位置。
 * @author dell
 *
 */
public class demo6_跳跃游戏 {

	public static void main(String[] args) {
		int[] nums = {3,0,0,5,4};
		boolean ret = Solution6.canJump(nums);
		System.out.println(ret);
	}

}
class Solution6 {
	public static boolean canJump1(int[] nums) {
		//用一个dp数组来表示在每个位置处能够到达的最大范围，
		//代表在每一个位置处能够到达的最大范围，如果maxstep>=nums.length-1，说明能够到达最后一个位置
    	int maxStep = 0;
    	for (int i = 0; i < nums.length; i++) {
    		//如果当前位置i在上一步的覆盖范围内，说明是能够到达位置i，同时，如果从位置i处的覆盖范围大于上一个位置的覆盖范围，更新maxStep
			if(maxStep >= i && i+nums[i] > maxStep) {
				maxStep = i + nums[i];
			}
			//如果位置i处的覆盖范围已经覆盖了最后一个位置，说明能够到达
			if(maxStep >= nums.length - 1)
				return true;
		}
    	return false;
    }
	
	//int[] nums = {7,5,9,4,2,6,8,3,5,4,3,9};
			//{7 5 9 4 2 6 8 3 5 4 3 9}
	
	
    public static boolean canJump(int[] nums) {
    	//解法1：递归搜索
    	//return dfs(0,nums);
    	
    	//解法2
    	if(nums.length < 2)
    		return true;
    	int length = nums.length;
    	int step = 1;
    	//从倒数第2个元素开始往前遍历，如果倒数第2个元素能到达最后一个元素，那么将最后一个元素删除，问题转化为是否能到达倒数第2个元素
    	for (int i = length - 2; i > 0 ; i--) {
    		//如果i处的元素值大于1，说明它能到达i+1处
			if(nums[i] >= step) {
				step = 1;
			}
			//如果不能从i到i+1，那么再去判断是否能够从i到i+2，步长最少为2
			else {
				step++;
			}
		}
    	//到了最后一步判断是否能够从位置0走到位置1，如果nums[0]处的值大于step，说明能够走过去，，反之，说明不能走过去
    	if(nums[0] < step)
    		return false;
    	
    	return true;
    }

    /**
     * 	基本的递归方法
     * 		如果已经到了index位置，以小于nums[index]处的步数，往前走就可以
     * @param index
     * @param nums
     * @return
     */
	private static boolean dfs(int index, int[] nums) {
		//如果到达了最后一个索引，说明能够到达最后一个位置，返回true
		if(index == nums.length-1)
			return true;
		
		//在数组的当前index位置处，分别向前走1.2....nums[index]步，如果能够走到终点，返回true
		for (int i = 1; i <= nums[index]; i++) {
			if(dfs(index+i, nums))
				return true;
		}
		
		//如果从当前位置出发，走不到终点，返回false
		return false;
	}
}