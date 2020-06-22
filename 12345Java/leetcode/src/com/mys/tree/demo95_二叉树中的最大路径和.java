package com.mys.tree;

/**
 * 	路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 */
public class demo95_二叉树中的最大路径和 {

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
	 * 	对于任意一个节点，最大路径和有四种情况
	 * 		1、当前节点+左子树
	 * 		2、当前节点+右子树
	 * 		3、当前节点
	 * 		4、当前节点+左子树+右子树
	 * 	前三种情况都可以作为包含当前节点的最大路径和返回给上一层，最后一种情况不可以，如果最大值来自于4，
	 * 	那么说明路径以及确定了，不能再加入新的节点作为路径的一部分，这个最大值只能是全局最大值的一个备选值
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
		
		//获得当前节点左子树中的最大路径和
		int left = dfs(root.left);
		
		//获得当前节点右子树中的最大路径和
		int right = dfs(root.right);
		
		int max = Math.max(left + root.val, right + root.val);
		
		/**
		 * 	每次遍历完当前节点的左右子树的时候就更新一次最大值，最大值来自四种情况
		 * 		1、当前节点与左子树中的最大路径之和
		 * 		2、当前节点与右子树中的最大路径之和
		 * 		3、左子树最大路径、当前节点、右子树最大路径三者之和【桥接，这个值不能作为返回值返回到上一层】
		 * 		4、上一步的最大值：maxValue
		 */
		maxValue = Math.max(max, Math.max(maxValue, left+right+root.val));
		
		/**
		 * 	返回到上一层的值有三种情况
		 * 		1，当前节点与左子树的最大路径之和
		 *		2，当前节点与右子树的最大路径之和
		 *		3，当前节点，没有左右子树
		 */
		return Math.max(max, root.val);
	}
}