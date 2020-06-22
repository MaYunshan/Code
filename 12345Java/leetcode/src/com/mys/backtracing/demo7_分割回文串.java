package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 	����һ���ַ��� s���� s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���
 *	���� s ���п��ܵķָ����
 *	ʾ��:
 *		����: "aab"
 *		���:
 *			[
 *			  ["aa","b"],
 *			  ["a","a","b"]
 *			]
 *
 */
public class demo7_�ָ���Ĵ� {

	public static void main(String[] args) {
		String str = "ababa";
		List<List<String>> lists = Solution7.partition(str);
		System.out.println(lists);
	}

}
class Solution7 {
	/**
	 * 	���������һ���ַ����ķָʽ��Ҫ��ָ��Ժ��ÿ���ַ������ǻ����ַ���
	 * 	�ָ�Ĺ���Ϊ��
	 * 		1��1��1��1��1��1��1��1		���϶���������
	 * 		1��1��1��1��1��1��1��2		����������
	 * 		1��1��1��1��1��1��2		���п�����������
	 * 		1��1��1��1��1��2��1		���п�����������
	 * 		1��1��1��1��1��2��2		����������
	 * 		1��1��1��1��2��1��1		���п�����������
	 * 		������
	 * 		2��1��1��1��1��1��1
	 * 		������
	 * 		2��2��2��2
	 * 		������
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
		
		//�ҵ���һ�ַָʽ��������
		if(index == s.length()) {
			List<String> list = new ArrayList<String>(stack);
			lists.add(list);
			return;
		}
		
		//�ָ�ĳ��ȴ�1��ʼ�����Ϊ�����ַ����ĳ���
		for (int len = 1; len <= s.length(); len++) {
			//[index,index+len)Ϊ�ָ��һ�����䣬��Ҫ�ж�[index,index+len-1]��Χ�Ƿ���һ�������ַ���
			if (index + len <= s.length() && isPalindrome(s, index, index + len - 1)) {
				
				//�����е�һ���ָ��ַ�����ջ
				stack.push(s.substring(index, index + len));

				//������index+len��ʼ��������ȡ�ַ����������ж�����ȡ���ַ����Ƿ��ǻ����ַ���
				dfs(lists, s, stack, index + len);

				//����һ��������ַ�����ջ
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