package com.mys.dy_program;

/**
 * 
 * 	你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 	影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 	给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 */
public class demo4_打家劫舍 {

	public static void main(String[] args) {
		int[] arr1 = {2,5,1,2};
		int[] arr2 = {2,7,9,3,1,5,4,6};
		
		System.out.println(Solution5.rob1(arr1));
		System.out.println(Solution5.rob1(arr2));
	}

}
class Solution5 {
	/**
	 * 	从每一个房间进去能获得的最大收入是固定的
	 * 	采用一个dp数组记录从每一个房间进去可以获得的最大收入
	 * 	dp[i]表示从第i个房间进去到最后偷完以后的最大收入
	 * @param nums
	 * @return
	 */
    public static int rob(int[] nums) {
    	//定义一个长度为n的dp数组并且初始化为-1
    	int[] dp = new int[nums.length];
    	for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
    	//从第0个房间进去获得的收入
        recuRob(nums,0,nums.length,dp);
        //从第1个房间进去获得的收入
        recuRob(nums,1,nums.length,dp);
        //相比较，得到最大值
        return dp[0] > dp[1] ? dp[0] : dp[1];
    }

	private static int recuRob(int[] nums, int i,int n, int[] dp) {
		//递归的结束条件，当前遍历的房间号超过索引，递归结束，返回0
		if(i >= n) {
			return 0;
		}
		//因为dp[i]上记录了从i房间进去的最大收入，因此，如果dp[i]不为初始值-1，
		//说明从房间i进去以后的最大收入已经有了，不需要再遍历，直接返回
		if(dp[i] > -1) {
			return dp[i];
		}
		//a用来记录从房间i进去，然后再从i+2房间进去以后的收入
		int a = nums[i]+recuRob(nums, i+2,n,dp);
		//b用来记录从房间i进去，然后再从i+3房间进去以后的收入
		int b = nums[i]+recuRob(nums, i+3,n,dp);
		//dp[i]等于a和b中的较大值
		dp[i] = a > b ? a : b;
		return dp[i];
	}
	
	
	/**
	 * 	解法2：迭代
	 * 	也用一个dp数组记录从当前房间出来时可以获得的收入
	 * 	dp[i]表示偷完第i个房间以后获得的总收入
	 * 		dp[0]表示从第0个房间出来时获得的收入：dp[0]=nums[0]
	 * 		dp[1]表示从第1个房间出来时获得的收入：dp[1]为nums[0]和nums[1]中的最大值
	 * 		在计算dp[i]时，要考虑两个值
	 * 				如果是从上一个房间出来的，那么当前房间不能偷，最大收入dp[i-1]，
	 * 				如果是从上上一个房间出来的，当前房间可以偷，最大收入为dp[i]+nums[i]
	 * 		这两个值得最大值就是从i房间出来时的最大收入
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