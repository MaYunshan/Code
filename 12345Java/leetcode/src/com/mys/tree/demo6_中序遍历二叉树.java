package com.mys.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class demo6_中序遍历二叉树 {

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
        	//如果当前节点不为空，一直往左走，将碰到的元素全部加入栈
        	while(node != null) {
        		stack.push(node);
        		node = node.left;
        	}
        	
        	//如果当前节点是null，说明左边已经到底了，取出栈顶元素，将它加入list中，然后往右走
    		node = stack.pop();
			list.add(node.val);
			//然后再去看此节点是否有右子节点
			node = node.right;
        }
        return list;
    }
    
    /**
     * 	中序遍历
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
     * 	先序遍历
     * 
     */
    public void preOrder(TreeNode root){
        //先序遍历需要用一个栈
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
     * 	后序遍历
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