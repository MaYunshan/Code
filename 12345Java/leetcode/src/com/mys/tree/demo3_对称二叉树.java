package com.mys.tree;

import java.util.LinkedList;
import java.util.Queue;

public class demo3_�Գƶ����� {

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
	 * 	���ö������ж϶������ĶԳ���
	 * 	ÿ�����������Ӿ���λ�õ�����Ԫ�أ�ȡ����ʱ������ȡ������Ԫ�أ�������Ԫ�ؿ϶��Ǵ��ھ���λ�õ�Ԫ��
	 * @param root
	 * @return
	 */
    public static boolean isSymmetric(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	//������ڵ㲻Ϊ�գ��ͽ���������������Ԫ����ӵ������У�nullֵҲ���
    	if (root != null) {
			queue.add(root.left);
			queue.add(root.right);
    	}
		while (!queue.isEmpty()) {
			//���в�Ϊ��ʱ������ȡ������Ԫ�أ�������Ԫ���ڶ������д��ھ���λ��
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();
			System.out.println(node1+"==="+node2);
			//���������Ԫ�ض���nullԪ�أ�����ȡ������Ԫ��
			if(node1 == null && node2 == null)
				continue;
			//���һ��Ϊ��һ��Ϊ�գ��϶����ǶԳƵ�
			if(node1 ==null || node2 == null)
				return false;
			//���������Ԫ�ص�ֵ�����
			if(node1.val != node2.val)
				return false;
			
			//��ʼ�����������Ԫ��
			
			//���Ҫ��ӵ�����Ԫ������һ��Ϊ�գ�ֱ�ӷ���
			if((node1.left == null && node2.right != null) || (node1.right == null && node2.left != null)) {
				return false;
			}
			else {
				//��Ҫ����ĸ�Ԫ��
				queue.add(node1.left);
				queue.add(node2.right);
				queue.add(node1.right);
				queue.add(node2.left);
			}
		}
    	return true;
    }
    
    /**
     * �ݹ�ⷨ
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