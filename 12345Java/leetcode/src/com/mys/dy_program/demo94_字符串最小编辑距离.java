package com.mys.dy_program;

/**
 * 	������������ word1 �� word2��������� word1 ת���� word2 ��ʹ�õ����ٲ����� ��
 *	����Զ�һ�����ʽ����������ֲ�����
 *		����һ���ַ�
 *		ɾ��һ���ַ�
 *		�滻һ���ַ�
 *	����: word1 = "horse", word2 = "ros"
 *	���: 3
 *	����: 
 *		horse -> rorse (�� 'h' �滻Ϊ 'r')
 *		rorse -> rose (ɾ�� 'r')
 *		rose -> ros (ɾ�� 'e')
 *
 */
public class demo94_�ַ�����С�༭���� {

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
	 * 	����1���ݹ�
	 * 	�������ַ�����ͷ����ʼ��һ�Ƚ�ÿһ��λ�õ��ַ������Ƚ������ַ�����i��λ�õ��ַ�ʱ���������������
	 * 		1�����s1[i]==s2[i]��ֱ�ӿ�ʼ�Ƚ�s1[i+1,len1]��s2[i+1,len2]
	 * 		2����s1[i]ɾ�����Ƚ�s1[i+1��len1]��s2[i,len2]
	 * 		3����s1[i]�滻Ϊs2[i]���Ƚ�s1[i+1,len1]��s2[i+1,len2]
	 * 		4����s2[i]���뵽s1[i]��λ�ã��Ƚ�s1[i,len1]��s2[i+1,len2]
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
		
		//ɾ��s1�ĵ�һ���ַ����Ƚ�s1[i+1,len1-1]��s2[j,len2-1]
		int a = dfs(s1, s2, i+1, j) + 1;
		
		//��s1�Ŀ�ͷǰ�����s2[j]���Ƚ�s1[i,len1-1]��s2[j+1,len2-1]
		int b = dfs(s1, s2, i, j+1) + 1;
		
		//��s1[i]�滻Ϊs2[j],�Ƚ�s1[i+1,len1-1]��s2[j+1,len2-1]
		int c = dfs(s1, s2, i+1, j+1) + 1;
		
		return Math.min(a, Math.min(b, c));
	}
	
	/**
	 * 	����2����̬�滮����ά����
	 * 	��һ����ά����dp[i][j]����s1��ǰi���ַ���s2��ǰj���ַ�֮�����̱༭����
	 * 	(s1[0],s2[0]) ==> dp[1][1],dp[0][0]=0������s1��s2���ǿ��ַ���ʱ���༭������0
	 * 	dp[i+1][j+1]��ʾ��s1[i]��s2[j]����̱༭����
	 * 
	 * 	�ڼ���dp[i+1][j+1]ʱ�������ֿ������
	 * 		1�����s1[i]==s2[j]����ô�õ�dp[i+1][j+1]=dp[i][j]
	 * 		2�����s1[i]��=s2[j]�������ֲ�������ʹ��s1[i]==s2[j]
	 * 			1)�������滻����s1[i]�滻Ϊs2[j],��s1[i]==s2[j]����ôdp[i+1][j+1]����
	 * 				��s1[i-1]��s2[j-1]����̱༭���룬�ټ���1���滻��������dp[i+1][j+1]=1+dp[i][j]��
	 * 				dp[i][j]�����s1[i-1]��s2[j-1]����̱༭���룬
	 * 			2)������ɾ������s1[i]ɾ������ôs1[i]�����s1[i-1],��ôdp[i+1][j+1]����
	 * 				��s1[i-1]��s2[j]����̱༭���룬�ټ���1��ɾ����������dp[i+1][j+1]=1+dp[i][j+1]
	 * 				dp[i][j+1]�����s1[i-1]��s2[j]����̱༭���룬
	 * 			3)�����в��룬��s1[i]�ĺ��油һ��s2[j]����ôs1[i]�����s1[i+1]����ʱs1[i+1]==s2[j]
	 * 				���ԣ�dp[i+1][j+1]���Ǵ�s1[i]��s2[j-1]����̱༭���룬�ټ���1��ɾ����������
	 * 				dp[i+1][j+1]=1+dp[i+1][j]��dp[i+1][j]��ʾ��s1[i]��s2[j-1]����̱༭����
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
				int x = dp[i][j] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);		//�滻����
				int y = dp[i+1][j] + 1;													//�������
				int z = dp[i][j+1] + 1;													//ɾ������
				
				//���β����Ժ���Сֵ���Ǵ�s1[i]��s2[j]����С�༭����
				dp[i+1][j+1] = Math.min(x, Math.min(y, z));								
			}
		}
        return dp[word1.length()][word2.length()];
    }
	
	/**
	 * 	����2����̬�滮��һά����
	 */
	public int minDistance2(String word1, String word2) {
		int[] dp = new int[word1.length()+1];
		//dp����ĳ�ʶ״̬������word2λ���ַ���ʱ�������ַ���֮��ı༭����
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}
		
		//dp�����ʶ״̬��word2�ĳ���Ϊ0ʱ�ı༭���룬�˴����ѭ����ʾÿ����word2����һ���ַ�����dp����
		for (int j = 1; j < word2.length(); j++) {
			int temp1 = dp[0];
			dp[0]++;
			for (int i = 0; i < word1.length(); i++) {
				//temp2�����ڶ�ά�������dp[i][j]
				int temp2 = temp1;	
				
				//temp1�����ڶ�ά�������dp[i+1][j]������һ�ָ���dp[i+1]ʱ���ȼ�¼��һ�ֵ�dp[i+1]����Ϊ�ڼ���dp[i+2]ʱ��Ҫ�õ�
				temp1 = dp[i+1];
				
				if(word1.charAt(i) == word2.charAt(j))
					dp[i+1] = temp2;
				else {
					//dp[i]�����ڶ�ά�������dp[i][j+1]
					dp[i+1] = Math.min(dp[i], Math.min(temp1, temp2)) + 1;
				}
			}
		}
		return dp[word1.length()];
    }
}