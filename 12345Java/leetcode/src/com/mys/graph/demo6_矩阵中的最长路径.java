package com.mys.graph;

import java.util.Arrays;

/**
 * 	����һ�����������ҳ������·���ĳ��ȡ�
 *	����ÿ����Ԫ����������ϣ��£������ĸ������ƶ��� �㲻���ڶԽ��߷������ƶ����ƶ����߽��⣨���������ƣ���
 * 	����: nums = 
 *		[
 *		  [9,9,4],
 *		  [6,6,8],
 *		  [2,1,1]
 *		] 
 *	���: 4 
 *	����: �����·��Ϊ [1, 2, 6, 9]��
 *
 */
public class demo6_�����е��·�� {

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
	 * �ⷨ2����̬�滮���dfs
	 * 	������һ����������·����ȷ���ģ���һ��dp��ά�����¼ÿһ��λ�ô������·��
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
		//�����ǰԪ��С�ڵ�����һ��Ԫ�أ�����ֹͣ������0
		if(matrix[i][j] <= Mij)
			return 0;
		
		//�����[i][j]����ֵ����ôֱ�ӷ���dp[i][j]
		if(dp[i][j] != 0)
			return dp[i][j];
		
		//��ȡ�ӵ�ǰλ��[i][j]������ΧԪ��ʱ���·������ô��ǰλ�ô����·������path+1
		int path = 0;
		path = Math.max(path, dfs(matrix, matrix[i][j], i-1, j,dp));
		path = Math.max(path, dfs(matrix, matrix[i][j], i+1, j,dp));
		path = Math.max(path, dfs(matrix, matrix[i][j], i, j-1,dp));
		path = Math.max(path, dfs(matrix, matrix[i][j], i, j+1,dp));
		
		dp[i][j] = path+1;
		return dp[i][j];
	}


	/**
	 * 	�ⷨ1�������ⷨ���������о���Ԫ�أ��ҵ����·��
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
     * 	�ӵ�ǰλ�ô�������������Χ���ĸ�Ԫ��֮��Ѱ�ұȸ�Ԫ�ش��Ԫ�أ�Ȼ��ݹ����
     * @param matrix
     * @param Mij
     * @param i
     * @param j
     * @return
     */
	private static int dfs(int[][] matrix,int Mij, int i, int j) {
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
			return 0;
		//�����ǰԪ��С�ڵ�����һ��Ԫ�أ�����ֹͣ������0
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