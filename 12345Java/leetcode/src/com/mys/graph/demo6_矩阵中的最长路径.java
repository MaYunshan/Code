package com.mys.graph;

import java.util.Arrays;

/**
 * 	给定一个整数矩阵，找出最长递增路径的长度。
 *	对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * 	输入: nums = 
 *		[
 *		  [9,9,4],
 *		  [6,6,8],
 *		  [2,1,1]
 *		] 
 *	输出: 4 
 *	解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 */
public class demo6_矩阵中的最长路径 {

	public static void main(String[] args) {
		int[][] nums = {
				{3,3,14,2,17,12,5}
		};
		
		int ret = Solution6.longestIncreasingPath1(nums);
		System.out.println(ret);
	}

}
class Solution6 {
	
	private static int maxPath = 0;
	
	/**
	 * 解法2：动态规划版的dfs
	 * 	从任意一点出发的最长增路径是确定的，用一个dp二维数组记录每一个位置处的最长增路径
	 * 
	 */
	public static int longestIncreasingPath1(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
    		return 0;
    	int[][] dp = new int[matrix.length][matrix[0].length];
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(dp[i][j] == 0)
					maxPath = Math.max(maxPath, dfs(matrix,Integer.MIN_VALUE,i,j,dp));
			}
		}
    	return maxPath;
    }
	
	
	private static int dfs(int[][] matrix, int Mij, int i, int j, int[][] dp) {
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
			return 0;
		//如果当前元素小于等于上一个元素，搜索停止，返回0
		if(matrix[i][j] <= Mij)
			return 0;
		
		//如果在[i][j]处有值，那么直接返回dp[i][j]
		if(dp[i][j] != 0)
			return dp[i][j];
		
		//获取从当前位置[i][j]遍历周围元素时的最长路径，那么当前位置处的最长路径就是path+1
		int path = 0;
		path = Math.max(path, dfs(matrix, matrix[i][j], i-1, j,dp));
		path = Math.max(path, dfs(matrix, matrix[i][j], i+1, j,dp));
		path = Math.max(path, dfs(matrix, matrix[i][j], i, j-1,dp));
		path = Math.max(path, dfs(matrix, matrix[i][j], i, j+1,dp));
		
		dp[i][j] = path+1;
		return dp[i][j];
	}


	/**
	 * 	解法1：暴力解法，遍历所有矩阵元素，找到最长增路径
	 */
	
	
    public static int longestIncreasingPath(int[][] matrix) {
    	if(matrix == null || matrix.length == 0)
    		return 0;
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				maxPath = Math.max(maxPath, dfs(matrix,Integer.MIN_VALUE,i,j));
			}
		}
        return maxPath;
    }

    /**
     * 	从当前位置处出发，在它周围的四个元素之中寻找比该元素大的元素，然后递归调用
     * @param matrix
     * @param Mij
     * @param i
     * @param j
     * @return
     */
	private static int dfs(int[][] matrix,int Mij, int i, int j) {
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
			return 0;
		//如果当前元素小于等于上一个元素，搜索停止，返回0
		if(matrix[i][j] <= Mij)
			return 0;
		
		int path = 0;
		path = Math.max(path, 1 + dfs(matrix, matrix[i][j], i-1, j));
		path = Math.max(path, 1 + dfs(matrix, matrix[i][j], i+1, j));
		path = Math.max(path, 1 + dfs(matrix, matrix[i][j], i, j-1));
		path = Math.max(path, 1 + dfs(matrix, matrix[i][j], i, j+1));
		return path;
	}
}