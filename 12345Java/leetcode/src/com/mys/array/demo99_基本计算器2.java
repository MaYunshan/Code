package com.mys.array;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 	实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *	字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 */
public class demo99_基本计算器2 {

	public static void main(String[] args) {
		String str = "3  / 2 ";
		int ret = Solution992.calculate(str);
		System.out.println(ret);
		
		int ret1 = Solution992.calculate1(str);
		System.out.println(ret1);
	}

}
class Solution992 {
	/**
	 * 	解法2
	 * @param s
	 * @return
	 */
	public static int calculate1(String s) {
    	int ret = 0;
    	int num = 0;
    	String ch = "+";		//因为第一个数是正数，所以，ch的初始值默认为"+",
    	
    	//用来保存加数和减数的操作数栈
    	Stack<Integer> stack = new Stack<Integer>();
    	//匹配所有数字和运算符号的正则
        Pattern pattern = Pattern.compile("\\d+|[+\\*-/]");
        s = s.replaceAll(" ", "");
        Matcher m = pattern.matcher(s.replaceAll(" ", ""));
        
        while(m.find()) {
        	String temp = m.group();
        	//如果碰到数字，先将其记录
        	if(temp.matches("\\d+")) {
        		num = Integer.parseInt(temp.trim());
        	}
        	
        	//如果碰到的是运算符号，或者是所有的有效符号已经被匹配完，需要将最后一个数字入栈
        	if(temp.matches("[+\\-*/]") || m.end() == s.length()) {
        		if(ch.equals("+")) {			//如果上一个符号是"+"，则将记录的num加入栈中
        			stack.push(num);
        		}
        		else if(ch.equals("-")){		//如果上一个符号是"-"，则记录num的相反值
        			stack.push(-num);
        		}
        		else {							
        			//如果上一个符号是"*"或"/"，以栈顶作为第一个操作数，以num作为第二个操作数，进行运算，并且将结果保存到栈中
        			num = ch.equals("*") ? stack.pop()* num : stack.pop()/num; 
        			stack.push(num);
				}
        		ch = temp;
        		num = 0;
        	}
        }
        
        while(!stack.isEmpty()) {
        	ret += stack.pop();
        }
    	return ret;
    }
	
	/**
	 * 	解法1
	 * @param s
	 * @return
	 */
    public static int calculate(String s) {
    	int ret = 0;
    	int num = 0;
    	char ch = '+';
    	Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				num = num*10 - '0' + s.charAt(i);
			}
			if(s.charAt(i)< '0' && s.charAt(i) != ' ' || i == s.length()-1) {
				if(ch == '+') {
					stack.push(num);
				}
				else if(ch == '-') {
					stack.push(-num);
				}
				else if(ch == '*' || ch == '/'){
					num = ch == '*' ? stack.pop()* num : stack.pop()/num;
					stack.push(num);
				}
				ch = s.charAt(i);
				num = 0;
			}
		}
        while(!stack.isEmpty()) {
        	ret += stack.pop();
        }
    	return ret;
    }
}