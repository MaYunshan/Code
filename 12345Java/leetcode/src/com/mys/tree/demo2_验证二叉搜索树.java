package com.mys.tree;


public class demo2_��֤���������� {

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
	 * 	�����������һ����������������ô��������Ľ����һ�����������
	 * 	���ԣ��ж��Ƿ��������������������������Ԫ�����ڵ�λ��
	 * 		������Ԫ�������һλ����������������
	 * 		����ڶ������м��ĳ��λ�ã�����
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
     *  ��������Ǵ���ķ�������ֻ���ж�ÿ���ڵ㴦�Ƿ�������������������������֣��ͻ����
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