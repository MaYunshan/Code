package com.mys.tree;

import java.util.LinkedList;
import java.util.Queue;

public class demo3_对称二叉树 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		TreeDeal.preOrder(root);
		System.out.println();
		TreeDeal.midOrder(root);
		System.out.println();
		TreeDeal.postOrder(root);
		System.out.println();
		
		System.out.println(Solution3.isSymmetric1(root));
		
	}

}
class Solution3 {
	/**
	 * 	利用队列来判断二叉树的对称性
	 * 	每次向队列中添加镜像位置的两个元素，取出的时候连续取出两个元素，这两个元素肯定是处于镜像位置的元素
	 * @param root
	 * @return
	 */
    public static boolean isSymmetric(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	//如果根节点不为空，就将它的左右子树的元素添加到队列中，null值也添加
    	if (root != null) {
			queue.add(root.left);
			queue.add(root.right);
    	}
		while (!queue.isEmpty()) {
			//队列不为空时，连续取出两个元素，这两个元素在二叉树中处于镜像位置
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();
			System.out.println(node1+"==="+node2);
			//如果这两个元素都是null元素，重新取出两个元素
			if(node1 == null && node2 == null)
				continue;
			//如果一个为空一个为空，肯定不是对称的
			if(node1 ==null || node2 == null)
				return false;
			//如果这两个元素的值不相等
			if(node1.val != node2.val)
				return false;
			
			//开始往队列中添加元素
			
			//如果要添加的两个元素中有一个为空，直接返回
			if((node1.left == null && node2.right != null) || (node1.right == null && node2.left != null)) {
				return false;
			}
			else {
				//需要添加四个元素
				queue.add(node1.left);
				queue.add(node2.right);
				queue.add(node1.right);
				queue.add(node2.left);
			}
		}
    	return true;
    }
    
    /**
     * 递归解法
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
    	if(root != null)
    		return isSymm(root.left,root.right);
    	return true;
}

	private static boolean isSymm(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null)
			return true;
		if((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
			return false;
		}
		if(node1.val != node2.val){
			return false;
		}
		return isSymm(node1.left, node2.right) && isSymm(node1.right, node2.left);
		
	}
}