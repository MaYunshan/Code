package com.mys.dy_program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 	����һ��N*M�ľ������е�1��ʾǽ�ڣ�0��ʾ�����ߵ�·��ֻ�ܺ����߻������ߣ�����б���ߣ�Ҫ�������ҳ������Ͻǵ����½ǵ����·�ߡ�
 *
 */
public class demo1_��ԽNM��������·�� {

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
	 * 	������ȱ���
	 * @param arrs��Ҫ�����Ķ�ά����
	 * @param start�����
	 * @param end���յ�
	 * @return����̲���
	 */
	private static int bfs(int[][] arrs, Position start, Position end) {
		//dp[i][j]������¼�����start(0,0)����(i,j)�����ٲ�������ʼֵΪ-1��˵����ǰ�㻹û������
		int[][] dp = new int [arrs.length][arrs[0].length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		//bfs��������������Ķ���
		Queue<Position> que =  new LinkedList<Position>();
		//list�����������浱ǰ��pos���ĸ��ڽӵ�
		List<Position> positions = new ArrayList<Position>();
		
		//����������У����ҽ����Ĳ�������Ϊ0
		que.add(start);
		dp[start.x][start.y] = 0;
		
		//������в�Ϊ�գ�
		while(!que.isEmpty()) {
			
			//ȡ������Ԫ�ز����䵯������
			Position pos = que.poll();
			//�����ǰ��pos�Ѿ����յ㣬ѭ������
			if(pos.x == end.x && pos.y ==end.y)
				break;
			
			//���浱ǰ��pos���ĸ��ڽӵ㵽positions������
			positions.add(new Position(pos.x,pos.y-1));
			positions.add(new Position(pos.x-1,pos.y));
			positions.add(new Position(pos.x+1,pos.y));
			positions.add(new Position(pos.x,pos.y+1));
			
			//�������ĸ���
			for (Position position : positions) {
				//���pos��ǰ���������ڽӵ�positon���������ںϷ���Χ
				if (position.x >= 0 && position.y >= 0 && position.x <= end.x && position.y <= end.y) {
					//�����ǰ���ڽӵ�positon����ͨ�����һ�û�б����ʹ�������������У����ҽ�����dpֵ����Ϊpos��dpֵ+1
					if(arrs[position.x][position.y] == 0 && dp[position.x][position.y] == -1) {
						que.add(position);
						dp[position.x][position.y] = dp[pos.x][pos.y] + 1;
					}
				}
			}
			
			//�������Ժ󣬽�list������գ��Ա�����һ�������ĵ���ڽӵ�
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