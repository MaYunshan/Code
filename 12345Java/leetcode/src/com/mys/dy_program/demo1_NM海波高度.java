package com.mys.dy_program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class demo1_NM海波高度 {

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
	
	//统计一共有多少条路径
	private static int sum = 0;
	
	/**
	 * 计算从A(x,y)到B(m,n)一共有多少条路径
	 * @param XY：记录上一个坐标点的海拨高度
	 * @param x：当前正在遍历的点的横坐标
	 * @param y：当前正在遍历的点的纵坐标
	 * @param n：终点的横坐标
	 * @param m：终点的纵坐标
	 * @param arrs：记录海拔高度的矩阵
	 * @param marked：记录坐标上某个点是否被访问过
	 */
	public static void dfs(int XY,int x,int y,int n,int m,int[][] arrs,byte[][] marked) {
		//如果当前点(x,y)不在规定的坐标平面内，返回
		if(x < 0 || x > n || y < 0 || y > m) {
			return ;
		}
		
		//如果当前点已经被访问过，返回
		if(marked[x][y] == 1) {
			return ;
		}
		
		//如果当前点的海拔高度低于上一个点的海拔高度，返回
		if(arrs[x][y] <= XY) {
			return ;
		}
		
		//如果已经找到了终点，当前找到了一条路径，记录数+1
		if(x == n && y ==m) {
			sum = sum + 1;
			return ;
		}
		//将当前遍历的点标记，开始访问下一个点
		marked[x][y] = 1;
		dfs(arrs[x][y], x-1, y, n, m, arrs, marked);
		dfs(arrs[x][y], x, y-1, n, m, arrs, marked);
		dfs(arrs[x][y], x+1, y, n, m, arrs, marked);
		dfs(arrs[x][y], x, y+1, n, m, arrs, marked);
		
		//从这一层出来，将当前点的访问标志清除，以后别的路径还有可能经过这个点
		marked[x][y] = 0;
	}
}
