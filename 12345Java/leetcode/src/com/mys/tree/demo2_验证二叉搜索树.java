package com.mys.tree;


public class demo2_验证二叉搜索树 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(8);
		System.out.println(new Solution2().isValidBST(root));
	}

}
class Solution2 {
	/**
	 * 	如果二叉树是一个搜索二叉树，那么中序遍历的结果是一个有序的数组
	 * 	所以，判断是否是搜索二叉树就是找它的最大元素所在的位置
	 * 		如果最大元素在最后一位，则是搜索二叉树
	 * 		如果在二叉树中间的某个位置，则不是
	 */
	long value = Long.MIN_VALUE;
    public   boolean isValidBST(TreeNode root) {
    	if (root == null) {
			return true;
		}
    	boolean ans = true;
    	ans = ans && isValidBST(root.left);
    	if(value < root.val) {
    		value = root.val;
    	}
    	else {
    		return false;
    	}
    	ans = ans && isValidBST(root.right);
    	return ans;
    }
    
    
    /**
     *  这个方法是错误的方法，它只是判断每个节点处是否符合搜索二叉树，如果隔层出现，就会出错
     * @param root
     * @return
     */
    public   boolean isValidBST1(TreeNode root) {
    	if (root == null) {
			return true;
		}
    	boolean ans = true;
    	if (root.left != null) {
			if(root.val >= root.left.val) {
				ans = ans && isValidBST1(root.left);
			}
			else {
				return false;
			}
		}
    	
    	if (root.right != null) {
			if(root.val <= root.right.val) {
				ans = ans && isValidBST1(root.right);
			}
			else {
				return false;
			}
		}
    	return ans;
    }	
  
}