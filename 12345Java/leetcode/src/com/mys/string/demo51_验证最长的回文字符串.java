package com.mys.string;

/**
 * 	给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 */
public class demo51_验证最长的回文字符串 {

	public static void main(String[] args) {
		String string = "babadcdeedc";
		String subStr1 = Solution51.longestPalindrome(string);
		System.out.println(subStr1);
		
		String subStr2 = Solution51.longestPalindrome1(string);
		System.out.println(subStr2);
		
		String subStr3 = Solution51.longestPalindrome2(string);
		System.out.println(subStr3);
	}

}
class Solution51 {
	
	/**
	 * 	解法3：中心扩散法
	 */
	public static String longestPalindrome2(String s) {
		if(s == null || s.length() == 0 || s.length() == 1)
			return s;
		int length = s.length();
		
		//用来记录遍历过程中回文串的起始和终止索引
		int start = 0;
		int end = 0;
		/**
		 * 	当i=(2n+1)×0.5时，low=n+1,high=n+2,那么此时回文串的中心是双数，就如同"ab"，，"ac"这样的中心
		 * 	当i=(2n)×0.5时，low = high = n，此时，回文串的中心是单个字符，就如同"a","b",,,,"c"这样的中心
		 * 	一旦确定了回文串的中心，那么就开始以中心位置往外扩展，并且不断更新新的回文串的起始和终止索引
		 */
		for (double i = 0.5; i < s.length(); i += 0.5) {
			int low = (int)Math.floor(i - 0.5);
			int high = (int)Math.ceil(i + 0.5);
			while(low >= 0 && high < length) {
				if (s.charAt(low) == s.charAt(high)) {
					if(high - low > end - start) {
						start = low;
						end = high;
					}
					low--;
					high++;
				}
				else
					break;
			}
		}
		return s.substring(start, end+1);
	}
	
	/**
	 * 	解法2：动态规划：二维数组
	 * 		用一个二维数组dp[][]表示字符串中两个索引之间是否是一个回文字符串,dp[i][j]表示s[i...j]是否是一个回文字符串
	 * 		dp的初始化：所有长度为1的子串都是回文字符串，即dp[i][i] =true;长度为2的子串需要判断，如果s[i]=s[i+1]，那么dp[i][i+1]=true
	 * 		dp的状态转移方程：dp[i][j] = (dp[i+1][j-1]) && (s[i]==s[j])
	 * 			如果dp[i+1][j-1]为true，说明s[i+1...j-1]是一个回文字符串，如果s[i]=s[j]，那么dp[i][j]=true
	 * 			否则dp[i][j]为false
	 */
	public static String longestPalindrome1(String s) {
		if(s.length() == 0 || s.length() == 1)
			return s;
		int length = s.length();
		int start = 0;
		int maxLen = 1;
		boolean[][] dp = new boolean[length][length];
		
		for (int i = 0; i < length; i++) {
			//长度为1的子串肯定是回文字符串
			dp[i][i] = true;
			
			//长度为2的子串，如果s[i]==s[i+1],那么它就是一个回文字符串
			if(i+1 < length && s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = true;
				maxLen = 2;
				start = i;
			}
		}
		
		//判断长度为len的子串是否是回文字符串，长度初始值为3
		for (int len = 3; len <= length; len++) {
			for (int i = 0; i <= length - len; i++) {
				int j = i + len -1;
				if(dp[i+1][j-1] == true && (s.charAt(i) == s.charAt(j))) {
					dp[i][j] = true;
					start = i;
					maxLen = len;
				}
			}
		}
		return s.substring(start, start+maxLen);
	}
	
	/**
	 * 	解法1：暴力解法
	 */
    public static String longestPalindrome(String s) {
    	//用两个变量分别记录最长的回文字符串的下标
    	int x = 0;
    	int y = 0;
    	int length = 0;
    	for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			for (int j = s.length()-1; j >= i; j--) {
				//从字符串最后面开始搜索，如果有碰到和ch相同的字符，就判断这个范围内的字符串是否是一个回文字符串
				if(s.charAt(j) == ch && isPalindrome(s, i, j)) {
					//如果是回文字符串，获取长度
					int newLength = j - i + 1;
					if(newLength > length) {
						//如果当前找到的长度比上一次的长，替换
						x = i;
						y = j;
						length = newLength;
					}
					//因为是从后往前搜索，如果已经找到了一个回文字符串，再就没有必要j--，即使有，只会更短
					break;
				}
			}
		}
    	return s.substring(x, y+1);
    }

	private static boolean isPalindrome(String s, int i, int j) {
		while(i <= j) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
    
    
}