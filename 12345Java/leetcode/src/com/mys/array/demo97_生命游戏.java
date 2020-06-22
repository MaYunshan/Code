package com.mys.array;

import java.util.Arrays;

import javax.swing.border.Border;

/**
 * ����һ������ m �� n �����ӵ���壬ÿһ�����Ӷ����Կ�����һ��ϸ����ÿ��ϸ������һ����ʼ״̬ live��1����Ϊ��ϸ���� �� dead��0����Ϊ��ϸ����
 * ÿ��ϸ������˸�����λ�ã�ˮƽ����ֱ���Խ��ߣ���ϸ������ѭ�����������涨�ɣ�
 * 		�����ϸ����Χ�˸�λ�õĻ�ϸ�����������������λ�û�ϸ��������
 * 		�����ϸ����Χ�˸�λ����������������ϸ�������λ�û�ϸ����Ȼ��
 * 		�����ϸ����Χ�˸�λ���г���������ϸ�������λ�û�ϸ��������
 * 		�����ϸ����Χ������������ϸ�������λ����ϸ�����
 * ���ݵ�ǰ״̬��дһ�����������������ϸ������һ����һ�θ��º�ģ�״̬����һ��״̬��ͨ������������ͬʱӦ���ڵ�ǰ״̬�µ�ÿ��ϸ�����γɵģ�
 * ����ϸ���ĳ�����������ͬʱ�����ġ�
 */
public class demo97_������Ϸ {

	public static void main(String[] args) {
		int[][] boards = {
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0}
				};
		Solution97.gameOfLife(boards);
        for (int i = 0; i < boards.length; i++) {
			for (int j = 0; j < boards[0].length; j++) {
				System.out.print(boards[i][j]+" ");
			}
			System.out.println();
		}

	}

}
class Solution97 {
    public static void gameOfLife(int[][] board) {
    	/**
    	 * 	��һ��ѭ������ͳ����Ҫ����ת����ϸ��
    	 * 		�����ǰλ��ϸ�������������������Ϊ2     
    	 * 		�����ǰλ��ϸ�����ɻ������������Ϊ3
    	 */
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int alive = getAlive(board,i,j);
				if(board[i][j] == 0) {
					if(alive == 3)
						board[i][j] = 2;
				}
				else {
					if(alive < 2 || alive > 3)
						board[i][j] = 3;
						
				}
			}
		}
       
        /**
         * 	�ڶ���ѭ����������ϸ������2��Ϊ1����3��Ϊ0
         */
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				 if(board[i][j] == 2)
					 board[i][j] = 1;
				 else if(board[i][j] == 3)
					 board[i][j] = 0;
			}
		}
        
    }

    /**
     * 	����ͳ�Ƶ�ǰλ����Χ���Ļ�ϸ��������
     * 	��Ϊ���Ѿ�ͳ�ƹ���λ�ô������2����3����2ȡģ�������λ�õ�ϸ��������״̬
     */
	private static int getAlive(int[][] board, int i, int j) {
		int count = 0;
		for (int k = i-1; k <= i+1; k++) {
			for (int k2 = j-1; k2 <= j+1; k2++) {
				if(k < 0 || k >= board.length || k2 < 0 || k2 >= board[0].length)
					continue;
				count = (board[k][k2] % 2) + count;
			}
		}
		count = count - board[i][j] % 2;
		return count;
	}
}