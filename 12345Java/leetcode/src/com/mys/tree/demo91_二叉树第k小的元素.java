package com.mys.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 	����һ����������������дһ������ kthSmallest ���������е� k ����С��Ԫ�ء�
 *  ����Լ��� k ������Ч�ģ�1 �� k �� ����������Ԫ�ظ�����
 *
 */
public class demo91_��������kС��Ԫ�� {

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
     * 	�����������������list�а�����Ԫ�ظ�������k����ʱ�򣬷��ؼ���
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