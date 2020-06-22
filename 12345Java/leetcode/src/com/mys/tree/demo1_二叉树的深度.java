package com.mys.tree;

import java.util.LinkedList;
import java.util.Queue;

public class demo1_����������� {

	public static void main(String[] args) {
		
		/**
		 *       3
		 *      / \
		 *     9   20
		 *        /  \
		 *       15   7
		 */
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		int depth = Solution1.maxDepth1(root);
		System.out.println(depth);
	}
	
}
class Solution1 {
	/**
	 * 	����bfs�����
	 * 	����γ����ﻹ���Եõ��������������
	 * 	��ÿһ���ϵ�size���棬���ȡ���ֵ�Ϳ���
	 * @param root
	 * @return
	 */
    public static int maxDepth(TreeNode root) {
    	if(root == null)
    		return 0;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
        int height = 0;
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	//size������ȡ����ÿһ�����ж��ٸ�Ԫ��
        	for (int i = 0; i < size; i++) {
				TreeNode node = queue.remove();
				if(node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
        	//ѭ���������������һ�����е�Ԫ���Ѿ���ջ����ǰջ�����е�Ԫ�ض���������һ���
        	height++;
        }
    	return height;
    }
    
    /**
     * 	����dfs�����
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {
    	if(root == null)
    		return 0;
    	//���ص�ǰ�ڵ������������
    	int m = maxDepth(root.left);
    	//���ص�ǰ�ڵ������������
    	int n = maxDepth(root.right);
    	
    	//�ж����������������ĸ߶ȣ�����������ֵ��Ȼ�����ϵ�ǰ�ڵ����һ�㣬������һ��
    	return m > n ? m+1 :n+1;
    	
    }
}