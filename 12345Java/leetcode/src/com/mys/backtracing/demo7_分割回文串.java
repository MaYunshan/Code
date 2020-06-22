package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 	给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *	返回 s 所有可能的分割方案。
 *	示例:
 *		输入: "aab"
 *		输出:
 *			[
 *			  ["aa","b"],
 *			  ["a","a","b"]
 *			]
 *
 */
public class demo7_分割回文串 {

	public static void main(String[] args) {
		String str = "ababa";
		List<List<String>> lists = Solution7.partition(str);
		System.out.println(lists);
	}

}
class Solution7 {
	/**
	 * 	此题就是求一种字符串的分割方式，要求分割以后的每个字符串都是回文字符串
	 * 	分割的过程为：
	 * 		1、1、1、1、1、1、1、1		：肯定满足条件
	 * 		1、1、1、1、1、1、1、2		：超出索引
	 * 		1、1、1、1、1、1、2		：有可能满足条件
	 * 		1、1、1、1、1、2、1		：有可能满足条件
	 * 		1、1、1、1、1、2、2		：超出索引
	 * 		1、1、1、1、2、1、1		：有可能满足条件
	 * 		。。。
	 * 		2、1、1、1、1、1、1
	 * 		。。。
	 * 		2、2、2、2
	 * 		。。。
	 * 		8
	 * @param s
	 * @return
	 */
    public static List<List<String>> partition(String s) {
        if(s == null)
        	return null;
        List<List<String>> lists = new ArrayList<List<String>>();
        Stack<String> stack = new Stack<String>();
        dfs(lists,s,stack,0);
    	return lists;
    }

	private static void dfs(List<List<String>> lists, String s, Stack<String> stack, int index) {
		
		//找到了一种分割方式，保存结果
		if(index == s.length()) {
			List<String> list = new ArrayList<String>(stack);
			lists.add(list);
			return;
		}
		
		//分割的长度从1开始，最大为整个字符串的长度
		for (int len = 1; len <= s.length(); len++) {
			//[index,index+len)为分割的一个区间，需要判断[index,index+len-1]范围是否是一个回文字符串
			if (index + len <= s.length() && isPalindrome(s, index, index + len - 1)) {
				
				//把其中的一个分割字符串入栈
				stack.push(s.substring(index, index + len));

				//从所有index+len开始，继续截取字符串，并且判断所截取的字符串是否是回文字符串
				dfs(lists, s, stack, index + len);

				//将上一个加入的字符串出栈
				stack.pop();
			}
		}
	}
	
	private static boolean isPalindrome(String s, int i, int j) {
		while(i <= j) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}