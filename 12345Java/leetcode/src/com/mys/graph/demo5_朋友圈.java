package com.mys.graph;

/**
 * 	������ N ��ѧ����������Щ�������ѣ���Щ���ǡ����ǵ���������Ǵ����ԡ�
 * 	�����֪ A �� B �����ѣ�B �� C �����ѣ���ô���ǿ�����Ϊ A Ҳ�� C �����ѡ���ν������Ȧ����ָ�������ѵļ��ϡ�
 *	����һ�� N * N �ľ��� M����ʾ�༶��ѧ��֮������ѹ�ϵ�����M[i][j] = 1��
 *	��ʾ��֪�� i ���� j ��ѧ����Ϊ���ѹ�ϵ������Ϊ��֪����������������ѧ���е���֪������Ȧ������
 *	����: 
		[[1,1,0],
		 [1,1,0],
		 [0,0,1]]
	���: 2 
	˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�������һ������Ȧ����2��ѧ���Լ���һ������Ȧ�����Է���2��
 */
public class demo5_����Ȧ {

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
	 * 	����Ȧ������һ���ڽӾ�����������һ��ͼ��Ŀ�ľ��������ͼ���м�����ͨͼ
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
			//�����index������1��Ԫ�أ����һ�û�б����ʹ������еݹ�
			if(M[index][j] == 1 && visited[j] == false) {
				dfs(M, j, visited);
			}
		}
	}
}