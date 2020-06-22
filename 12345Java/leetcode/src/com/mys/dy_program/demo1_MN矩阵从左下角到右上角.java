package com.mys.dy_program;

import java.util.Scanner;


/**
 * ��һ��M*N�����񣬼�������½Ƕ��㵽���ϽǶ���һ���ж����ַ���
 * ��ÿһ�����㴦��ֻ�����ϻ���������
 * ��Ҫ���Ͼ���N-1�����㣬���Ҿ���M-1������
 */
public class demo1_MN��������½ǵ����Ͻ� {

	public static void main(String[] args) {
		System.out.print("�������������������������:");
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] arrs1 = new int[M][N];
		
		//�ⷨ1
		Solution1.pathSum(arrs1);
		System.out.println(arrs1[M-1][N-1]);
		
		//�ⷨ2
		int[][] arrs2 = new int[M][N];
		int sum = Solution1.path(arrs2, M-1, N-1);
		System.out.println(sum);
	}

}
class Solution1{
	/**
	 * �ⷨ1���ǵݹ�ⷨ
	 * arrs[i][j] = arrs[i-1][j] + arrs[i][j-1]
	 * arrs[i][j]��ʾ����õ�ʱ�ɶ����ַ���
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
		
		//���ѭ������
		for (int i = 1; i < arrs.length; i++) {
			//�ڲ�ѭ������
			for (int j = 1; j < arrs[0].length; j++) {
				arrs[i][j] = arrs[i-1][j] + arrs[i][j-1];
			}
		}
	}
	
	/**
	 * �ⷨ2���ݹ�ⷨ1
	 */
	public static int path(int[][] arrs,int m, int n) {
		//�ݹ��������
		if(m == 0 && n == 0) {
			return 0;
		}
		//�ݹ��������
		if(m == 0 || n == 0) {
			return 1;
		}
		arrs[m][n] = path(arrs, m - 1, n) + path(arrs, m, n - 1);
		return arrs[m][n];
	}
}
