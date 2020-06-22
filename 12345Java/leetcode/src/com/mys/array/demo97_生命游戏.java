package com.mys.array;

import java.util.Arrays;

import javax.swing.border.Border;

/**
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 		如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 		如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 		如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 		如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，
 * 其中细胞的出生和死亡是同时发生的。
 */
public class demo97_生命游戏 {

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
    	 * 	第一遍循环用来统计需要发送转换的细胞
    	 * 		如果当前位置细胞是由死到活，则把它标记为2     
    	 * 		如果当前位置细胞是由活到死，则把它标记为3
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
         * 	第二遍循环用来更新细胞，将2变为1，将3变为0
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
     * 	用来统计当前位置周围处的活细胞数量，
     * 	因为在已经统计过的位置处会出现2或者3，以2取模就是这个位置的细胞本来的状态
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