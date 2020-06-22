package com.mys.backtracing;

/**
 * 	����һ���ַ���s��һ���ַ�����p��������ʵ��һ��֧�� '.'��'*'��������ʽƥ�䡣
 *		'.'ƥ�����ⵥ���ַ�
 *		'*'ƥ���������ǰ�����һ��Ԫ��
 *	��νƥ�䣬��Ҫp���������ַ���s�ģ������ǲ����ַ�����
 *
 */
public class demo91_������ʽƥ�� {

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
	 * 	��̬�滮��
	 */
	public boolean isMatch3(String s, String p) {
		boolean[][] dp = new boolean[p.length()+1][s.length()+1];
		dp[0][0] = true;
		
		//��p�ĳ���Ϊ0ʱ��ֻҪs�ĳ��Ȳ�Ϊ0����ô���Ƕ�����ƥ���
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = false;
		}
		
		//�ӵ�2�п�ʼ����
		for (int i = 0; i < p.length(); i++) {
			//�ڼ���dp[i+1][0]ʱ��s�ǿմ������p[i]=='*'����ô����������p[i-1]��������ʣ��p[0...i-2]�Ϳմ���ƥ�������
			int m = i - 1 < 0 ? 0 : i - 1;
			dp[i+1][0] =(p.charAt(i) == '*') &&  dp[m][0];
			
			//�����ǰp[i]����'*'�ţ������Ƚϼ���
			if(p.charAt(i) != '*') {
				for (int j = 0; j < s.length(); j++) {
					if(p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)) {
						dp[i+1][j+1] = dp[i][j];
					}
				}
			}
			
			/**
			 * 	��p[i]Ϊ'*'��ʱ��������0����1�����߶��p[i-1]
			 * 		�������0��p[i-1]���൱��û��p[i-1]����ô��Ҫ���p[i-2]��s[j]��ƥ�����,��dp[i+1][j+1]=dp[i-1][j+1]
			 * 		�������1�����߶��p[i-1]����ô��Ҫ���p[i-1]��ʲô�����ַ�
			 * 			���p[i-1]��'.'�ţ���ô����s[j]��ʲô�ַ���s[j]���ǿ��Ա�ƥ��ģ�����ֻҪp[0...i]��s[0...j-1]��ƥ���
			 * 				��ôp[0...i]��s[0...j]����ƥ��ģ���p[i+1][j+1]=p[i+1][j]
			 * 			���p[i-1]����ĸ@(@����һ��Сд��ĸ)����ôp[i]Ҳ����ĸ@�����s[j]Ҳ��@��Ҳ����p[i-1]=s[j],˵��s[j]��
			 * 				���Ա�ƥ�䵽�ģ����ԣ�ֻҪp[0...i]��s[0...j-1]��ƥ��ģ���ôp[0...i]��s[0...j]����ƥ��ģ���p[i+1][j+1]=p[i+1][j]
			 * 		
			 */
			else {
				for (int j = 0; j < s.length(); j++) {
					int k = i - 1 < 0 ? 0 : i - 1;		//��ȡp[i-1]�����i=0����ôp[i-1]=p[0]
					
					//ƥ��0��p[i-1]���൱�ڰ�p[i]��p[i-1]����Ҫ����ʼƥ��p[0...i-2]��s[0...j]
					dp[i+1][j+1] = dp[k][j+1];
					
					/**
					 * 	��ƥ��1�����߶��'*'��ʱ��
					 * 		���'*'��ǰ����'.'�ţ����������jʹ��dp[".*"][j] = true,��ô���е�dp[".*"][m>j]=true
					 * 		���'*'��ǰ�����ַ�@�� ���������jʹ��dp["@*"][j] = true��������s[j+1]=s[j],��dp["@*"][j+1]=true
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
			//�ڼ���dp[i+1][0]ʱ��sһֱ�ǿմ������p[i]=='*'����ô����������p[i-1]��������ʣ��p[0...i-2]�Ϳմ���ƥ�������
			dp[i+1][0] =(p.charAt(i) == '*') &&  dp[i - 1 < 0 ? 0 : i - 1][0];
			for (int j = 0; j < s.length(); j++) {
				if(p.charAt(i) == '.' || p.charAt(i) == s.charAt(j)) {
					dp[i+1][j+1] = dp[i][j];
				}
				
				/**
				 * 	��p[i]Ϊ'*'��ʱ��������0����1������p[i-1]
				 * 		�������0��p[i-1]���൱��û��p[i-1]����ô��Ҫ���p[i-2]��s[j]��ƥ�����,��dp[i+1][j+1]=dp[i-1][j+1]
				 * 		�������1��p[i-1]����ô�൱��p[i]��һ�����ַ�����ôp[0...i]�����p[0...i-1]����dp[i+1][j+1]=dp[i][j+1]
				 * 		�������2�����ϵ�p[i-1]����ô�൱��p[i]=p[i-1],��ʱdp[i+1][j+1]=dp[i+1][j] && s[i-1]==s[j]
				 * 		�������3�����ϵ�p[i-1],
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