package com.mys.array;

/**
 * 	给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 	输入:
		[
		 	[ 1, 2, 3 ],
		 	[ 4, 5, 6 ],
		 	[ 7, 8, 9 ]
		]
 *	输出: [1,2,3,6,9,8,7,4,5]
 */
import java.util.ArrayList;
import java.util.List;

public class demo62_螺旋矩阵 {

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3,4},
				{5, 6, 7,8},
				{9, 10, 11,12}
		};
		List<Integer> list = Solution62.spiralOrder(matrix);
		System.out.println(list);
	}
/**
 * ,
				{5, 6,7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
				{17, 18, 19, 20}
 */
}
class Solution62 {
    public static List<Integer> spiralOrder(int[][] matrix) {
    	
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
    		return list;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        
        //统计矩阵从外向内的层数，如果矩阵非空，那么它的层数至少为1层
        int count = (Math.min(m, n)+1)/2;
        //从外部向内部遍历，逐层打印数据
        while(i < count) {
        	for (int j = i; j < n-i; j++) {
				list.add(matrix[i][j]);
				System.out.print(matrix[i][j]+" ");
			}
        	
        	System.out.println();
        	for (int j = i+1; j < m-i; j++) {
				list.add(matrix[j][(n-1)-i]);
				System.out.print(matrix[j][(n-1)-i]+" ");
			}
        	
        	System.out.println();
        	
        	for (int j = (n-1)-(i+1); j >= i && (m-1-i != i); j--) {
				list.add(matrix[(m-1)-i][j]);
				System.out.print(matrix[(m-1)-i][j]+" ");
			}
        	
        	System.out.println();
        	for (int j = (m-1)-(i+1); j >= i+1 && (n-1-i) != i; j--) {
				list.add(matrix[j][i]);
				System.out.print(matrix[j][i]+" ");
			}
        	System.out.println();
        	i++;
        }
        
        return list;
    }

	
}