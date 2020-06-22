package com.mys.array;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class demo99_����������3 {

	public static void main(String[] args) throws Exception {
		String str = "-3.5*(4.5-(4+(-1-1/2+3)))";
		double res = Solution993.calculate(str);
		System.out.println(res);
	}

}
class Solution993 {
	/**
	 * 	������׺���ʽ������
	 * 	˼·��
	 * 		һ��������ջ�����������г��ֵĲ�����
	 * 		��������������ʱ�򣬽�����ջ��
	 * 		������������ŵ�ʱ��ȡ��ջ�е�����Ԫ�أ�����ǰ�ķ��Ž������㣬�����ý��ѹ��ջ
	 * 		�����еķ��Ŷ����������Ժ����ջ�ڵ�ΨһԪ�ؾ��Ǳ��ʽ�Ľ��
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
				//a��b��˳��ǳ���Ҫ�����ջ�����ǵ�һ��������
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
	 * 	��׺���ʽ��a+b*c-(d+e)
	 * 		��������������ȼ������е����㵥λ�����ţ��任Ϊ��((a+(b*c))-(d+e))
	 * 	ǰ׺���ʽ������������ƶ�����Ӧ������ǰ�棺�õ���-( +(a *(bc)) +(de)) ==��- + a * b c + d e
	 * 	��׺���ʽ������������ƶ�����Ӧ�����ź��棺�õ���((a(bc)* )+ (de)+ )-  ==��a b c * + d e + - 
	 * 	
	 * 	����׺���ʽת��Ϊ��׺���ʽ
	 * 	˼·��
	 * 		�������ұ�����׺���ʽ
	 * 		����һ��buffer�ַ����洢��׺���ʽ������һ��ջ���洢���ţ�����ջ�е�˳�������Ǽ�������е����ȼ�
	 * 	���̣�
	 * 		1������������Ƿ���
	 * 			1),�����������"("��ֱ�Ӽ��뵽����ջ��
	 * 			2),�����������")",��ջ�в���ȡ�����Ų��Ҽ��뵽��׺���ʽ�У�ֱ������"("Ϊֹ
	 * 			3),�����������"[+-/*]",�жϵ�ǰ���ź�ջ�����ŵ����ȼ�
	 * 				�����ǰ���ŵ����ȼ�����ջ�����ŵ����ȼ�������ǰ���ż���ջ��
	 * 				�����ǰ���ŵ����ȼ�С�ڻ��ߵ���ջ�����ŵ����ȼ�����ջ��ȡ�����ż��뵽��׺���ʽ�У�ֱ����ǰ���ŵ����ȼ�����ջ������
	 * 		2������������֣�ֱ�ӽ����ּ��뵽��׺�ַ�����
	 */
    public static String getPostExpression(String s) throws Exception{
    	//����ջ
        Stack<String> operator = new Stack<String>();
        
        //�洢��׺���ʽ
        StringBuffer sbuf = new StringBuffer();
        
        Pattern p = Pattern.compile("(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]");// �������Ϊƥ����ʽ�е����ֻ������
        Matcher m = p.matcher(s);
        
        while(m.find()) {
        	String temp = m.group();
        	//�����ǰƥ�䵽����
        	if(temp.matches("[+\\-*/()]")) {
        		//���������ţ�ֱ�������ջ
        		if(temp.equals("(")) {
        			operator.push(temp);
        		}
        		//���������ţ���ʼ�ӷ���ջ���ó����Ų�����ӵ���׺�ַ����У�ֱ������������Ϊֹ��������ֻ����������
        		else if (temp.equals(")")) {
					String topOper = "";
					while(topOper.equals("(") == false) {
						sbuf.append(topOper+" ");
						topOper = operator.pop();
					}
				}
        		//�����������ţ��жϵ�ǰ���źͷ���ջջ���ķ��ŵ����ȼ��������ǰ���Ŵ���ջ�������ȼ���ֱ��ѹ��ջ
        		//���򣬽�����ջ�еķ����ó���ӵ���׺�ַ����У�ֻ����ǰ���ŵ����ȼ�����ջ�����ŵ����ȼ�
        		else {
					while(!operator.isEmpty() && getPriority(temp) <= getPriority(operator.peek())) {
						sbuf.append(operator.pop()+" ");
					}
					operator.push(temp);
				}
        	}
        	//��������֣�ֱ����ӵ���׺�ַ�����
        	else {
        		sbuf.append(temp+" ");
			}
        }
        
        //���ʽ������ɣ�������ջ��ʣ����ż��뵽��׺�ַ�����
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