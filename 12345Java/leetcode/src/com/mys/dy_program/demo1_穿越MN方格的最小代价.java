package com.mys.dy_program;

import java.util.Scanner;

/**
 * 给定一个M*N的矩阵，其中矩阵中每个元素代表穿越这个方格的代价，求从左下角到右上角的最小代价
 * 
 * M*N方格就是(M+1)*(N+1)网格问题
 * @author dell
 *
 */
public class demo1_穿越MN方格的最小代价 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] MN = str.split(" ");
		int M = Integer.parseInt(MN[0]);
		int N = Integer.parseInt(MN[1]);
		int[][] arrs= new int[M][N];
		for (int i = 0; i < arrs.length; i++) {
			String strLine = sc.nextLine();
			String[] lines = strLine.split(" ");
			for (int j = 0; j < lines.length; j++) {
				arrs[i][j] = Integer.valueOf(lines[j]);
			}
		}
		
		//解法1，
		int sum = Solution2.minPath(arrs);
		System.out.println(sum);
		
		//解法2
		recu_minPath(arrs, 0, 0, M-1, N-1);
		System.out.println(sum);
		System.out.println(count);
		
	}
	
	/**
	 * 从点(x,y)到点(m,n)的最小代价和
	 * @param arrs：M*N的代价矩阵，每个元素代表经过该方格时的代价
	 * @param x：起点横坐标
	 * @param y：起点纵坐标
	 * @param m：终点横坐标
	 * @param n：终点纵坐标
	 */
	
	//记录当前到终点时的代价
	private static int sum = 0;
	//记录上一次到终点时的代价
	private static int count = Integer.MAX_VALUE;
	public static void recu_minPath(int[][] arrs,int x,int y,int m,int n) {
		
		//判断当前点(x,y)是否是终点(m,n)如果是，比较当前这条路径的代价sum和上一次的代价count
		//如果sum < count 则进行替换
		if(x == m && y == n) {
			if(sum < count) {
				count = sum;
				sum = 0;
				return ;
			}
		}
		//如果当前遍历的点超出了范围，返回0
		else if(x > m || y > n) {
			return ;
		}
		
		//当前经过点(x,y),将该点的代价加入sum
		sum = sum + arrs[x][y];
		
		//从当前点(x,y)遍历下一个点(x+1,y)
		recu_minPath(arrs, x+1, y, m, n);
		
		//从当前点(x,y)遍历下一个点(x,y+1)
		recu_minPath(arrs, x, y+1, m, n);
	}
}

class Solution2{
	/**
	 * 解法1
	 * 定义另外一个M*N的矩阵dp[M][N]
	 * 其中dp[i][j]代表从(0,0)点到(i,j)点的代价
	 * 从上一个点到(i,j)点只有两种途径，分别是经过点(i-1,j)到(i,j),经过点(i,j-1)到(i,j)
	 * 因此到点(i,j)的代价dp[i][j]是这两种途径dp[i-1][j]+arrs[i][j]和 dp[i][j-1]+arrs[i][j]的最小值
	 */
	public static int minPath(int[][] arrs) {
		int[][] dp = new int[arrs.length][arrs[0].length];
		dp[0][0]=arrs[0][0];
		//第一列只能由上向下
        for(int i=1;i<arrs.length;i++)
        {
            dp[i][0]=dp[i-1][0]+arrs[i][0];
        }
        //第一行只能由左向右
        for(int j=1;j<arrs[0].length;j++)
        {
            dp[0][j]=dp[0][j-1]+arrs[0][j];
        }
        
        for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				//到点(i,j)只有两种途径，要么经过点(i-1,j),要么经过点(i,j-1)
				dp[i][j] = Math.min(dp[i-1][j]+arrs[i][j], dp[i][j-1]+arrs[i][j]);
			}
		}
        return dp[arrs.length-1][arrs[0].length-1];
	}
	
	
	
}
