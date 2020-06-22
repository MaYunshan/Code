package com.mys.backtracing;


/**
 * 	给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *	单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 */
public class demo6_单词搜索 {

	public static void main(String[] args) {
		char[][] board = {
		                   {'A','B','C','E'},
		                   {'S','F','C','S'},
		                   {'A','D','E','E'}
	           			};
		
		String word = "SFCB";
		System.out.println(Solution6.exist1(board, word));
	}

}
class Solution6 {
	/**
	 * 	方法2
	 * @param board
	 * @param word
	 * @return
	 */
	public static boolean exist1(char[][] board, String word) {
    	int m = board.length;
    	int n = board[0].length;
    	boolean[][] marked = new boolean[m][n];
    	boolean[] flag = new boolean[1];
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j] == word.charAt(0))
					dfs1(board, marked, word, 0, i, j,flag);
			}
		}
    	return flag[0];
    }
	private static void dfs1(char[][] board, boolean[][] marked, String word, int index, int row, int col, boolean[] flag) {
		if(index == word.length()) {
			flag[0] = true;
			return;
		}
		
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
			return;
		
		if(marked[row][col] == true || board[row][col] != word.charAt(index))
			return;
		
		marked[row][col] = true;
		dfs1(board, marked, word, index+1, row+1, col, flag);
		dfs1(board, marked, word, index+1, row-1, col, flag);
		dfs1(board, marked, word, index+1, row, col+1, flag);
		dfs1(board, marked, word, index+1, row, col-1, flag);
		
		marked[row][col] = false;
	}
	
	
	/**
	 * 	方法1
	 * @param board
	 * @param word
	 * @return
	 */
    public static boolean exist(char[][] board, String word) {
    	int m = board.length;
    	int n = board[0].length;
    	boolean[][] marked = new boolean[m][n];
    	for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//遍历所有字符，从给定单词的第一个字母为起始索引，从board的每一个字符进去，看是否能找到对应的字符串
				if(dfs(board, marked, word, 0, i, j))
					return true;
			}
		}
    	return false;
    }

    /**
     * 	
     * @param board:给定的字母矩阵
     * @param marked：一个标记矩阵，用来记录字符矩阵中的字母是否被访问过
     * @param word：指定的单词
     * @param index：单词中正在检查的字符索引
     * @param row：当前遍历的字母矩阵的横向索引
     * @param col：当前遍历的字母矩阵的纵向索引
     * @return：在字母矩阵中是否找到了单词
     */
	private static boolean dfs(char[][] board, boolean[][] marked, String word, int index, int row, int col) {
		//如果单词的索引已经到尾部了，说明在字母矩阵中找到了该单词，返回true
		if(index == word.length()) {
			return true;
		}
		//如果当前的索引位置(row,col)超过了字母矩阵的范围，返回false
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
			return false;
		
		//如果当前位置已经被访问过，或者说当前字母矩阵中被访问的位置处的字母和单词index处的字母不相同，返回false
		if(marked[row][col] == true || word.charAt(index) != board[row][col])
			return false;
		
		//当前字母矩阵处的字母符合要求，将其标记
		marked[row][col] = true;
		
		//遍历位置(row+1,col)，看是否与单词index+1索引处的字母相同，如果相同，返回true，如果不相同，往下走，判断下一个位置
		if(dfs(board, marked, word, index+1, row+1, col))
			return true;
		if(dfs(board, marked, word, index+1, row-1, col))
			return true;
		if(dfs(board, marked, word, index+1, row, col-1))
			return true;
		if(dfs(board, marked, word, index+1, row, col+1))
			return true;
		
		//执行到这里，说明虽然字母矩阵当前索引处的字母符合要求，但是却单词后面的字母却找不到对应的位置，说明不符合要求，将其标记清除，返回false。
		marked[row][col] = false;
		return false;
	}
}