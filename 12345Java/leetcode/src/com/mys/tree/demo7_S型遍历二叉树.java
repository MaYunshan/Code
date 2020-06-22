package com.mys.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class demo7_S�ͱ��������� {

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
	 *  ��һ��level��ʾ���������γ�ÿһ����Ӽ���ʱ�����ݲ���������β�巨����ͷ�巨
	 */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int level = 0; //��ʾ��ǰ�Ĳ���
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root != null) {
        	 while(!queue.isEmpty()) {
             	int size = queue.size();
             	List<Integer> subList = new ArrayList<Integer>();    //��������һ��Ԫ�صļ���
             	for (int i = 0; i < size; i++) {
     				TreeNode node = queue.poll();
     				if(level % 2 == 0) {
     					//ż���㣬β�巨����subList��
     					subList.add(node.val);
     				}
     				else {
     					//�����㣬ͷ�巨����subList��
						subList.add(0,node.val);
					}
     				if(node.left != null) {
     					queue.add(node.left);
     				}
     				if(node.right != null) {
     					queue.add(node.right);
     				}
				}
             	//ÿһ�����֮�󣬲���+1
             	level++;
             	list.add(subList);
             }
        }
        return list;
    }
}