package com.mys.dy_program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class demo1_NM�����߶� {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
//		String[] MN = str.split(" ");
//		int N = Integer.parseInt(MN[0]);
//		int M = Integer.parseInt(MN[1]);
//		int[][] arrs= new int[N][M];
//		byte[][] marked= new byte[N][M];
//		for (int i = 0; i < arrs.length; i++) {
//			String strLine = sc.nextLine();
//			String[] lines = strLine.split(" ");
//			for (int j = 0; j < lines.length; j++) {
//				arrs[i][j] = Integer.valueOf(lines[j]);
//			}
//		}     
//		int Ax = sc.nextInt();
//		int Ay = sc.nextInt();
//		int Bx = sc.nextInt();
//		int By = sc.nextInt();
		
		BufferedReader bfr = new BufferedReader(new FileReader("D:\\12345Java\\leetcode\\src\\matrix.txt"));
		String str;
		str = bfr.readLine();
		String[] MN = str.split("\\s+");
		int N = Integer.parseInt(MN[0]);
		int M = Integer.parseInt(MN[1]);
		int[][] arrs= new int[N][M];
		byte[][] marked= new byte[N][M];
		for (int i = 0; i < arrs.length; i++) {
			String strLine = bfr.readLine();
			String[] lines = strLine.split("\\s+");
			for (int j = 0; j < lines.length; j++) {
				arrs[i][j] = Integer.valueOf(lines[j]);
			}
		}
		String AB = bfr.readLine();
		String[] ABxy = AB.split(" ");
		int Ax = Integer.valueOf(ABxy[0]);
		int Ay = Integer.valueOf(ABxy[1]);
		int Bx = Integer.valueOf(ABxy[2]);
		int By = Integer.valueOf(ABxy[3]);
		
		
		dfs(-1, Ax, Ay, Bx, By, arrs, marked);
		System.out.println(sum);
	}
	
	//ͳ��һ���ж�����·��
	private static int sum = 0;
	
	/**
	 * �����A(x,y)��B(m,n)һ���ж�����·��
	 * @param XY����¼��һ�������ĺ����߶�
	 * @param x����ǰ���ڱ����ĵ�ĺ�����
	 * @param y����ǰ���ڱ����ĵ��������
	 * @param n���յ�ĺ�����
	 * @param m���յ��������
	 * @param arrs����¼���θ߶ȵľ���
	 * @param marked����¼������ĳ�����Ƿ񱻷��ʹ�
	 */
	public static void dfs(int XY,int x,int y,int n,int m,int[][] arrs,byte[][] marked) {
		//�����ǰ��(x,y)���ڹ涨������ƽ���ڣ�����
		if(x < 0 || x > n || y < 0 || y > m) {
			return ;
		}
		
		//�����ǰ���Ѿ������ʹ�������
		if(marked[x][y] == 1) {
			return ;
		}
		
		//�����ǰ��ĺ��θ߶ȵ�����һ����ĺ��θ߶ȣ�����
		if(arrs[x][y] <= XY) {
			return ;
		}
		
		//����Ѿ��ҵ����յ㣬��ǰ�ҵ���һ��·������¼��+1
		if(x == n && y ==m) {
			sum = sum + 1;
			return ;
		}
		//����ǰ�����ĵ��ǣ���ʼ������һ����
		marked[x][y] = 1;
		dfs(arrs[x][y], x-1, y, n, m, arrs, marked);
		dfs(arrs[x][y], x, y-1, n, m, arrs, marked);
		dfs(arrs[x][y], x+1, y, n, m, arrs, marked);
		dfs(arrs[x][y], x, y+1, n, m, arrs, marked);
		
		//����һ�����������ǰ��ķ��ʱ�־������Ժ���·�����п��ܾ��������
		marked[x][y] = 0;
	}
}
