package com.mys.graph;

/**
 * 
 * 	����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά���񣬼��㵺���������
 * 	һ������ˮ��Χ����������ͨ��ˮƽ�����ֱ���������ڵ�½�����Ӷ��ɵġ�����Լ���������ĸ��߾���ˮ��Χ��
 * 
 * Ҫ�㣬��ͼ���м�����ͨͼ
 *
 */
public class demo1_������� {

	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		int ret = Solution1.numIslands(grid);
		System.out.println(ret);
	}

}
class Solution1 {
	/**
	 * 	��һ��mark������Ԫ���Ƿ񱻷��ʹ�
	 * 	�������еġ�1��Ԫ�أ�ÿ����һ��dfs���ã��ͻ��ҵ�һ����ͨͼ
	 * @param grid
	 * @return
	 */
    public static int numIslands(char[][] grid) {
    	int count = 0;
        if(grid.length != 0){
            int m = grid.length;
            int n = grid[0].length;
            boolean mark[][] = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == '1' && mark[i][j] == false) {
                        dfs(grid,mark,i,j);
                        count++;
                    }
                }
            }
        }
        return count;
    }

	private static void dfs(char[][] grid, boolean[][] mark, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;
		if(grid[i][j] == '0' || mark[i][j] == true)
			return;
		mark[i][j] = true;
		grid[i][j] = '0';
		dfs(grid,mark, i-1, j);
		dfs(grid,mark, i+1, j);
		dfs(grid,mark, i, j-1);
		dfs(grid,mark, i, j+1);
	}
	
	/**
	 * 	�ⷨ2��
	 * @param grid
	 * @return
	 */
	public int numIslands1(char[][] grid) {
        int count = 0;
        if(grid.length != 0){
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        dfs(grid,i,j);
                        count++;
                    }
                }
            }
        }
    	
        return count;
    }
	
	/**
	 * 	ÿ�α�����һ����1�����ͽ�����Ϊ��0�����������Ѿ������ʹ�
	 * @param grid
	 * @param i
	 * @param j
	 */
    private static void dfs(char[][] grid, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
			return;
		if(grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
	}
}