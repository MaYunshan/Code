package com.mys.tree;

public class demo8_ǰ�������������� {

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
	 * 	�ⷨ3:���Ρ��ݹ鹹��
	 * 	preorder = {1,2,7,4,3,5,6};
	 *  inorder = {7,2,4,1,5,3,6};
	 *  ���ȹ�����ڵ㣬Ȼ�󹹽���������Ȼ�󹹽��������������������ұգ����������������Ĺ����õݹ�
	 *  	����[root��������Ԫ�أ�������Ԫ��]
	 *  	����[������Ԫ�أ�root��������Ԫ��]
	 *  		���ֱ����У������������䷶Χ����ͬ�ģ�����������������䷶Χ������������������䷶Χ������һλ
	 *  1.�Ե�ǰ��������arr�ĵ�һ��Ԫ�ع���root��Ȼ���ҵ������������root�Ĳ�ֵcount�����ֵ����root��������������Ԫ�ظ���
	 *  	��ô��arr���У�������Ԫ�ص����䷶Χ��[prefirst+1,prefirst+count](prefirst��root������)
	 *  		��Ӧ�������������У�������Ԫ�ص����䷶Χ��[infirst,infirst+count+1]
	 *  	��arr�У�������Ԫ�ص����䷶Χ��[first+1+count��last](last���������һ��Ԫ�ص�����)
	 *  		��Ӧ�������������У�������Ԫ�ص����䷶Χ��[inFirst+count+1,inLast]
	 *  2.��ʼ������������������
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
	 * 	1.��preorder[0]��Ϊroot
	 * 	2.����preorder���飬�ֱ���ڵ�node�����ҵ������յ�λ�ã�Ȼ���ٲ���,pNode�ڵ�ָ��root
	 * 	3.��pNode==node��Ϊѭ����������
	 * 		3.1��������������У�node.val��pNode.val����ߣ���ônode�ڵ����ջ���pNode�����
	 * 			3.1.1��ʱ�����pNode.leftΪ���ˣ�����pNode.left=node,,������pNodeָ��node����Ϊѭ������ֹ����
	 * 			3.1.2���pNode��Ϊ�գ�����pNode=pNode.left
	 * 		3.2��������������У�node.val��pNode.val���ұ߱ߣ���ônode�ڵ����ջ���pNode���ұ�
	 * 			3.2.1��ʱ�����pNode.rightΪ���ˣ�����pNode.right=node,,������pNodeָ��node����Ϊѭ������ֹ����
	 * 			3.2.2���pNode��Ϊ�գ�����pNode=pNode.right
	 */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
        	return null;
        //������ڵ�
    	TreeNode root = new TreeNode(preorder[0]);
    	TreeNode pNode = root;
    	for (int i = 1; i < preorder.length; i++) {
    		//�����������飬�ֱ���node�ڵ�
			TreeNode node = new TreeNode(preorder[i]);
			//�ڲ���ÿһ��node֮ǰ����pNodeָ��root���Ӹ�����ʼ��λ��
			pNode = root;
			while(pNode != node) {
				//��������������У�node.val��pNode.val�����
				if (isLeft(pNode.val, node.val, inorder)) {
					//���pNode.leftΪ�գ�˵��node��λ���Ѿ��ҵ������뼴��
					if(pNode.left == null) {
						pNode.left = node;
						//��һ������������ֹѭ��
						pNode = node;
					}
					else {
						pNode = pNode.left;
					}
				}
				//��������������У�node.val��pNode.val���ұ�
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
        //������ڵ�
    	TreeNode root = new TreeNode(preorder[0]);
    	TreeNode pNode = root;
    	for (int i = 1; i < preorder.length; i++) {
    		//�����������飬�ֱ���node�ڵ�
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
     * 	�����ж�������inorder�У�parentValue��ֵ�Ƿ���nodeValue�����
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