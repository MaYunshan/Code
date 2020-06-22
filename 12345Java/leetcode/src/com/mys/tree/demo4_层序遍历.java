package com.mys.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class demo4_层序遍历 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(Solution4.levelOrder1(root));
	}
}
class Solution4 {
	/**
	 * 	采用队列
	 * 	层序遍历，按层输出，将每一层的结果放进一个list里面
	 * [[1], [2, 2], [3, 4, 4, 3]]
	 * @param root
	 * @return
	 */
    public static List<List<Integer>> levelOrder(TreeNode root) {
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
    
    /**
	 * 	采用递归
	 * 	层序遍历，按层输出，将每一层的结果放进一个list里面
	 * [[1], [2, 2], [3, 4, 4, 3]]
	 * @param root
	 * @return
	 */
    public static List<List<Integer>> levelOrder1(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
        addLevel(list,root,0);
        return list;
    }

    /**
     * 	list是双层集合，list.size()代表层数
     * @param list
     * @param root
     * @param index : 代表层数
     */
	private static void addLevel(List<List<Integer>> list, TreeNode root, int index) {
		if(root == null) {
			return;
		}
		//如果当前list.size()的大小比index大，说明能够在index层添加元素
		if(list.size() > index) {
			list.get(index).add(root.val);
		}
		//否则，index层已经超过了list集合的大小，说明list需要重新加入一层
		else {
			ArrayList<Integer> subList = new ArrayList<Integer>();
			subList.add(root.val);
			list.add(subList);
		}
		addLevel(list, root.left, index+1);
		addLevel(list, root.right, index+1);
	}
}