package com.mys.backtracing;

/**
 * 	ɾ����Ч������
 * 		ɾ����С��������Ч���ţ�ʹ��������ַ�����Ч���������п��ܵĽ����
 *		˵��: ������ܰ����˳�(��)������ַ���
 *		ʾ�� 1:
 *			����: "()())()"
 *			���: ["()()()", "(())()"]
 *		ʾ�� 2:
 *			����: "(a)())()"
 *			���: ["(a)()()", "(a())()"]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class demo8_ɾ����Ч������ {

	public static void main(String[] args) {
		String str = "(()";
		Solution8 solution8 = new Solution8();
		int[] mis = solution8.misParenthesis(str);
		System.out.println(Arrays.toString(mis));
		
		List<String> list = solution8.removeInvalidParentheses(str);
		System.out.println(list);
	}

}

class Solution8 {
	/**
	 * 	�ַ������������Ÿ���m��n�������Ϸ����������Ÿ���left��right��
	 * 	���õݹ鷨ɾ�����Ϸ�������ʱ����ʵ������m����������ѡ��left�����ҽ���ɾ������n����������ѡ��right�����ҽ���ɾ��
	 * 	Ȼ���жϵ����Ϸ����������ŵ���������ɾ��ʱ��ʣ�µ��ַ����Ƿ���һ���Ϸ����ַ�����
	 * 	
	 */
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<String>();
        //��ȡs�в��Ϸ����������ŵĸ��Ե�����
        int[] mis = misParenthesis(s);
        dfs(s,list,0,mis[0],mis[1]);
        
        return list;
    }
    
    /**
     * 	����s��ÿһ���ַ������ɾ�����Ϸ������ţ�ֱ�����Ϸ������ŵĸ���Ϊ0����ʱ����ַ����е������Ƿ�Ϸ�������Ϸ����䱣��
     * @param s��		Դ�ַ���
     * @param list��		��������ɾ�������������ź���Ȼ�Ϸ����ַ���
     * @param index��	��ǰ�ݹ��s����ʼλ��
     * @param left��		���Ϸ������ŵ���Ŀ
     * @param right��	���Ϸ������ŵ���Ŀ
     */
    private void dfs(String s, List<String> list, int index, int left, int right) {
    	if(left == 0 && right == 0) {
    		//����Ѿ�ɾ���˲��Ϸ�������������Ŀ�������µ��ַ��������жϣ�����Ϸ����䱣��
    		int[] mis = misParenthesis(s);
    		if(mis[0] == 0 && mis[1] == 0) {
    			list.add(s);
    			System.out.println(123);
    			return ;
    		}
    	}
    	
    	for (int i = index; i < s.length(); i++) {
    		//ȥ�أ������ظ�������ǰ�������ַ�����ǰһ���ַ�һ������ô�ͺ�������ַ�
    		if(i - 1 >= index && s.charAt(i-1) == s.charAt(i))
    			continue;
    		
    		//�����ǰλ����һ�������Ų��Ҳ��Ϸ�����������Ŀ��Ȼ����0���ͽ����������ɾ��
    		if(left > 0 && s.charAt(i) == '(') {
    			System.out.println(s.substring(0, i)+s.substring(i+1)+"abc");
    			dfs(s.substring(0, i)+s.substring(i+1), list, i, left-1, right);
    		}
    		
    		//�����ǰλ����һ�������Ų��Ҳ��Ϸ�����������Ŀ��Ȼ����0���ͽ����������ɾ��
    		if(right > 0 && s.charAt(i) == ')') {
    			System.out.println(s.substring(0, i)+s.substring(i+1)+"cde");
    			dfs(s.substring(0, i)+s.substring(i+1), list, i, left, right-1);
    		}
		}
	}

	/**
     * 	�ж�ĳ���ַ����в��Ϸ��������ź������ŵĸ���
     */
    int[] misParenthesis(String str) {
    	//������¼ջ���ж��ٸ�������
    	int left = 0;
    	int right = 0;
    	for (int i = 0; i < str.length(); i++) {
    		//����������ţ�left++����ʾ��ǰջ�ж���һ��������
			if(str.charAt(i) == '(')
				left++;
			
			/**
			 * 	����������ţ����жϵ�ǰջ���Ƿ����������Ƿ����ƥ�䣬
			 * 		���left<=0,˵����ǰջ��û�������ţ�˵��str�е������ǲ��Ϸ���
			 * 		���left>0��˵����ǰջ�л��������ţ��������ȥһ�����ţ�ջ�е������ż���һ������left--
			 */
			else if(str.charAt(i) == ')') {
				if(left <= 0)
					right++;
				else
					left--;
			}
		}
    	return new int[] {left,right};
    }
}
