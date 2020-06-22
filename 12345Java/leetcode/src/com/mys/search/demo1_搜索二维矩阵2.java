package com.mys.search;


public class demo1_搜索二维矩阵2 {

	
	public static void main(String[] args) {
		int[][] matrix = {
		                {1,   4,  7, 11, 15},
		                {2,   5,  8, 12, 19},
		                {3,   6,  9, 16, 22},
		                {10, 13, 14, 17, 24},
		                {18, 21, 23, 26, 30}
	               };
		Solution1.searchMatrix(matrix, 6);
	}

}
class Solution1 {
	/**
	 * 	左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标：
	 *		若左下角元素等于目标，则找到
	 *		若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
	 *		若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标
	 *	若最后矩阵减小为空，则说明不存在
	 * @param matrix
	 * @param target
	 * @return
	 */
    public static boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	return false;
    }
}