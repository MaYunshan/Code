package com.mys.tree;

import java.util.LinkedList;
import java.util.Queue;

public class demo1_二叉树的深度 {

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
	 * 	利用bfs求深度
	 * 	从这段程序里还可以得到二叉树的最大宽度
	 * 	把每一层上的size保存，最后取最大值就可以
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
        	//size用来获取树的每一层上有多少个元素
        	for (int i = 0; i < size; i++) {
				TreeNode node = queue.remove();
				if(node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
        	//循环从这里出来，上一层所有的元素已经出栈，当前栈内所有的元素都是属于下一层的
        	height++;
        }
    	return height;
    }
    
    /**
     * 	利用dfs求深度
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {
    	if(root == null)
    		return 0;
    	//返回当前节点左子树的深度
    	int m = maxDepth(root.left);
    	//返回当前节点右子树的深度
    	int n = maxDepth(root.right);
    	
    	//判断左子树和右子树的高度，留下深度深的值，然后算上当前节点的这一层，返回上一层
    	return m > n ? m+1 :n+1;
    	
    }
}