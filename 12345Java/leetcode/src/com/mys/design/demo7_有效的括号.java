package com.mys.design;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	有效字符串需满足：
	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
 *
 */
public class demo7_有效的括号 {

	public static void main(String[] args) {
		String str ="(";
		boolean valid = Solution7.isValid(str);
		System.out.println(valid);
	}

}
class Solution7 {
	/**
	 * 	如果碰到左括号，就入栈，
	 * 	碰到右括号，就拿出栈顶元素和当前右括号进行匹配，
	 * 		如果能匹配，循环继续
	 * 		如果不能，立即返回false
	 * @param s
	 * @return
	 */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	//取出当前正在遍历的字符
        	Character ch = s.charAt(i);
        	//如果是左括号，就入栈
			if(ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			}
			else {
				if (ch == '}' || ch == ']' || ch == ')'){
					//如果是右括号，如果当前栈不为空，取出栈顶元素
					if(stack.isEmpty())
						return false;
					else {
						Character ch1 = stack.pop();
						//判断是否匹配
						if((ch == '}' && ch1 !='{') || (ch == ']' && ch1 !='[') || (ch == ')' && ch1 !='('))
							return false;
					}
				}
			}
        }
        if(stack.isEmpty())
        	return true;
        return false;
    }
}