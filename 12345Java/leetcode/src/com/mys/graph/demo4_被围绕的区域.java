package com.mys.graph;
/**
 * 	给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *	找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *	示例:
	X X X X
	X O O X
	X X O X
	X O X X
	
 *	运行你的函数后，矩阵变为：
	X X X X
	X X X X
	X X X X
	X O X X
	
 *	解释:
 *		被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 
 *		任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class demo4_被围绕的区域 {

	public static void main(String[] args) {
		char[][] board = {
				{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'O', 'X'}
		};
		
		Solution4.solve(board);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}


}
class Solution4 {
	/**
	 * 	从边缘的'O'开始进行dfs，如果从边缘的'O'遍历到内部的'O'，说明它们是连通的，将这些和边缘的'O'连通的'O'标记，，
	 * 	然后第二次循环board，将内部没有标记的'O'全部替换为'X'
	 */
    public static void solve(char[][] board) {
    	if(board == null || board.length == 0)
    		return;
    	int m = board.length;
    	int n = board[0].length;
		boolean[][] marked = new boolean[m][n];
		
		
		//遍历所有还没有被标记的处在边缘位置的'O'
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if((i == 0 || i== m-1 || j == 0 || j == n-1) && board[i][j] == 'O' && marked[i][j] == false) {
					dfs(board,i,j,marked);
				}
			}
		}
		
		//将矩阵内部还没有别标记的'O'全部替换为'X'
		for (int i = 1; i < m-1; i++) {
			for (int j = 1; j < n-1; j++) {
				if(board[i][j] == 'O' && marked[i][j] == false) {
					board[i][j] = 'X';
				}
			}
		}
    }

	private static void dfs(char[][] board, int i, int j, boolean[][] marked) {
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return;
		
		//如果矩阵当前位置处的元素是'X'，或者是当前位置处的'O'已经被访问过了，直接返回
		if(board[i][j] == 'X' || marked[i][j] == true)
			return;
		

		marked[i][j] = true;

		dfs(board, i - 1, j, marked);
		dfs(board, i + 1, j, marked);
		dfs(board, i, j - 1, marked);
		dfs(board, i, j + 1, marked);
	}
}