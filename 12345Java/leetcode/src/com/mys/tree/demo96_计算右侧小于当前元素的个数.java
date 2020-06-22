package com.mys.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 	给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
 * 		 counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 
 */
public class demo96_计算右侧小于当前元素的个数 {

	public static void main(String[] args) {
		int[] nums = {5,2,6,4,3,4};
		List<Integer> list = Solution96.countSmaller1(nums);
		System.out.println(list);
	}

}

class Solution96 {
	/**
	 * 	从右往左遍历数组，当遍历完第i个元素时，将nums中范围为[i...nums.length-1]的元素排序
	 * 	然后当遍历第i-1个元素时，直接将该元素插入后面排序好的数组中，它在有序数组中的位置就是它右边比它小的元素
	 */
    public static List<Integer> countSmaller(int[] nums) {
        if(nums == null)
        	return null;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
        	//先排序，然后获取索引
			int index = getSortIndex(nums,i,nums.length-1);
			list.add(0, index);
		}
    	return list;
    }

    /**
     * 	数组nums[i+1...length]已经是有序的，但是nums[i]却不是，
     * 	该函数将nums[i]插入合适的位置使数组有序，并且返回nums[i]在数组nums[i...length]中的最终插入位置
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
	 * 	方法2：利用搜索二叉树，将每个元素右边的元素构造为一棵二叉树
	 * 		每一个节点都有一个count属性，用来统计该节点左子树中比它小的元素个数
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
	 * 	递归的插入新节点，在从上往下遍历树的时候做两项工作，
	 * 		如果新节点往当前节点的左边走，当前节点的count加1，此时，amout不需要更新，表名当前节点右子树中没有比新节点更小的值
	 * 		如果新节点往当前节点的右边走，那么更新amout，新的amout为原来的amout加当前节点以及当前节点左子树的所有节点数目
	 */
	private BSTNode add(BSTNode rootNode, BSTNode newNode, int[] amount) {
		if(rootNode == null) {
			return newNode;
		}
		//如果新加入的元素小于等于当前节点，那么当前节点的count加1，表示不大于当前节点的元素数目多了一个
		else if(newNode.val <= rootNode.val) {
			rootNode.count = rootNode.count + 1;
			rootNode.left = add(rootNode.left, newNode, amount);
		}
		//如果新元素比当前节点大，当前节点的count不需要更新，因为count记录的是不大于当前节点的元素数目
		//amount的值需要更新，amount= amount+当前节点左子树的元素个数(rootNode.count)+当前节点(1)
		else {
			amount[0] = rootNode.count + amount[0] + 1;
			rootNode.right = add(rootNode.right, newNode, amount);					
		}	
		return rootNode;
	}
	
}