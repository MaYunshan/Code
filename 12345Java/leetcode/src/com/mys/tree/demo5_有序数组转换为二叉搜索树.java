package com.mys.tree;


public class demo5_有序数组转换为二叉搜索树 {

	public static void main(String[] args) {
		int[] arrs = {0,1,2,3,4,5};
		TreeNode root = Solution5.sortedArrayToBST(arrs);
		System.out.println(TreeDeal.levelOrder1(root));
	}

}
class Solution5 {
	/**
	 * 	分治思想
	 * 
	 * @param nums
	 * @return
	 */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0,nums.length-1);
    }

	private static TreeNode insert(int[] nums, int l, int r) {
		//递归结束的条件
		if(l > r) {
			return null;
		}
		int mid = l + (r - l)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = insert(nums, l, mid-1);
		root.right = insert(nums, mid+1, r);
		return root;
	}

	private static TreeNode insert(TreeNode root, int x) {
		if (root == null) {
			return new TreeNode(x);
		}else if (x < root.val) {
			root.left = insert(root.left, x);
		}else {
			root.right = insert(root.right, x);
		}
		return root;
	}
    
    
}