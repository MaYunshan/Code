package com.mys.dy_program;

import java.util.Scanner;



/**
 * 有一个M*N的网格，计算从左下角顶点到右上角顶点一共有多少种方法
 * 在每一个顶点处，只能向上或者向右走
 * 需要向上经过N-1个顶点，向右经过M-1个顶点
 */
public class demo1_MN矩阵从左下角到右上角打印路径 {

	public static void main(String[] args) {
		System.out.print("请输入网格横轴点数和纵轴点数:");
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		//从M*N的网格上从(0,0)到(M-1,N-1)需要经过M—1+N-1个点，算上起始点，一共是M+N-1个点。arr数组用来记录路径上的每一个点
		int[][] paths = new int[M+N-1][2];
		
		int count = Solution11.path(paths,M-1,N-1, 0, 0, 0);
		System.out.println(count);
	}

}
/**
 * M*N的网格(横坐标有M个点，纵坐标有N个点)
 * 从(0,0)到(M-1，N-1)一共有多少条路径打印每条路径上的坐标
 * @author dell
 *
 */
class Solution11{
	
	/**
	 * 解法1：递归解法
	 * @param paths:用来保存路径上的坐标点的数组
	 * @param m:要到达的终点的横坐标
	 * @param n:要到达的终点的纵坐标
	 * @param x:当前所在点的横坐标
	 * @param y:当前所在点的纵坐标
	 * @param index:当前遍历到的点在路径上的索引
	 * @return
	 */
	public static int path(int[][] paths,int m,int n,int x,int y,int index) {
		//将当前正在遍历的点加入路径
		paths[index][0] = x;
		paths[index][1] = y;
		
		//如果已经遍历到终点，则将记录的路径打印，并且返回1，用来表示当前已经找到一条路径
		if(x == m && y == n) {
			printPath(paths);
			return 1;
		}
		
		//如果当前遍历的点超出了范围，返回0
		else if(x > m || y > n) {
			return 0;
		}
		
		//以当前点为基准，分别遍历该点向上的点，以及该点向右的点，将它们各自的路径条数相加，最后就得到了总的路径数
		return path(paths, m, n, x+1, y, index+1)+ path(paths, m, n, x, y+1, index+1);
		
	}
	
	/**
	 * 路径打印函数
	 * 每当找到一条路径，就将这条路径打印出来
	 * @param arr
	 */
	public static void printPath(int[][] arr) {
		int i = 0;
		for (; i < arr.length-1; i++) {
			System.out.print("("+arr[i][0]+","+arr[i][1]+")->");
		}
		System.out.println("("+arr[i][0]+","+arr[i][1]+")");
	}
}
