package com.mys.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class demo6_������������� {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(Solution6.inorderTraversal(root));
		TreeDeal.midOrder(root);
	}

}
class Solution6 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(node != null || !stack.isEmpty()) {
        	//�����ǰ�ڵ㲻Ϊ�գ�һֱ�����ߣ���������Ԫ��ȫ������ջ
        	while(node != null) {
        		stack.push(node);
        		node = node.left;
        	}
        	
        	//�����ǰ�ڵ���null��˵������Ѿ������ˣ�ȡ��ջ��Ԫ�أ���������list�У�Ȼ��������
    		node = stack.pop();
			list.add(node.val);
			//Ȼ����ȥ���˽ڵ��Ƿ������ӽڵ�
			node = node.right;
        }
        return list;
    }
    
    /**
     * 	�������
     * @param root
     */
    public void midOrder(TreeNode root){
        Stack<TreeNode> sk = new Stack<TreeNode>();
        while(root!=null || !sk.isEmpty()){
            while(root!=null){
                sk.push(root);
                root = root.left;
            }
            if(!sk.isEmpty()){
                root = sk.pop();
                System.out.print(root.val);
                root = root.right;
            }
        }
    }
    
    /**
     * 	�������
     * 
     */
    public void preOrder(TreeNode root){
        //���������Ҫ��һ��ջ
        Stack<TreeNode> sk = new Stack();
        while(root!=null || !sk.isEmpty()){
            while(root!=null){
                System.out.print(root.val);
                sk.push(root);
                root = root.left;
            }
            if(!sk.isEmpty()){
                root = sk.pop().right;
            }
        }

    }

    /**
     * 	�������
     * @param root
     */
    public void postOrder(TreeNode root){
        Stack<TreeNode> sk1 = new Stack<TreeNode>();
        Stack<Integer> sk2 = new Stack<>();
        while(root!=null || !sk1.isEmpty()){
            while(root!=null){
                sk1.push(root);
                sk2.push(0);
                root = root.left;
            }

            while(!sk1.isEmpty() &&sk2.peek() == 1){
                sk2.pop();
                System.out.println(sk1.pop().val);
            }

            if(!sk1.isEmpty()){
                sk2.pop();
                sk2.push(1);
                root = sk1.peek();
                root = root.right;
            }
        }
    }

}