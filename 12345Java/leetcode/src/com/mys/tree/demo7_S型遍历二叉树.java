package com.mys.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class demo7_S型遍历二叉树 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(Solution7.zigzagLevelOrder(root));
	}

}
class Solution7 {
	/**
	 *  用一个level表示层数，在形成每一层的子集合时，根据层数控制是尾插法还是头插法
	 */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int level = 0; //表示当前的层数
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root != null) {
        	 while(!queue.isEmpty()) {
             	int size = queue.size();
             	List<Integer> subList = new ArrayList<Integer>();    //用来保存一层元素的集合
             	for (int i = 0; i < size; i++) {
     				TreeNode node = queue.poll();
     				if(level % 2 == 0) {
     					//偶数层，尾插法进入subList中
     					subList.add(node.val);
     				}
     				else {
     					//奇数层，头插法进入subList中
						subList.add(0,node.val);
					}
     				if(node.left != null) {
     					queue.add(node.left);
     				}
     				if(node.right != null) {
     					queue.add(node.right);
     				}
				}
             	//每一层结束之后，层数+1
             	level++;
             	list.add(subList);
             }
        }
        return list;
    }
}