package com.mys.tree;

/**
 * 	·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣
 *
 */
public class demo95_�������е����·���� {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		int max = Solution95.maxPathSum(root);
		System.out.println(max);
	}

}       

class Solution95 {
	
	private static int maxValue = 0;
	
	/**
	 * 	��������һ���ڵ㣬���·�������������
	 * 		1����ǰ�ڵ�+������
	 * 		2����ǰ�ڵ�+������
	 * 		3����ǰ�ڵ�
	 * 		4����ǰ�ڵ�+������+������
	 * 	ǰ���������������Ϊ������ǰ�ڵ�����·���ͷ��ظ���һ�㣬���һ����������ԣ�������ֵ������4��
	 * 	��ô˵��·���Լ�ȷ���ˣ������ټ����µĽڵ���Ϊ·����һ���֣�������ֵֻ����ȫ�����ֵ��һ����ѡֵ
	 */
	public static int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		maxValue = root.val;
		dfs(root);
		return maxValue;
	}
	
	private static int dfs(TreeNode root) {
		if (root == null)
			return 0;
		
		//��õ�ǰ�ڵ��������е����·����
		int left = dfs(root.left);
		
		//��õ�ǰ�ڵ��������е����·����
		int right = dfs(root.right);
		
		int max = Math.max(left + root.val, right + root.val);
		
		/**
		 * 	ÿ�α����굱ǰ�ڵ������������ʱ��͸���һ�����ֵ�����ֵ�����������
		 * 		1����ǰ�ڵ����������е����·��֮��
		 * 		2����ǰ�ڵ����������е����·��֮��
		 * 		3�����������·������ǰ�ڵ㡢���������·������֮�͡��Žӣ����ֵ������Ϊ����ֵ���ص���һ�㡿
		 * 		4����һ�������ֵ��maxValue
		 */
		maxValue = Math.max(max, Math.max(maxValue, left+right+root.val));
		
		/**
		 * 	���ص���һ���ֵ���������
		 * 		1����ǰ�ڵ��������������·��֮��
		 *		2����ǰ�ڵ��������������·��֮��
		 *		3����ǰ�ڵ㣬û����������
		 */
		return Math.max(max, root.val);
	}
}