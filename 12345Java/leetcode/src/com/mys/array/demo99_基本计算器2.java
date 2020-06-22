package com.mys.array;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 	ʵ��һ�������ļ�����������һ���򵥵��ַ������ʽ��ֵ��
 *	�ַ������ʽ�������Ǹ�������+�� - ��*��/ ����������Ϳո�  �� ���������������������֡�
 *
 */
public class demo99_����������2 {

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
	 * 	�ⷨ2
	 * @param s
	 * @return
	 */
	public static int calculate1(String s) {
    	int ret = 0;
    	int num = 0;
    	String ch = "+";		//��Ϊ��һ���������������ԣ�ch�ĳ�ʼֵĬ��Ϊ"+",
    	
    	//������������ͼ����Ĳ�����ջ
    	Stack<Integer> stack = new Stack<Integer>();
    	//ƥ���������ֺ�������ŵ�����
        Pattern pattern = Pattern.compile("\\d+|[+\\*-/]");
        s = s.replaceAll(" ", "");
        Matcher m = pattern.matcher(s.replaceAll(" ", ""));
        
        while(m.find()) {
        	String temp = m.group();
        	//����������֣��Ƚ����¼
        	if(temp.matches("\\d+")) {
        		num = Integer.parseInt(temp.trim());
        	}
        	
        	//�����������������ţ����������е���Ч�����Ѿ���ƥ���꣬��Ҫ�����һ��������ջ
        	if(temp.matches("[+\\-*/]") || m.end() == s.length()) {
        		if(ch.equals("+")) {			//�����һ��������"+"���򽫼�¼��num����ջ��
        			stack.push(num);
        		}
        		else if(ch.equals("-")){		//�����һ��������"-"�����¼num���෴ֵ
        			stack.push(-num);
        		}
        		else {							
        			//�����һ��������"*"��"/"����ջ����Ϊ��һ������������num��Ϊ�ڶ������������������㣬���ҽ�������浽ջ��
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
	 * 	�ⷨ1
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