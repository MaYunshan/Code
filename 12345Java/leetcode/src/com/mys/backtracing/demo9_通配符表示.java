package com.mys.backtracing;

import java.util.Arrays;

/**
 * 	����һ���ַ��� (s) ��һ���ַ�ģʽ (p) ��ʵ��һ��֧�� '?' �� '*' ��ͨ���ƥ�䡣
 *		'?' ����ƥ���κε����ַ���
 *		'*' ����ƥ�������ַ������������ַ�������
 *	�����ַ�����ȫƥ�����ƥ��ɹ���
 *	˵��:
 *		s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
 *		p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� ? �� *��
 *
 */
public class demo9_ͨ�����ʾ {

	public static void main(String[] args) {
		String s = "abbbba";
		String p = "a****";
		
		Solution9 solution9 = new Solution9();
		boolean match = solution9.isMatch(s, p);
		System.out.println(match);
		
		boolean match2 = solution9.isMatch2(s, p);
		System.out.println(match2);
	}

}
class Solution9 {
	
	public boolean isMatch3(String s, String p) {
        if(s == null || p == null)
        	return false;
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
       
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = false;
		}
        
        //��ʼ����ڶ���
        for (int i = 0; i < p.length(); i++) {
        	/**
        	 * 	����dp[i+1][0]��Ҳ���ǵ�0�У���ʱs�ĳ���Ϊ0�����p[i]����'*'�ţ���ôp[0...i]�ǲ����ܺͿմ���ƥ��ģ�
        	 * 	ֻ�е�p[i]='*'������dp[i][0] = true��dp[i+1][0]����Ϊtrue������Ϊfalse
        	 */
			dp[i+1][0] =(p.charAt(i) == '*') && dp[i][0];
			
			/**
			 * 	���p[i]=='*'�ţ���ƥ�����Ϊp[0...i-1,*]��s[0...j-1,j]����Ϊ'*'�ſ���ƥ��0�����߶���ַ�����ô���������
			 * 		���p[i]ƥ��s�е�0���ַ�������Ҫ���*�ţ�ƥ���Ϊp[0...i-1]��s[0...j-1,j],��dp[i+1][j+1]=dp[i][j+1]
			 * 		��Ϊ'*'�ſ���ƥ�������ַ������Դ�'*'�������ִ�һ��s[i]������'*'�ź��棬�����൱��p[i]�������һ��p[i+1]��
			 * 			����p[i+1]=s[j]����ʱ��ƥ��ͱ����p[0...i]��s[0...j-1]֮���ƥ�䣬��dp[i+1][j+1]=dp[i+1][j]
			 */
			if(p.charAt(i) == '*') {
				for (int j = 0; j < s.length(); j++) {
					dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
				}
			}
			else {
				for (int j = 0; j < s.length(); j++) {
					if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j))
						dp[i+1][j+1] = dp[i][j];
				}
			}
		}
        return dp[p.length()][s.length()];
    }
	
	/**
	 * 	��̬�滮����һ����ά����dp[pLen+1][sLen+1]��ʾs��p�Ƿ�ƥ��
	 * 		dp[0][0]=true������s��p�ĳ���Ϊ0ʱ���������໥ƥ���
	 * 		dp[0][i]=false(i>0),����p�ĳ���Ϊ0ʱ��ֻҪs�ĳ��Ȳ�Ϊ0�����Ƕ��ǲ�ƥ���
	 * 		dp[j][0]��ֵ����p���������p��ǰj���ַ�ȫ����'*'�ţ���Ϊtrue
	 * 		dp[i+1][j+1]����p�е�ǰi���ַ���s�е�ǰj���ַ��Ƿ�ƥ��
	 * 	dp[i+1][j+1]�ļ�����̣�
	 * 		
	 */
	public boolean isMatch2(String s, String p) {
        if(s == null || p == null)
        	return false;
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
       
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = false;
		}
        
        //��ʼ����ڶ���
        for (int i = 0; i < p.length(); i++) {
        	/**
        	 * 	����dp[i+1][0]��Ҳ���ǵ�0�У���ʱs�ĳ���Ϊ0�����p[i]����'*'�ţ���ôp[0...i]�ǲ����ܺͿմ���ƥ��ģ�
        	 * 	ֻ�е�p[i]='*'������dp[i][0] = true��dp[i+1][0]����Ϊtrue������Ϊfalse
        	 */
			dp[i+1][0] =p.charAt(i) == '*'  && dp[i][0];
			for (int j = 0; j < s.length(); j++) {
				/**
				 * 	���p[i]=='*'�ţ���ƥ�����Ϊp[0...i-1,*]��s[0...j-1,j]����Ϊ'*'�ſ���ƥ��0�����߶���ַ�����ô���������
				 * 		���p[i]ƥ��s�е�0���ַ�������Ҫ���*�ţ�ƥ���Ϊp[0...i-1]��s[0...j-1,j],��dp[i+1][j+1]=dp[i][j+1]
				 * 		���p[i]ƥ��s�еĶ���ַ�����ô���ǣ�p[i]��s[j-1]��ƥ�䣬Ȼ��i������j�����ƶ�һλ����dp[i+1][j+1]=dp[i+1][j]
				 */
				if(p.charAt(i) == '*') {
					dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
				}
				else if(p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) {
					dp[i+1][j+1] = dp[i][j];
				}
				else {
					dp[i+1][j+1] = false;
				}
			}
		}
        return dp[p.length()][s.length()];
    }
	
	
	/**
	 * 	�ݹ鷨��
	 */
    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
        	return false;
        return dfs(s,p,0,0);
    }

	private boolean dfs(String s, String p, int i, int j) {
		if(i == s.length()) {
			while(j < p.length() && p.charAt(j) == '*') {
				j++;
			}
			if(j == p.length())
				return true;
			else 
				return false;
		}
		
		if(j == p.length())
			return false;
		
		if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
			return dfs(s, p, i+1, j+1);
		
		if(p.charAt(j) == '*') {
			//���������'*'�ţ������ԣ���һ��'*'�ŵ�������һ����
			while(j+1 < p.length() && p.charAt(j+1) == p.charAt(j))
				j++;
			
			if(j+1 == p.length())
				return true;
			
			while(i < s.length()) {
				if(s.charAt(i) == p.charAt(j+1) || p.charAt(j+1) == '?')
					 if(dfs(s, p, i+1, j+2))
						 return true;
				i++;
			}
			return false;
		}
		
		return false;
	}
}