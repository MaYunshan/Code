package com.mys.backtracing;

/**
 * 	给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *		'.'匹配任意单个字符
 *		'*'匹配零个或多个前面的那一个元素
 *	所谓匹配，是要p涵盖整个字符串s的，而不是部分字符串。
 *
 */
public class demo91_正则表达式匹配 {

	public static void main(String[] args) {
		String s = "aa";
		String p = "a**";
		
		Solution91 solution91 = new Solution91();
		boolean match2 = solution91.isMatch2(s, p);
		System.out.println(match2);
		
		boolean match3 = solution91.isMatch3(s, p);
		System.out.println(match3);
	}

}
class Solution91 {
	/**
	 * 	动态规划：
	 */
	public boolean isMatch3(String s, String p) {
		boolean[][] dp = new boolean[p.length()+1][s.length()+1];
		dp[0][0] = true;
		
		//当p的长度为0时，只要s的长度不为0，那么它们都不是匹配的
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = false;
		}
		
		//从第2行开始计算
		for (int i = 0; i < p.length(); i++) {
			//在计算dp[i+1][0]时，s是空串，如果p[i]=='*'，那么它可以消除p[i-1]，这样就剩下p[0...i-2]和空串的匹配情况了
			int m = i - 1 < 0 ? 0 : i - 1;
			dp[i+1][0] =(p.charAt(i) == '*') &&  dp[m][0];
			
			//如果当前p[i]不是'*'号，正常比较即可
			if(p.charAt(i) != '*') {
				for (int j = 0; j < s.length(); j++) {
					if(p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)) {
						dp[i+1][j+1] = dp[i][j];
					}
				}
			}
			
			/**
			 * 	当p[i]为'*'号时，它代表0个，1个或者多个p[i-1]
			 * 		如果代表0个p[i-1]，相当于没有p[i-1]，那么就要检查p[i-2]和s[j]的匹配情况,即dp[i+1][j+1]=dp[i-1][j+1]
			 * 		如果代表1个或者多个p[i-1]，那么就要检查p[i-1]是什么样的字符
			 * 			如果p[i-1]是'.'号，那么不管s[j]是什么字符，s[j]都是可以被匹配的，所以只要p[0...i]和s[0...j-1]是匹配的
			 * 				那么p[0...i]和s[0...j]就是匹配的，即p[i+1][j+1]=p[i+1][j]
			 * 			如果p[i-1]是字母@(@代表一个小写字母)，那么p[i]也是字母@，如果s[j]也是@，也就是p[i-1]=s[j],说明s[j]是
			 * 				可以被匹配到的，所以，只要p[0...i]和s[0...j-1]是匹配的，那么p[0...i]和s[0...j]就是匹配的，即p[i+1][j+1]=p[i+1][j]
			 * 		
			 */
			else {
				for (int j = 0; j < s.length(); j++) {
					int k = i - 1 < 0 ? 0 : i - 1;		//获取p[i-1]，如果i=0，那么p[i-1]=p[0]
					
					//匹配0个p[i-1]，相当于把p[i]和p[i-1]都不要，开始匹配p[0...i-2]和s[0...j]
					dp[i+1][j+1] = dp[k][j+1];
					
					/**
					 * 	当匹配1个或者多个'*'号时，
					 * 		如果'*'号前面是'.'号，并且如果有j使得dp[".*"][j] = true,那么所有的dp[".*"][m>j]=true
					 * 		如果'*'号前面是字符@， 并且如果有j使得dp["@*"][j] = true而且满足s[j+1]=s[j],则dp["@*"][j+1]=true
					 */
					if(p.charAt(k) == '.' || p.charAt(k) == s.charAt(j)) {
						dp[i+1][j+1] = dp[i+1][j+1] || dp[i+1][j];
					}
				}
			}
			
		}
		return dp[p.length()][s.length()];
    }
	
	public boolean isMatch2(String s, String p) {
		boolean[][] dp = new boolean[p.length()+1][s.length()+1];
		dp[0][0] = true;
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = false;
		}
		
		for (int i = 0; i < p.length(); i++) {
			//在计算dp[i+1][0]时，s一直是空串，如果p[i]=='*'，那么它可以消除p[i-1]，这样就剩下p[0...i-2]和空串的匹配情况了
			dp[i+1][0] =(p.charAt(i) == '*') &&  dp[i - 1 < 0 ? 0 : i - 1][0];
			for (int j = 0; j < s.length(); j++) {
				if(p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)) {
					dp[i+1][j+1] = dp[i][j];
				}
				
				/**
				 * 	当p[i]为'*'号时，它代表0个，1个或者p[i-1]
				 * 		如果代表0个p[i-1]，相当于没有p[i-1]，那么就要检查p[i-2]和s[j]的匹配情况,即dp[i+1][j+1]=dp[i-1][j+1]
				 * 		如果代表1个p[i-1]，那么相当于p[i]是一个空字符，那么p[0...i]变成了p[0...i-1]，即dp[i+1][j+1]=dp[i][j+1]
				 * 		如果代表2个以上的p[i-1]，那么相当于p[i]=p[i-1],此时dp[i+1][j+1]=dp[i+1][j] && s[i-1]==s[j]
				 * 		如果代表3个以上的p[i-1],
				 */
				else if(p.charAt(i) == '*') {
					int k = i - 1 < 0 ? 0 : i - 1;
					int m = j - 1 < 0 ? 0 : j - 1; 
					dp[i+1][j+1] = dp[k][j+1];
					if(p.charAt(k) == '.' || p.charAt(k) == s.charAt(j)) {
						dp[i+1][j+1] = dp[i+1][j+1] || dp[i+1][j];
					}
				}
			}
		}
		return dp[p.length()][s.length()];
    }
	
	
    public boolean isMatch(String s, String p) {
    	return dfs(s,p,0,0);
    }

	private boolean dfs(String s, String p, int i, int j) {
		
		if(s.charAt(i) == p.charAt(j))
			return dfs(s, p, i+1, j+1);
		if(p.charAt(i) == '*') {
			
		}
		return false;
	}
}