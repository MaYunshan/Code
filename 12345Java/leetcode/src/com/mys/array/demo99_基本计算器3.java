package com.mys.array;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class demo99_基本计算器3 {

	public static void main(String[] args) throws Exception {
		String str = "-3.5*(4.5-(4+(-1-1/2+3)))";
		double res = Solution993.calculate(str);
		System.out.println(res);
	}

}
class Solution993 {
	/**
	 * 	根据中缀表达式计算结果
	 * 	思路：
	 * 		一个操作数栈用来保存所有出现的操作数
	 * 		当碰到操作数的时候，将其入栈，
	 * 		当碰到运算符号的时候，取出栈中的两个元素，跟当前的符号进行运算，将所得结果压入栈
	 * 		当所有的符号都遍历结束以后，最后栈内的唯一元素就是表达式的结果
	 * @throws Exception 
	 */
	public static double calculate(String s) throws Exception {
		
		String string = getPostExpression(s);
		System.out.println(string);
		
		Stack<Double> nums = new Stack<Double>();
		
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?|[+\\-*/]");
		Matcher matcher = pattern.matcher(string);
		
		while(matcher.find()) {
			String temp = matcher.group();
			if(temp.matches("[+\\-*/]")) {
				double b = nums.pop();
				double a = nums.pop();
				//a和b的顺序非常重要，后出栈的数是第一个操作数
				double res = calculateResult(a, b, temp.charAt(0));
				nums.push(res);
			}
			else {
				nums.push(Double.valueOf(temp));
			}
		}
		return nums.pop();
	}
	
	/**
	 * 	中缀表达式：a+b*c-(d+e)
	 * 		按照运算符的优先级对所有的运算单位加括号：变换为：((a+(b*c))-(d+e))
	 * 	前缀表达式：把运算符号移动到对应的括号前面：得到：-( +(a *(bc)) +(de)) ==》- + a * b c + d e
	 * 	后缀表达式：把运算符号移动到对应的括号后面：得到：((a(bc)* )+ (de)+ )-  ==》a b c * + d e + - 
	 * 	
	 * 	将中缀表达式转换为后缀表达式
	 * 	思路：
	 * 		从左往右遍历中缀表达式
	 * 		利用一个buffer字符串存储中缀表达式，利用一个栈来存储符号，符号栈中的顺序代表的是计算过程中的优先级
	 * 	过程：
	 * 		1、如果碰到的是符号
	 * 			1),如果碰到的是"("，直接加入到符号栈中
	 * 			2),如果碰到的是")",从栈中不断取出符号并且加入到中缀表达式中，直到碰到"("为止
	 * 			3),如果碰到的是"[+-/*]",判断当前符号和栈顶符号的优先级
	 * 				如果当前符号的优先级高于栈顶符号的优先级，将当前符号加入栈中
	 * 				如果当前符号的优先级小于或者等于栈顶符号的优先级，从栈中取出符号加入到中缀表达式中，直到当前符号的优先级高于栈顶符号
	 * 		2、如果碰到数字，直接将数字加入到中缀字符串中
	 */
    public static String getPostExpression(String s) throws Exception{
    	//符号栈
        Stack<String> operator = new Stack<String>();
        
        //存储中缀表达式
        StringBuffer sbuf = new StringBuffer();
        
        Pattern p = Pattern.compile("(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]");// 这个正则为匹配表达式中的数字或运算符
        Matcher m = p.matcher(s);
        
        while(m.find()) {
        	String temp = m.group();
        	//如果当前匹配到符号
        	if(temp.matches("[+\\-*/()]")) {
        		//碰到左括号，直接入符号栈
        		if(temp.equals("(")) {
        			operator.push(temp);
        		}
        		//碰到右括号，开始从符号栈中拿出符号并且添加到中缀字符串中，直到遇到左括号为止，左括号只弹出不加入
        		else if (temp.equals(")")) {
					String topOper = "";
					while(topOper.equals("(") == false) {
						sbuf.append(topOper+" ");
						topOper = operator.pop();
					}
				}
        		//如果是运算符号，判断当前符号和符号栈栈顶的符号的优先级，如果当前符号大于栈顶的优先级，直接压入栈
        		//否则，将符号栈中的符号拿出添加到中缀字符串中，只到当前符号的优先级大于栈顶符号的优先级
        		else {
					while(!operator.isEmpty() && getPriority(temp) <= getPriority(operator.peek())) {
						sbuf.append(operator.pop()+" ");
					}
					operator.push(temp);
				}
        	}
        	//如果是数字，直接添加到中缀字符串中
        	else {
        		sbuf.append(temp+" ");
			}
        }
        
        //表达式遍历完成，将符号栈中剩余符号加入到中缀字符串中
        while(!operator.isEmpty()) {
        	sbuf.append(operator.pop());
        }
        return sbuf.toString();
    }
    
    private static double calculateResult(double a1, double a2, char operator) throws Exception{
        switch (operator) {
	        case '+':
	            return a1 + a2;
	        case '-':
	            return a1 - a2;
	        case '*':
	            return a1 * a2;
	        case '/':
	            return a1 / a2;
	        default:
	            break;
        }
        throw new Exception("illegal operator!");
    }
    
    
    private static int getPriority(String s) throws Exception{
        if(s==null) return 0;
        switch(s) {
	        case "(": return 1;
	        case "+": ;
	        case "-": return 2;
	        case "*": ;
	        case "/": return 3;
	        default:break;
        }
        throw new Exception("illegal operator!");
    }

}