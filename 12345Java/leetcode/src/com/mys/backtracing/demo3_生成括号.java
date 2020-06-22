package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 	给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @author dell
 *
 */
public class demo3_生成括号 {

	public static void main(String[] args) {
		List<String> list = Solution3.generateParenthesis(3);
		System.out.println(list);
	}

}
class Solution3 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        bracket(list,sb,0,0,n);
        return list;
    }
    
    /**
     *	 在将一个括号放入当前栈中需要考虑两个因素
     * 		1.就是左括号的个数不能超过n，left<n
	 *		2.如果要放入右括号，那么必须保证当前栈中，左括号的个数必须大于右括号的个数,left>right
	 *
     * @param list:用来保存结果的字符串集合
     * @param sb：用来模拟记录当前正在遍历的字符串的栈
     * @param left：左括号的个数
     * @param right：右括号的个数
     * @param n：括号对数
     */
	private static void bracket(List<String> list, StringBuilder sb, int left, int right, int n) {
		//如果当前栈的长度是括号对数的两倍，说明已经找到了一种组合方式，加入集合
		if(sb.length() == n*2) {
			list.add(sb.toString());
			return;
		}
		
		if(left < n) {
			//左括号的个数符合要求，在当前栈中放入一个左括号
			sb.append('(');
			bracket(list, sb, left+1, right, n);
			//从这里出来以后，要将刚刚放的左括号出栈
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(right < left) {
			//左括号够数了，在当前栈中放入一个右括号
			sb.append(')');
			bracket(list, sb, left, right+1, n);
			//同样，将刚刚入栈的右括号出栈
			sb.deleteCharAt(sb.length()-1);
		}
		
	}
}