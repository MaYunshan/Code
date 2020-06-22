package com.mys.array;


public class demo6_矩阵旋转90deg {

	public static void main(String[] args) {
		int[][] arr=new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] arr2={{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
		print(arr2);
		Solution6.rotate(arr2);
		print(arr2);
		
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
	}

}
class Solution6 {
	/*
	 * 	将一个矩阵旋转90度
	 * 		先将矩阵实对称变换
	 * 		然后首尾列一一互相交换
	 */
    public static void rotate(int[][] matrix) {
    	int n=matrix.length;
        for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
        
        for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n; j++) {
				int temp=matrix[j][i];
				matrix[j][i]=matrix[j][n-1-i];
				matrix[j][n-1-i]=temp;
			}
		}
    }
}