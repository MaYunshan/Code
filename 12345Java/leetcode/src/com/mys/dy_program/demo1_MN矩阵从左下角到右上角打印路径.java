package com.mys.dy_program;

import java.util.Scanner;



/**
 * ��һ��M*N�����񣬼�������½Ƕ��㵽���ϽǶ���һ���ж����ַ���
 * ��ÿһ�����㴦��ֻ�����ϻ���������
 * ��Ҫ���Ͼ���N-1�����㣬���Ҿ���M-1������
 */
public class demo1_MN��������½ǵ����ϽǴ�ӡ·�� {

	public static void main(String[] args) {
		System.out.print("�������������������������:");
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		//��M*N�������ϴ�(0,0)��(M-1,N-1)��Ҫ����M��1+N-1���㣬������ʼ�㣬һ����M+N-1���㡣arr����������¼·���ϵ�ÿһ����
		int[][] paths = new int[M+N-1][2];
		
		int count = Solution11.path(paths,M-1,N-1, 0, 0, 0);
		System.out.println(count);
	}

}
/**
 * M*N������(��������M���㣬��������N����)
 * ��(0,0)��(M-1��N-1)һ���ж�����·����ӡÿ��·���ϵ�����
 * @author dell
 *
 */
class Solution11{
	
	/**
	 * �ⷨ1���ݹ�ⷨ
	 * @param paths:��������·���ϵ�����������
	 * @param m:Ҫ������յ�ĺ�����
	 * @param n:Ҫ������յ��������
	 * @param x:��ǰ���ڵ�ĺ�����
	 * @param y:��ǰ���ڵ��������
	 * @param index:��ǰ�������ĵ���·���ϵ�����
	 * @return
	 */
	public static int path(int[][] paths,int m,int n,int x,int y,int index) {
		//����ǰ���ڱ����ĵ����·��
		paths[index][0] = x;
		paths[index][1] = y;
		
		//����Ѿ��������յ㣬�򽫼�¼��·����ӡ�����ҷ���1��������ʾ��ǰ�Ѿ��ҵ�һ��·��
		if(x == m && y == n) {
			printPath(paths);
			return 1;
		}
		
		//�����ǰ�����ĵ㳬���˷�Χ������0
		else if(x > m || y > n) {
			return 0;
		}
		
		//�Ե�ǰ��Ϊ��׼���ֱ�����õ����ϵĵ㣬�Լ��õ����ҵĵ㣬�����Ǹ��Ե�·��������ӣ����͵õ����ܵ�·����
		return path(paths, m, n, x+1, y, index+1)+ path(paths, m, n, x, y+1, index+1);
		
	}
	
	/**
	 * ·����ӡ����
	 * ÿ���ҵ�һ��·�����ͽ�����·����ӡ����
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
