package com.mys.dy_program;

public class demo2_爬楼梯 {

	public static void main(String[] args) {
		int ret = Solution3.climbStairs1(4);
		System.out.println(ret);
	}

}
class Solution3 {
	/**
	 * 	爬楼梯问题
	 * 		每一层楼梯道最后一层楼梯的走法都是固定的，例如
	 * 			倒数第一层到最后一层只有一种走法 ：f(n-1)=1;
	 * 			倒数第二层到最后一层只有两种走法：f(n-2)=2;
	 * 			那么倒数第三层到最后一层可以这样走
	 * 				1).先走一步到达倒数第二层，然后从倒数第二层到达最后一层，一共有f(n-2)中走法
	 * 				2).先走两步到达倒数第一层，然后从倒数第一层到达最后一次，一共有f(n-1)中走法
	 * 			所以，从倒数第三层到最后一层的总共的走法有f(n-3)=f(n-1)+f(n-2);
	 * 		从第一层(即倒数第n层)到最后一层，需要f(0)=f(1)+f(2)
	 * 类似于斐波那契数列问题
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
    	int[] arrs = new int[n+1];
    	return climStair(0,n,arrs);
    }
	private static int climStair(int i, int n,int[] arrs) {
		if(i > n)
			return 0;
		if(i == n) {
			return 1;
		}
		if (arrs[i] > 0) {
			return arrs[i];
		}
		arrs[i] = climStair(i+1, n, arrs)+climStair(i+2, n, arrs);
		return arrs[i];
	}
	
	/**
	 * 迭代解法
	 * 	需要走n阶台阶，那么一共有n+1阶台阶，第0层，第1层.....第n层
	 * @param n
	 * @return
	 */
	public static int climbStairs1(int n) {
		if(n == 0) {
			return 0;
		}else if (n == 1) {
			return 1;
		}else {
			int[] arrs = new int[n+1];
	    	arrs[n] = 0;
	    	arrs[n-1] = 1;
	    	arrs[n-2] = 2;
	    	for (int i = n-3; i >= 0; i--) {
				arrs[i] = arrs[i+1] +arrs[i+2];
			}
	    	return arrs[0];
		}
    }
}