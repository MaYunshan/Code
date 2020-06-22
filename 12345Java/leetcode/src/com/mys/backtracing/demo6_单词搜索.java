package com.mys.backtracing;


/**
 * 	����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�
 *	���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
 *
 */
public class demo6_�������� {

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
	 * 	����2
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
	 * 	����1
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
				//���������ַ����Ӹ������ʵĵ�һ����ĸΪ��ʼ��������board��ÿһ���ַ���ȥ�����Ƿ����ҵ���Ӧ���ַ���
				if(dfs(board, marked, word, 0, i, j))
					return true;
			}
		}
    	return false;
    }

    /**
     * 	
     * @param board:��������ĸ����
     * @param marked��һ����Ǿ���������¼�ַ������е���ĸ�Ƿ񱻷��ʹ�
     * @param word��ָ���ĵ���
     * @param index�����������ڼ����ַ�����
     * @param row����ǰ��������ĸ����ĺ�������
     * @param col����ǰ��������ĸ�������������
     * @return������ĸ�������Ƿ��ҵ��˵���
     */
	private static boolean dfs(char[][] board, boolean[][] marked, String word, int index, int row, int col) {
		//������ʵ������Ѿ���β���ˣ�˵������ĸ�������ҵ��˸õ��ʣ�����true
		if(index == word.length()) {
			return true;
		}
		//�����ǰ������λ��(row,col)��������ĸ����ķ�Χ������false
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
			return false;
		
		//�����ǰλ���Ѿ������ʹ�������˵��ǰ��ĸ�����б����ʵ�λ�ô�����ĸ�͵���index������ĸ����ͬ������false
		if(marked[row][col] == true || word.charAt(index) != board[row][col])
			return false;
		
		//��ǰ��ĸ���󴦵���ĸ����Ҫ�󣬽�����
		marked[row][col] = true;
		
		//����λ��(row+1,col)�����Ƿ��뵥��index+1����������ĸ��ͬ�������ͬ������true���������ͬ�������ߣ��ж���һ��λ��
		if(dfs(board, marked, word, index+1, row+1, col))
			return true;
		if(dfs(board, marked, word, index+1, row-1, col))
			return true;
		if(dfs(board, marked, word, index+1, row, col-1))
			return true;
		if(dfs(board, marked, word, index+1, row, col+1))
			return true;
		
		//ִ�е����˵����Ȼ��ĸ����ǰ����������ĸ����Ҫ�󣬵���ȴ���ʺ������ĸȴ�Ҳ�����Ӧ��λ�ã�˵��������Ҫ�󣬽��������������false��
		marked[row][col] = false;
		return false;
	}
}