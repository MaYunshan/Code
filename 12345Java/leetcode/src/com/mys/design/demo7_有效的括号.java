package com.mys.design;

import java.util.Stack;

/**
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
	��Ч�ַ��������㣺
	�����ű�������ͬ���͵������űպϡ�
	�����ű�������ȷ��˳��պϡ�
 *
 */
public class demo7_��Ч������ {

	public static void main(String[] args) {
		String str ="(";
		boolean valid = Solution7.isValid(str);
		System.out.println(valid);
	}

}
class Solution7 {
	/**
	 * 	������������ţ�����ջ��
	 * 	���������ţ����ó�ջ��Ԫ�غ͵�ǰ�����Ž���ƥ�䣬
	 * 		�����ƥ�䣬ѭ������
	 * 		������ܣ���������false
	 * @param s
	 * @return
	 */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
        	//ȡ����ǰ���ڱ������ַ�
        	Character ch = s.charAt(i);
        	//����������ţ�����ջ
			if(ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			}
			else {
				if (ch == '}' || ch == ']' || ch == ')'){
					//����������ţ������ǰջ��Ϊ�գ�ȡ��ջ��Ԫ��
					if(stack.isEmpty())
						return false;
					else {
						Character ch1 = stack.pop();
						//�ж��Ƿ�ƥ��
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