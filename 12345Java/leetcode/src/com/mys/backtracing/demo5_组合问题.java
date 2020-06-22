package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class demo5_组合问题 {

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
    	
    	//递归结束条件，当m为0时，说明已经找到了一种组合，保存结果
    	if(m == 0) {
    		List<Integer> list = new ArrayList<Integer>();
    		list.addAll(stack);
    		lists.add(list);
    		return;
    	}
    	//递归范围已经超出数组的范围，直接返回
		 if(index >= nums.length)
			 return;
		 
		 //将当前索引处的元素入栈
		 stack.push(nums[index]);
		 dfs(lists, nums, index+1, m-1, stack);
		 //递归从这里出来，说明以index处元素为当前位置处的组合已经全部找到，所以将index处的元素从栈中弹出
		 stack.pop();
		 
		 //把index+1处的元素加入栈，然后继续递归
		 dfs(lists, nums, index+1, m, stack);
	}
    
    /**
     * 	拿出所有的组合，Cn0，Cn1，Cn2......Cnn
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