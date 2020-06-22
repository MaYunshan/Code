package com.mys.array;

import java.util.Arrays;

/**
 * ����һ�� m x n �ľ������һ��Ԫ��Ϊ 0�����������к��е�����Ԫ�ض���Ϊ 0����ʹ��ԭ���㷨��
 *
 */
public class demo61_������0 {

	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		Solution61.printMatrix(matrix);
		Solution61.setZeroes1(matrix);
		Solution61.printMatrix(matrix);
	}

}
class Solution61 {
	/**
	 * 	�ⷨ1����һ���������marked[m][n]��¼������0��λ��
	 * @param matrix
	 */
    public static void setZeroes(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	boolean[][] marked = new boolean [m][n];
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j] == 0 && marked[i][j] == false) {
					//����һ��Ϊ0����������Ϊ0��Ԫ�صı����Ϊtrue���Ժ��ٷ���,ԭ������0��Ԫ�ز���ǣ���Ҫ����
					for (int k = 0; k < n; k++) {
						if(matrix[i][k] != 0) {
							matrix[i][k] = 0;
							marked[i][k] = true;
						}
					}
					//����һ��Ԫ��Ϊ0����������Ϊ0��Ԫ�صı����Ϊtrue���Ժ��ٷ��ʣ�ԭ������0��Ԫ�ز���ǣ���Ҫ����
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
    	int[] row = new int[m];   //��¼��Ҫ��0��������
    	int[] coll = new int[n];  //��¼��Ҫ��0��������
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