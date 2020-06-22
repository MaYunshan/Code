package com.mys.array;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 	�ַ������ʽ���԰��������� ( �������� )���Ӻ� + ������ -���Ǹ������Ϳո�  
 * @author dell
 *
 */

public class demo99_����������11 {

	public static void main(String[] args) {
			String str = "(2-4-6)";
			int ret = Solution9911.calculate(str);
			System.out.println(ret);
		}

	}
class Solution9911 {
    public static int calculate(String s) {
        int ret = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        Pattern pa = Pattern.compile("\\d+|[\\-+()]");
        Matcher ma = pa.matcher(s);
        while(ma.find()) {
        	String temp = ma.group();
        	if (temp.matches("\\d+")) {
				num = Integer.valueOf(temp);
				ret = ret + num*sign;
				num = 0;
			}
        	else {
				//ret = ret + num*sign;
				//num = 0;
				if ("+".equals(temp)) {
					sign = 1;
				}
				else if ("-".equals(temp)) {
					sign = -1;
				}
				else if ("(".equals(temp)) {
					stack.push(ret);
					stack.push(sign);
					ret = 0;
					sign = 1;
				}
				else {
					ret = stack.pop() * ret + stack.pop();
				}
			}
				
        	System.out.println(temp);
        }
        return ret;
    	
    }
}
