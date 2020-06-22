package com.mys.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeDeal {
	//根据数组创建一棵二叉树
	public static void createTree(int[] arr) {
		
	}
	
	//先序遍历
	public static void preOrder(TreeNode node) {
		if(node != null) {
			System.out.print(node.val+"->");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	//中序遍历
	public static void midOrder(TreeNode node) {
		if(node != null) {
			midOrder(node.left);
			System.out.print(node.val+"->");
			midOrder(node.right);
		}
	}
	
	//后续遍历
	public static void postOrder(TreeNode node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.val+"->");
		}
	}
	
	//层序遍历
	public static void levelOrder(TreeNode node) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		while(!queue.isEmpty()) {
			TreeNode pNode = queue.remove();
			System.out.print(pNode.val+"->");
			if(pNode.left  != null)
				queue.add(pNode.left);
			if(pNode.right != null)
				queue.add(pNode.right);
		}
		
	}
	/**
	 * 层序遍历数组list
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root != null) {
        	 while(!queue.isEmpty()) {
             	int size = queue.size();
             	List<Integer> subList = new ArrayList<Integer>();
             	for (int i = 0; i < size; i++) {
     				TreeNode node = queue.poll();
     				subList.add(node.val);
     				if(node.left != null) {
     					queue.add(node.left);
     				}
     				if(node.right != null) {
     					queue.add(node.right);
     				}
     			}
             	list.add(subList);
             }
        }
        return list;
    }
	
}
