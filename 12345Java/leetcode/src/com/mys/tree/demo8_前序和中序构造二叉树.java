package com.mys.tree;

public class demo8_前序和中序构造二叉树 {

	public static void main(String[] args) {
		int[] preorder = {1,2,7,4,3,5,6};
		int[] inorder = {7,2,4,1,5,3,6};
		TreeNode root = Solution8.buildTree2(preorder, inorder);
		TreeDeal.preOrder(root);
		System.out.println();
		TreeDeal.midOrder(root);
	}

}
class Solution8 {
	
	/**
	 * 	解法3:分治、递归构造
	 * 	preorder = {1,2,7,4,3,5,6};
	 *  inorder = {7,2,4,1,5,3,6};
	 *  首先构造根节点，然后构建左子树，然后构建右子树，区间采用左闭右闭，左子树和右子树的构造用递归
	 *  	先序：[root，左子树元素，右子树元素]
	 *  	中序：[左子树元素，root，右子树元素]
	 *  		两种遍历中，右子树的区间范围是相同的，先序的左子树的区间范围比中序的左子树的区间范围右移了一位
	 *  1.以当前先序数组arr的第一个元素构造root，然后找到先序和中序中root的差值count，这个值就是root的所有左子树的元素个数
	 *  	那么在arr中中，左子树元素的区间范围是[prefirst+1,prefirst+count](prefirst是root的索引)
	 *  		对应的在中序数组中，左子树元素的区间范围是[infirst,infirst+count+1]
	 *  	在arr中，右子树元素的区间范围是[first+1+count，last](last是数组最后一个元素的索引)
	 *  		对应的在中序数组中，右子树元素的区间范围是[inFirst+count+1,inLast]
	 *  2.开始构造左子树和右子树
	 *  	root.left = recu(prefirst+1,prefirst+count,preorder,infirst,infirst+count-1,inorder)
	 *  	root.right = recu(prefirst+count+1,prelast,preorder,infirst+count+1,inlast,inorder)
	 *  
	 */
	public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
        	return null;
        TreeNode root = recurse(0,preorder.length-1,preorder,0,inorder.length-1,inorder);
    	return root;
    }
	
	
	private static TreeNode recurse(int preFirst, int preLast, int[] preorder,int inFirst, int inLast, int[] inorder) {
		if(preFirst > preLast || inFirst > inLast)
			return null;
		System.out.println(preFirst+"\t"+preLast+"\t"+inFirst+"\t"+inLast);
		TreeNode root = new TreeNode(preorder[preFirst]);
		int count = 0;
		for (int i = inFirst; i <= inLast; i++) {
			if(preorder[preFirst] == inorder[i])
				break;
			count++;
		}
		root.left = recurse(preFirst+1, preFirst+count, preorder,inFirst,inFirst+count-1, inorder);
		root.right = recurse(preFirst+count+1, preLast, preorder,inFirst+count+1,inLast, inorder);
		
		return root;
	}


	/**
	 * 	1.以preorder[0]作为root
	 * 	2.遍历preorder数组，分别构造节点node，先找到它最终的位置，然后再插入,pNode节点指向root
	 * 	3.以pNode==node作为循环结束条件
	 * 		3.1如果在中序数组中，node.val在pNode.val的左边，那么node节点最终会在pNode的左边
	 * 			3.1.1此时，如果pNode.left为空了，则让pNode.left=node,,并且让pNode指向node，作为循环的终止条件
	 * 			3.1.2如果pNode不为空，则让pNode=pNode.left
	 * 		3.2如果在中序数组中，node.val在pNode.val的右边边，那么node节点最终会在pNode的右边
	 * 			3.2.1此时，如果pNode.right为空了，则让pNode.right=node,,并且让pNode指向node，作为循环的终止条件
	 * 			3.2.2如果pNode不为空，则让pNode=pNode.right
	 */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
        	return null;
        //构造根节点
    	TreeNode root = new TreeNode(preorder[0]);
    	TreeNode pNode = root;
    	for (int i = 1; i < preorder.length; i++) {
    		//遍历先序数组，分别构造node节点
			TreeNode node = new TreeNode(preorder[i]);
			//在插入每一个node之前，让pNode指向root，从根部开始找位置
			pNode = root;
			while(pNode != node) {
				//如果在中序数组中，node.val在pNode.val的左边
				if (isLeft(pNode.val, node.val, inorder)) {
					//如果pNode.left为空，说明node的位置已经找到，插入即可
					if(pNode.left == null) {
						pNode.left = node;
						//这一步设置用来终止循环
						pNode = node;
					}
					else {
						pNode = pNode.left;
					}
				}
				//如果在中序数组中，node.val在pNode.val的右边
				else {
					if(pNode.right == null) {
						pNode.right = node;
						pNode = node;
					}
					else {
						pNode = pNode.right;
					}
				}
			}
		}
    	return root;
    }
    
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
        	return null;
        //构造根节点
    	TreeNode root = new TreeNode(preorder[0]);
    	TreeNode pNode = root;
    	for (int i = 1; i < preorder.length; i++) {
    		//遍历先序数组，分别构造node节点
			TreeNode node = new TreeNode(preorder[i]);
			insert(pNode,node,inorder);
		}
    	return root;
    }

    private static TreeNode insert(TreeNode pNode, TreeNode node, int[] inorder) {
    	if(pNode == null) {
    		pNode = node;
    		return pNode;
    	}
    	if(isLeft(pNode.val, node.val, inorder)) {
    		pNode.left = insert(pNode.left, node, inorder);
    	}else {
    		pNode.right = insert(pNode.right, node, inorder);
		}
    	return pNode;
	}

	/**
     * 	用来判断在数组inorder中，parentValue的值是否在nodeValue的左边
     */
	private static boolean isLeft(int parentValue, int nodeValue, int[] inorder) {
		int indexX = -1;
		int indexY = -1;
		for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] == parentValue) {
				indexX = i;
			}
			else if (inorder[i] == nodeValue) {
				indexY = i;
			}
			if(indexX != -1 && indexY != -1)
				break;
		}
		return indexY < indexX;
	}
}