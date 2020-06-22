package com.mys.dy_program;

/**
 * 	给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *	你可以对一个单词进行如下三种操作：
 *		插入一个字符
 *		删除一个字符
 *		替换一个字符
 *	输入: word1 = "horse", word2 = "ros"
 *	输出: 3
 *	解释: 
 *		horse -> rorse (将 'h' 替换为 'r')
 *		rorse -> rose (删除 'r')
 *		rose -> ros (删除 'e')
 *
 */
public class demo94_字符串最小编辑距离 {

	public static void main(String[] args) {
		String s1 = "ros";
		String s2 = "horse";
		Solution94 solution = new Solution94();
		int ret = solution.minDistance(s1, s2);
		System.out.println(ret);
		
		int ret1 = solution.minDistance1(s1, s2);
		System.out.println(ret1);
		
		int ret2 = solution.minDistance1(s1, s2);
		System.out.println(ret2);
	}

}
class Solution94 {
	/**
	 * 	方法1：递归
	 * 	从两个字符串的头部开始逐一比较每一个位置的字符，当比较两个字符串第i个位置的字符时，有下面四种情况
	 * 		1、如果s1[i]==s2[i]，直接开始比较s1[i+1,len1]和s2[i+1,len2]
	 * 		2、把s1[i]删除，比较s1[i+1，len1]和s2[i,len2]
	 * 		3、把s1[i]替换为s2[i]，比较s1[i+1,len1]和s2[i+1,len2]
	 * 		4、把s2[i]插入到s1[i]的位置，比较s1[i,len1]和s2[i+1,len2]
	 */
    public int minDistance(String word1, String word2) {
    	if(word1 == null || word2 == null)
            return 0;
        return dfs(word1,word2,0,0);
    }

	private int dfs(String s1, String s2, int i, int j) {
		if(i == s1.length())
			return s2.length() - j;
		if(j == s2.length())
			return s1.length() - i;
		if(s1.charAt(i) == s2.charAt(j))
			return dfs(s1, s2, i+1, j+1);
		
		//删除s1的第一个字符，比较s1[i+1,len1-1]和s2[j,len2-1]
		int a = dfs(s1, s2, i+1, j) + 1;
		
		//在s1的开头前面插入s2[j]，比较s1[i,len1-1]和s2[j+1,len2-1]
		int b = dfs(s1, s2, i, j+1) + 1;
		
		//将s1[i]替换为s2[j],比较s1[i+1,len1-1]和s2[j+1,len2-1]
		int c = dfs(s1, s2, i+1, j+1) + 1;
		
		return Math.min(a, Math.min(b, c));
	}
	
	/**
	 * 	方法2：动态规划：二维矩阵
	 * 	用一个二维数组dp[i][j]保存s1的前i个字符，s2的前j个字符之间的最短编辑距离
	 * 	(s1[0],s2[0]) ==> dp[1][1],dp[0][0]=0，代表s1和s2都是空字符串时，编辑距离是0
	 * 	dp[i+1][j+1]表示从s1[i]到s2[j]的最短编辑距离
	 * 
	 * 	在计算dp[i+1][j+1]时，有四种可能情况
	 * 		1、如果s1[i]==s2[j]，那么得到dp[i+1][j+1]=dp[i][j]
	 * 		2、如果s1[i]！=s2[j]，有三种操作可以使得s1[i]==s2[j]
	 * 			1)、进行替换，将s1[i]替换为s2[j],则s1[i]==s2[j]，那么dp[i+1][j+1]就是
	 * 				从s1[i-1]到s2[j-1]的最短编辑距离，再加上1次替换操作，即dp[i+1][j+1]=1+dp[i][j]，
	 * 				dp[i][j]代表从s1[i-1]到s2[j-1]的最短编辑距离，
	 * 			2)、进行删除，将s1[i]删除，那么s1[i]将变成s1[i-1],那么dp[i+1][j+1]就是
	 * 				从s1[i-1]到s2[j]的最短编辑距离，再加上1次删除操作，即dp[i+1][j+1]=1+dp[i][j+1]
	 * 				dp[i][j+1]代表从s1[i-1]到s2[j]的最短编辑距离，
	 * 			3)、进行插入，在s1[i]的后面补一个s2[j]，那么s1[i]将变成s1[i+1]，此时s1[i+1]==s2[j]
	 * 				所以，dp[i+1][j+1]就是从s1[i]到s2[j-1]的最短编辑距离，再加上1次删除操作，即
	 * 				dp[i+1][j+1]=1+dp[i+1][j]，dp[i+1][j]表示从s1[i]到s2[j-1]的最短编辑距离
	 * 		
	 */
	public int minDistance1(String word1, String word2) {
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = j;
		}
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				int x = dp[i][j] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);		//替换操作
				int y = dp[i+1][j] + 1;													//插入操作
				int z = dp[i][j+1] + 1;													//删除操作
				
				//三次操作以后，最小值就是从s1[i]到s2[j]的最小编辑距离
				dp[i+1][j+1] = Math.min(x, Math.min(y, z));								
			}
		}
        return dp[word1.length()][word2.length()];
    }
	
	/**
	 * 	方法2：动态规划：一维矩阵
	 */
	public int minDistance2(String word1, String word2) {
		int[] dp = new int[word1.length()+1];
		//dp数组的初识状态，代表当word2位空字符串时，两个字符串之间的编辑距离
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}
		
		//dp数组初识状态是word2的长度为0时的编辑距离，此处外层循环表示每次让word2增加一个字符，求dp数组
		for (int j = 1; j < word2.length(); j++) {
			int temp1 = dp[0];
			dp[0]++;
			for (int i = 0; i < word1.length(); i++) {
				//temp2类似于二维数组里的dp[i][j]
				int temp2 = temp1;	
				
				//temp1类似于二维数组里的dp[i+1][j]，在新一轮更新dp[i+1]时，先记录上一轮的dp[i+1]，因为在计算dp[i+2]时还要用到
				temp1 = dp[i+1];
				
				if(word1.charAt(i) == word2.charAt(j))
					dp[i+1] = temp2;
				else {
					//dp[i]类似于二维数组里的dp[i][j+1]
					dp[i+1] = Math.min(dp[i], Math.min(temp1, temp2)) + 1;
				}
			}
		}
		return dp[word1.length()];
    }
}