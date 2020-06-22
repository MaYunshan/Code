package com.mys.dy_program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 	给定一个N*M的矩阵，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。
 *
 */
public class demo1_穿越NM方格的最短路径 {

	public static void main(String[] args) {
		int[][] arrs = {
				{0, 1, 0, 0, 0},
				{0, 1, 0, 1, 0},
				{0, 0, 0, 0, 0},
				{0, 1, 1, 1, 0},
				{0, 0, 0, 1, 0}
		};
		
		Position start = new Position(0,0);
		Position end = new Position(4,4);
		int minStep = bfs(arrs,start,end);
		System.out.println(minStep);
		
	}

	/**
	 * 	广度优先遍历
	 * @param arrs：要遍历的二维数组
	 * @param start：起点
	 * @param end：终点
	 * @return：最短步数
	 */
	private static int bfs(int[][] arrs, Position start, Position end) {
		//dp[i][j]用来记录从起点start(0,0)到点(i,j)的最少步数，初始值为-1，说明当前点还没有来过
		int[][] dp = new int [arrs.length][arrs[0].length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		//bfs用来遍历的数组的队列
		Queue<Position> que =  new LinkedList<Position>();
		//list集合用来保存当前点pos的四个邻接点
		List<Position> positions = new ArrayList<Position>();
		
		//将起点加入队列，并且将起点的步数设置为0
		que.add(start);
		dp[start.x][start.y] = 0;
		
		//如果队列不为空，
		while(!que.isEmpty()) {
			
			//取出队首元素并将其弹出队列
			Position pos = que.poll();
			//如果当前点pos已经是终点，循环结束
			if(pos.x == end.x && pos.y ==end.y)
				break;
			
			//保存当前点pos的四个邻接点到positions集合中
			positions.add(new Position(pos.x,pos.y-1));
			positions.add(new Position(pos.x-1,pos.y));
			positions.add(new Position(pos.x+1,pos.y));
			positions.add(new Position(pos.x,pos.y+1));
			
			//遍历这四个点
			for (Position position : positions) {
				//如果pos当前被遍历的邻接点positon的坐标属于合法范围
				if (position.x >= 0 && position.y >= 0 && position.x <= end.x && position.y <= end.y) {
					//如果当前的邻接点positon可以通过并且还没有被访问过，将它加入队列，并且将它的dp值设置为pos的dp值+1
					if(arrs[position.x][position.y] == 0 && dp[position.x][position.y] == -1) {
						que.add(position);
						dp[position.x][position.y] = dp[pos.x][pos.y] + 1;
					}
				}
			}
			
			//遍历完以后，将list集合清空，以保存下一个遍历的点的邻接点
			positions.clear();
			
		}
		
 		return dp[end.x][end.y];
	}

}

class Position{
	int x;
	int y;
	public Position() {
		super();
	}
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}