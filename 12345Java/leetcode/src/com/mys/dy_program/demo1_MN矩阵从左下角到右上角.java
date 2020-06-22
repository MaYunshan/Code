package com.mys.dy_program;

import java.util.Scanner;


/**
 * 有一个M*N的网格，计算从左下角顶点到右上角顶点一共有多少种方法
 * 在每一个顶点处，只能向上或者向右走
 * 需要向上经过N-1个顶点，向右经过M-1个顶点
 */
public class demo1_MN矩阵从左下角到右上角 {

	public static void main(String[] args) {
		System.out.print("请输入网格横轴点数和纵轴点数:");
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] arrs1 = new int[M][N];
		
		//解法1
		Solution1.pathSum(arrs1);
		System.out.println(arrs1[M-1][N-1]);
		
		//解法2
		int[][] arrs2 = new int[M][N];
		int sum = Solution1.path(arrs2, M-1, N-1);
		System.out.println(sum);
	}

}
class Solution1{
	/**
	 * 解法1：非递归解法
	 * arrs[i][j] = arrs[i-1][j] + arrs[i][j-1]
	 * arrs[i][j]表示到达该点时由多少种方法
	 * @param arrs
	 */
	public static void pathSum(int[][] arrs) {
		arrs[0][0] = 0;
		for (int i = 1; i < arrs.length; i++) {
			arrs[i][0] = 1;
		}
		for (int i = 1; i < arrs[0].length; i++) {
			arrs[0][i] = 1;
		}
		
		//外层循环，行
		for (int i = 1; i < arrs.length; i++) {
			//内层循环，列
			for (int j = 1; j < arrs[0].length; j++) {
				arrs[i][j] = arrs[i-1][j] + arrs[i][j-1];
			}
		}
	}
	
	/**
	 * 解法2：递归解法1
	 */
	public static int path(int[][] arrs,int m, int n) {
		//递归结束条件
		if(m == 0 && n == 0) {
			return 0;
		}
		//递归结束条件
		if(m == 0 || n == 0) {
			return 1;
		}
		arrs[m][n] = path(arrs, m - 1, n) + path(arrs, m, n - 1);
		return arrs[m][n];
	}
}
