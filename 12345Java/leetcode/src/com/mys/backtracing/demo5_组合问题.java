package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class demo5_������� {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
		List<List<Integer>> listSub = Solution5.subsets1(nums);
		System.out.println(listSub);
	}

}
class Solution5 {
	
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= nums.length; i++) {
			dfs(lists, nums, 0, i, stack);
		}
        return lists;
    }
    
    public static void dfs(List<List<Integer>> lists,int[] nums,int index,int m,Stack<Integer> stack) {
    	
    	//�ݹ������������mΪ0ʱ��˵���Ѿ��ҵ���һ����ϣ�������
    	if(m == 0) {
    		List<Integer> list = new ArrayList<Integer>();
    		list.addAll(stack);
    		lists.add(list);
    		return;
    	}
    	//�ݹ鷶Χ�Ѿ���������ķ�Χ��ֱ�ӷ���
		 if(index >= nums.length)
			 return;
		 
		 //����ǰ��������Ԫ����ջ
		 stack.push(nums[index]);
		 dfs(lists, nums, index+1, m-1, stack);
		 //�ݹ�����������˵����index��Ԫ��Ϊ��ǰλ�ô�������Ѿ�ȫ���ҵ������Խ�index����Ԫ�ش�ջ�е���
		 stack.pop();
		 
		 //��index+1����Ԫ�ؼ���ջ��Ȼ������ݹ�
		 dfs(lists, nums, index+1, m, stack);
	}
    
    /**
     * 	�ó����е���ϣ�Cn0��Cn1��Cn2......Cnn
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        dfs1(lists, nums, 0, stack);
        return lists;
    }
    public static void dfs1(List<List<Integer>> lists,int[] nums,int index,List<Integer> list) {
    	
	}
}