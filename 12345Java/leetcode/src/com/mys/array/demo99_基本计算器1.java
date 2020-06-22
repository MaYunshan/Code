package com.mys.array;

import java.util.Stack;

/**
 * 	字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  
 * @author dell
 *
 */
public class demo99_基本计算器1 {

	public static void main(String[] args) {
		String str = "2-(4-6)";
		int ret = Solution991.calculate(str);
		System.out.println(ret);
	}

}
class Solution991 {
    public static int calculate(String s) {
        int ret = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
			if(ch >= '0' && ch <= '9') {
				num = num *10 -'0' + s.charAt(i);
			}
			else {
				ret = ret + sign * num;
				num = 0;
				if(s.charAt(i) == '+') {
					sign = 1;
				}
				else if(ch == '-') {
					sign = -1;
				}
				else if(ch == '(') {
					stack.push(ret);
					ret = 0;
					stack.push(sign);
					sign = 1;
				}
				else if(ch == ')') {
					ret = stack.pop()*ret + stack.pop();
				}
			}
		}
        return ret;
    	
    }
}