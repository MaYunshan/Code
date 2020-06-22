package com.mys.dy_program;

import java.util.Scanner;

/**
 * ����һ��M*N�ľ������о�����ÿ��Ԫ�ش���Խ�������Ĵ��ۣ�������½ǵ����Ͻǵ���С����
 * 
 * M*N�������(M+1)*(N+1)��������
 * @author dell
 *
 */
public class demo1_��ԽMN�������С���� {
	
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
		
		//�ⷨ1��
		int sum = Solution2.minPath(arrs);
		System.out.println(sum);
		
		//�ⷨ2
		recu_minPath(arrs, 0, 0, M-1, N-1);
		System.out.println(sum);
		System.out.println(count);
		
	}
	
	/**
	 * �ӵ�(x,y)����(m,n)����С���ۺ�
	 * @param arrs��M*N�Ĵ��۾���ÿ��Ԫ�ش������÷���ʱ�Ĵ���
	 * @param x����������
	 * @param y�����������
	 * @param m���յ������
	 * @param n���յ�������
	 */
	
	//��¼��ǰ���յ�ʱ�Ĵ���
	private static int sum = 0;
	//��¼��һ�ε��յ�ʱ�Ĵ���
	private static int count = Integer.MAX_VALUE;
	public static void recu_minPath(int[][] arrs,int x,int y,int m,int n) {
		
		//�жϵ�ǰ��(x,y)�Ƿ����յ�(m,n)����ǣ��Ƚϵ�ǰ����·���Ĵ���sum����һ�εĴ���count
		//���sum < count ������滻
		if(x == m && y == n) {
			if(sum < count) {
				count = sum;
				sum = 0;
				return ;
			}
		}
		//�����ǰ�����ĵ㳬���˷�Χ������0
		else if(x > m || y > n) {
			return ;
		}
		
		//��ǰ������(x,y),���õ�Ĵ��ۼ���sum
		sum = sum + arrs[x][y];
		
		//�ӵ�ǰ��(x,y)������һ����(x+1,y)
		recu_minPath(arrs, x+1, y, m, n);
		
		//�ӵ�ǰ��(x,y)������һ����(x,y+1)
		recu_minPath(arrs, x, y+1, m, n);
	}
}

class Solution2{
	/**
	 * �ⷨ1
	 * ��������һ��M*N�ľ���dp[M][N]
	 * ����dp[i][j]�����(0,0)�㵽(i,j)��Ĵ���
	 * ����һ���㵽(i,j)��ֻ������;�����ֱ��Ǿ�����(i-1,j)��(i,j),������(i,j-1)��(i,j)
	 * ��˵���(i,j)�Ĵ���dp[i][j]��������;��dp[i-1][j]+arrs[i][j]�� dp[i][j-1]+arrs[i][j]����Сֵ
	 */
	public static int minPath(int[][] arrs) {
		int[][] dp = new int[arrs.length][arrs[0].length];
		dp[0][0]=arrs[0][0];
		//��һ��ֻ����������
        for(int i=1;i<arrs.length;i++)
        {
            dp[i][0]=dp[i-1][0]+arrs[i][0];
        }
        //��һ��ֻ����������
        for(int j=1;j<arrs[0].length;j++)
        {
            dp[0][j]=dp[0][j-1]+arrs[0][j];
        }
        
        for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				//����(i,j)ֻ������;����Ҫô������(i-1,j),Ҫô������(i,j-1)
				dp[i][j] = Math.min(dp[i-1][j]+arrs[i][j], dp[i][j-1]+arrs[i][j]);
			}
		}
        return dp[arrs.length-1][arrs[0].length-1];
	}
	
	
	
}
