package com.mys.tree;

/**
 *	 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class demo92_二叉树的最近公共祖先 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		TreeNode p = new TreeNode(4);
		root.left.left = p;
		
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		TreeNode q = new TreeNode(7);
		root.right.right = q;
		
		TreeNode parent = Solution92.lowestCommonAncestor(root, p, q);
		System.out.println(parent.val);
	}

}
class Solution92 {
	/**
	 * 	暴力解法：递归
	 * 		从root的左右子树中进去找p或者q，如果是在root的左边找到的，记录返回值left，如果是在root的右边找到的，记录返回值right
	 * 		如果left和right都不为空，说明一个来自root的左子树，一个来自root的右子树，显然，root就是最近的公共父节点
	 * 		如果left和right都是null，说明，p和q不在以当前root为根节点的树中
	 * 		如果left和right一个为空一个不为空，说明从root进去，只能找到一个节点，，则记录这个返回值，然后返回上一层，从root的父节点中继续寻找另一个节点
	 */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    	if(root == null || root == p || root == q)
    		return root;
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	if(left != null && right != null) {
    		return root;
    	}
    	else if (left != null) {
    		return left;
		}
    	else if(right != null) {
    		return right;
    	}
    	return null;
    }
}