package com.mys.graph;

/**
 * 
 * 	给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 	一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 要点，求图中有几个连通图
 *
 */
public class demo1_岛屿个数 {

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
	 * 	用一个mark数组标记元素是否被访问过
	 * 	遍历所有的‘1’元素，每进行一次dfs调用，就会找到一个连通图
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
	 * 	解法2：
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
	 * 	每次遍历到一个‘1’，就将它置为‘0’，代表它已经被访问过
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