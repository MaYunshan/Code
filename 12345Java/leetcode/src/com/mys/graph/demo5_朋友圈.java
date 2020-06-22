package com.mys.graph;

/**
 * 	班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 	如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *	给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
 *	表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *	输入: 
		[[1,1,0],
		 [1,1,0],
		 [0,0,1]]
	输出: 2 
	说明：已知学生0和学生1互为朋友，他们在一个朋友圈。第2个学生自己在一个朋友圈。所以返回2。
 */
public class demo5_朋友圈 {

	public static void main(String[] args) {
		int[][] friends = {
				{1,1,0},
				{1,1,0},
				{0,0,1}
		};
		
		int num = Solution5.findCircleNum(friends);
		System.out.println(num);
	}

}
class Solution5 {
	/**
	 * 	朋友圈矩阵是一个邻接矩阵，它构成了一幅图，目的就是找这幅图中有几个连通图
	 */
    public static int findCircleNum(int[][] M) {
    	if(M == null || M.length == 0)
    		return 0;
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < visited.length; i++) {
			if(visited[i] == false) {
				dfs(M, i, visited);
				count++;
			}
		}
        return count;
    }

	private static void dfs(int[][] M, int index, boolean[] visited) {
		visited[index] = true;
		for (int j = 0; j < M[index].length; j++) {
			//如果第index行中有1的元素，并且还没有被访问过，进行递归
			if(M[index][j] == 1 && visited[j] == false) {
				dfs(M, j, visited);
			}
		}
	}
}