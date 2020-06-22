package com.mys.array;

import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 */
public class demo61_矩阵置0 {

	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		Solution61.printMatrix(matrix);
		Solution61.setZeroes1(matrix);
		Solution61.printMatrix(matrix);
	}

}
class Solution61 {
	/**
	 * 	解法1：用一个标记数组marked[m][n]记录所有置0的位置
	 * @param matrix
	 */
    public static void setZeroes(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	boolean[][] marked = new boolean [m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j] == 0 && marked[i][j] == false) {
					//让这一行为0，并且新设为0的元素的标记设为true，以后不再访问,原来就是0的元素不标记，还要访问
					for (int k = 0; k < n; k++) {
						if(matrix[i][k] != 0) {
							matrix[i][k] = 0;
							marked[i][k] = true;
						}
					}
					//让这一列元素为0，并且新设为0的元素的标记设为true，以后不再访问，原来就是0的元素不标记，还要访问
					for (int k = 0; k < m; k++) {
						if(matrix[k][j] != 0) {
							matrix[k][j] = 0;
							marked[k][j] = true;
						}
					}
				}
			}
		}
    }
    
    
    public static void setZeroes1(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[] row = new int[m];   //记录需要置0的行索引
    	int[] coll = new int[n];  //记录需要置0的列索引
    	Arrays.fill(row, -1);
    	Arrays.fill(coll, -1);
    	
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j] == 0) {
					row[i] = i;
					coll[j] = j;
				}
			}
		}
    	
    	for (int i = 0; i < m; i++) {
			if (row[i] != -1) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
    	for (int i = 0; i < n; i++) {
			if(coll[i] != -1) {
				for (int j = 0; j < m; j++) {
					matrix[j][i] = 0;
				}
			}
		}
    }
    
    public static void printMatrix(int[][] matrix) {
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
    }
}