package com.mys.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 	����һ���������� nums����Ҫ�󷵻�һ�������� counts������ counts �и����ʣ�
 * 		 counts[i] ��ֵ��  nums[i] �Ҳ�С�� nums[i] ��Ԫ�ص�������
 * 
 */
public class demo96_�����Ҳ�С�ڵ�ǰԪ�صĸ��� {

	public static void main(String[] args) {
		int[] nums = {5,2,6,4,3,4};
		List<Integer> list = Solution96.countSmaller1(nums);
		System.out.println(list);
	}

}

class Solution96 {
	/**
	 * 	��������������飬���������i��Ԫ��ʱ����nums�з�ΧΪ[i...nums.length-1]��Ԫ������
	 * 	Ȼ�󵱱�����i-1��Ԫ��ʱ��ֱ�ӽ���Ԫ�ز����������õ������У��������������е�λ�þ������ұ߱���С��Ԫ��
	 */
    public static List<Integer> countSmaller(int[] nums) {
        if(nums == null)
        	return null;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
        	//������Ȼ���ȡ����
			int index = getSortIndex(nums,i,nums.length-1);
			list.add(0, index);
		}
    	return list;
    }

    /**
     * 	����nums[i+1...length]�Ѿ�������ģ�����nums[i]ȴ���ǣ�
     * 	�ú�����nums[i]������ʵ�λ��ʹ�������򣬲��ҷ���nums[i]������nums[i...length]�е����ղ���λ��
     * 
     */
	private static int getSortIndex(int[] nums, int i, int length) {
		int k = 0;
		int temp = nums[i];
		
		while(i < length && temp > nums[i+1]) {
			nums[i] = nums[i+1];
			k++;
			i++;
		}
		nums[i] = temp;
		return k;
	}
	
	
	/**
	 * 	����2��������������������ÿ��Ԫ���ұߵ�Ԫ�ع���Ϊһ�ö�����
	 * 		ÿһ���ڵ㶼��һ��count���ԣ�����ͳ�Ƹýڵ��������б���С��Ԫ�ظ���
	 */
	public static List<Integer> countSmaller1(int[] nums) {
        if(nums == null)
        	return null;
        List<Integer> list = new ArrayList<Integer>();
        BSTree tree = new BSTree();
        for (int i = nums.length - 1; i >= 0 ; i--) {
			int index = tree.add(nums[i]);
			list.add(0, index);
		}
    	return list;
    }
}


class BSTree{
	private class BSTNode{
		int val;
		int count;
		BSTNode left;
		BSTNode right;
	    BSTNode(int x)
	    { 
	    	val = x;
	    	count = 0;
	    	left = null;
	    	right = null;
	    }
	}
	private BSTNode root;
	private static int[] amount = new int[1];
	
	public int add(int value) {
		BSTNode newNode = new BSTNode(value);
		amount[0] = 0;
		root = add(root,newNode,amount);
		return amount[0];
	}

	/**
	 * 	�ݹ�Ĳ����½ڵ㣬�ڴ������±�������ʱ�����������
	 * 		����½ڵ�����ǰ�ڵ������ߣ���ǰ�ڵ��count��1����ʱ��amout����Ҫ���£�������ǰ�ڵ���������û�б��½ڵ��С��ֵ
	 * 		����½ڵ�����ǰ�ڵ���ұ��ߣ���ô����amout���µ�amoutΪԭ����amout�ӵ�ǰ�ڵ��Լ���ǰ�ڵ������������нڵ���Ŀ
	 */
	private BSTNode add(BSTNode rootNode, BSTNode newNode, int[] amount) {
		if(rootNode == null) {
			return newNode;
		}
		//����¼����Ԫ��С�ڵ��ڵ�ǰ�ڵ㣬��ô��ǰ�ڵ��count��1����ʾ�����ڵ�ǰ�ڵ��Ԫ����Ŀ����һ��
		else if(newNode.val <= rootNode.val) {
			rootNode.count = rootNode.count + 1;
			rootNode.left = add(rootNode.left, newNode, amount);
		}
		//�����Ԫ�رȵ�ǰ�ڵ�󣬵�ǰ�ڵ��count����Ҫ���£���Ϊcount��¼���ǲ����ڵ�ǰ�ڵ��Ԫ����Ŀ
		//amount��ֵ��Ҫ���£�amount= amount+��ǰ�ڵ���������Ԫ�ظ���(rootNode.count)+��ǰ�ڵ�(1)
		else {
			amount[0] = rootNode.count + amount[0] + 1;
			rootNode.right = add(rootNode.right, newNode, amount);					
		}	
		return rootNode;
	}
	
}