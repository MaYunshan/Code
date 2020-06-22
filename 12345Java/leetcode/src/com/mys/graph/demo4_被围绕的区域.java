package com.mys.graph;
/**
 * 	����һ����ά�ľ��󣬰��� 'X' �� 'O'����ĸ O����
 *	�ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е� 'O' �� 'X' ��䡣
 *	ʾ��:
	X X X X
	X O O X
	X X O X
	X O X X
	
 *	������ĺ����󣬾����Ϊ��
	X X X X
	X X X X
	X X X X
	X O X X
	
 *	����:
 *		��Χ�Ƶ����䲻������ڱ߽��ϣ����仰˵���κα߽��ϵ� 'O' �����ᱻ���Ϊ 'X'�� 
 *		�κβ��ڱ߽��ϣ�����߽��ϵ� 'O' ������ 'O' ���ն��ᱻ���Ϊ 'X'���������Ԫ����ˮƽ��ֱ�������ڣ���������ǡ��������ġ�
 */
public class demo4_��Χ�Ƶ����� {

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
	 * 	�ӱ�Ե��'O'��ʼ����dfs������ӱ�Ե��'O'�������ڲ���'O'��˵����������ͨ�ģ�����Щ�ͱ�Ե��'O'��ͨ��'O'��ǣ���
	 * 	Ȼ��ڶ���ѭ��board�����ڲ�û�б�ǵ�'O'ȫ���滻Ϊ'X'
	 */
    public static void solve(char[][] board) {
    	if(board == null || board.length == 0)
    		return;
    	int m = board.length;
    	int n = board[0].length;
		boolean[][] marked = new boolean[m][n];
		
		
		//�������л�û�б���ǵĴ��ڱ�Եλ�õ�'O'
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if((i == 0 || i== m-1 || j == 0 || j == n-1) && board[i][j] == 'O' && marked[i][j] == false) {
					dfs(board,i,j,marked);
				}
			}
		}
		
		//�������ڲ���û�б��ǵ�'O'ȫ���滻Ϊ'X'
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
		
		//�������ǰλ�ô���Ԫ����'X'�������ǵ�ǰλ�ô���'O'�Ѿ������ʹ��ˣ�ֱ�ӷ���
		if(board[i][j] == 'X' || marked[i][j] == true)
			return;
		

		marked[i][j] = true;

		dfs(board, i - 1, j, marked);
		dfs(board, i + 1, j, marked);
		dfs(board, i, j - 1, marked);
		dfs(board, i, j + 1, marked);
	}
}