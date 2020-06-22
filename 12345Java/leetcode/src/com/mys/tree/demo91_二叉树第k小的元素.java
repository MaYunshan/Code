package com.mys.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 	给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *  你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 */
public class demo91_二叉树第k小的元素 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		TreeDeal.midOrder(root);
		int ret = Solution91.kthSmallest(root, 2);
		System.out.println(ret);
	}

}
class Solution91 {
    public static int kthSmallest(TreeNode root, int k) {
    	List<Integer> list = new ArrayList<Integer>();
    	inOrder(list,root,k);
    	System.out.println(list);
        return list.get(k-1);
    }

    /**
     * 	中序遍历二叉树，当list中包含的元素个数超过k个的时候，返回即可
     * @param list
     * @param root
     * @param k
     */
	private static void inOrder(List<Integer> list, TreeNode root,int k) {
		if(root != null) {
			inOrder(list, root.left,k);
			list.add(root.val);
			if(list.size() >= k)
				return;
			inOrder(list, root.right,k);
		}
	}

	
}