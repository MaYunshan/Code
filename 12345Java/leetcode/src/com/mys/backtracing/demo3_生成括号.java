package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 	���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
 * @author dell
 *
 */
public class demo3_�������� {

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
     *	 �ڽ�һ�����ŷ��뵱ǰջ����Ҫ������������
     * 		1.���������ŵĸ������ܳ���n��left<n
	 *		2.���Ҫ���������ţ���ô���뱣֤��ǰջ�У������ŵĸ���������������ŵĸ���,left>right
	 *
     * @param list:�������������ַ�������
     * @param sb������ģ���¼��ǰ���ڱ������ַ�����ջ
     * @param left�������ŵĸ���
     * @param right�������ŵĸ���
     * @param n�����Ŷ���
     */
	private static void bracket(List<String> list, StringBuilder sb, int left, int right, int n) {
		//�����ǰջ�ĳ��������Ŷ�����������˵���Ѿ��ҵ���һ����Ϸ�ʽ�����뼯��
		if(sb.length() == n*2) {
			list.add(sb.toString());
			return;
		}
		
		if(left < n) {
			//�����ŵĸ�������Ҫ���ڵ�ǰջ�з���һ��������
			sb.append('(');
			bracket(list, sb, left+1, right, n);
			//����������Ժ�Ҫ���ոշŵ������ų�ջ
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(right < left) {
			//�����Ź����ˣ��ڵ�ǰջ�з���һ��������
			sb.append(')');
			bracket(list, sb, left, right+1, n);
			//ͬ�������ո���ջ�������ų�ջ
			sb.deleteCharAt(sb.length()-1);
		}
		
	}
}