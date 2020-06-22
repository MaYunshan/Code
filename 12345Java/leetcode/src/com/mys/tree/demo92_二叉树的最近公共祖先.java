package com.mys.tree;

/**
 *	 ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 */
public class demo92_������������������� {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		TreeNode p = new TreeNode(4);
		root.left.left = p;
		
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		TreeNode q = new TreeNode(7);
		root.right.right = q;
		
		TreeNode parent = Solution92.lowestCommonAncestor(root, p, q);
		System.out.println(parent.val);
	}

}
class Solution92 {
	/**
	 * 	�����ⷨ���ݹ�
	 * 		��root�����������н�ȥ��p����q���������root������ҵ��ģ���¼����ֵleft���������root���ұ��ҵ��ģ���¼����ֵright
	 * 		���left��right����Ϊ�գ�˵��һ������root����������һ������root������������Ȼ��root��������Ĺ������ڵ�
	 * 		���left��right����null��˵����p��q�����Ե�ǰrootΪ���ڵ������
	 * 		���left��rightһ��Ϊ��һ����Ϊ�գ�˵����root��ȥ��ֻ���ҵ�һ���ڵ㣬�����¼�������ֵ��Ȼ�󷵻���һ�㣬��root�ĸ��ڵ��м���Ѱ����һ���ڵ�
	 */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    	if(root == null || root == p || root == q)
    		return root;
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	if(left != null && right != null) {
    		return root;
    	}
    	else if (left != null) {
    		return left;
		}
    	else if(right != null) {
    		return right;
    	}
    	return null;
    }
}