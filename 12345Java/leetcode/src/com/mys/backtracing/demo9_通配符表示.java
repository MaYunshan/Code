package com.mys.backtracing;

import java.util.Arrays;

/**
 * 	给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *		'?' 可以匹配任何单个字符。
 *		'*' 可以匹配任意字符串（包括空字符串）。
 *	两个字符串完全匹配才算匹配成功。
 *	说明:
 *		s 可能为空，且只包含从 a-z 的小写字母。
 *		p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 */
public class demo9_通配符表示 {

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
        
        //开始计算第二行
        for (int i = 0; i < p.length(); i++) {
        	/**
        	 * 	计算dp[i+1][0]，也就是第0列，此时s的长度为0，如果p[i]不是'*'号，那么p[0...i]是不可能和空串相匹配的，
        	 * 	只有当p[i]='*'，并且dp[i][0] = true，dp[i+1][0]才能为true，否则为false
        	 */
			dp[i+1][0] =(p.charAt(i) == '*') && dp[i][0];
			
			/**
			 * 	如果p[i]=='*'号，即匹配过程为p[0...i-1,*]和s[0...j-1,j]，因为'*'号可以匹配0个或者多个字符，那么分情况讨论
			 * 		如果p[i]匹配s中的0个字符，即不要这个*号，匹配变为p[0...i-1]和s[0...j-1,j],则dp[i+1][j+1]=dp[i][j+1]
			 * 		因为'*'号可以匹配任意字符，所以从'*'号里面拆分处一个s[i]，放在'*'号后面，这样相当于p[i]后面多了一个p[i+1]，
			 * 			并且p[i+1]=s[j]，此时，匹配就变成了p[0...i]和s[0...j-1]之间的匹配，即dp[i+1][j+1]=dp[i+1][j]
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
	 * 	动态规划：用一个二维数组dp[pLen+1][sLen+1]表示s和p是否匹配
	 * 		dp[0][0]=true，代表s和p的长度为0时，它们是相互匹配的
	 * 		dp[0][i]=false(i>0),代表当p的长度为0时，只要s的长度不为0，它们都是不匹配的
	 * 		dp[j][0]的值根据p决定，如果p的前j个字符全都是'*'号，则为true
	 * 		dp[i+1][j+1]代表p中的前i个字符和s中的前j个字符是否匹配
	 * 	dp[i+1][j+1]的计算过程：
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
        
        //开始计算第二行
        for (int i = 0; i < p.length(); i++) {
        	/**
        	 * 	计算dp[i+1][0]，也就是第0列，此时s的长度为0，如果p[i]不是'*'号，那么p[0...i]是不可能和空串相匹配的，
        	 * 	只有当p[i]='*'，并且dp[i][0] = true，dp[i+1][0]才能为true，否则为false
        	 */
			dp[i+1][0] =p.charAt(i) == '*'  && dp[i][0];
			for (int j = 0; j < s.length(); j++) {
				/**
				 * 	如果p[i]=='*'号，即匹配过程为p[0...i-1,*]和s[0...j-1,j]，因为'*'号可以匹配0个或者多个字符，那么分情况讨论
				 * 		如果p[i]匹配s中的0个字符，即不要这个*号，匹配变为p[0...i-1]和s[0...j-1,j],则dp[i+1][j+1]=dp[i][j+1]
				 * 		如果p[i]匹配s中的多个字符，那么就是，p[i]和s[j-1]先匹配，然后i不动，j往后移动一位，即dp[i+1][j+1]=dp[i+1][j]
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
	 * 	递归法：
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
			//有连续多个'*'号，都忽略，跟一个'*'号的作用是一样的
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