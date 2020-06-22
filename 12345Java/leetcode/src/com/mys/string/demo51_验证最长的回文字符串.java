package com.mys.string;

/**
 * 	����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
 *
 */
public class demo51_��֤��Ļ����ַ��� {

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
	 * 	�ⷨ3��������ɢ��
	 */
	public static String longestPalindrome2(String s) {
		if(s == null || s.length() == 0 || s.length() == 1)
			return s;
		int length = s.length();
		
		//������¼���������л��Ĵ�����ʼ����ֹ����
		int start = 0;
		int end = 0;
		/**
		 * 	��i=(2n+1)��0.5ʱ��low=n+1,high=n+2,��ô��ʱ���Ĵ���������˫��������ͬ"ab"����"ac"����������
		 * 	��i=(2n)��0.5ʱ��low = high = n����ʱ�����Ĵ��������ǵ����ַ�������ͬ"a","b",,,,"c"����������
		 * 	һ��ȷ���˻��Ĵ������ģ���ô�Ϳ�ʼ������λ��������չ�����Ҳ��ϸ����µĻ��Ĵ�����ʼ����ֹ����
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
	 * 	�ⷨ2����̬�滮����ά����
	 * 		��һ����ά����dp[][]��ʾ�ַ�������������֮���Ƿ���һ�������ַ���,dp[i][j]��ʾs[i...j]�Ƿ���һ�������ַ���
	 * 		dp�ĳ�ʼ�������г���Ϊ1���Ӵ����ǻ����ַ�������dp[i][i] =true;����Ϊ2���Ӵ���Ҫ�жϣ����s[i]=s[i+1]����ôdp[i][i+1]=true
	 * 		dp��״̬ת�Ʒ��̣�dp[i][j] = (dp[i+1][j-1]) && (s[i]==s[j])
	 * 			���dp[i+1][j-1]Ϊtrue��˵��s[i+1...j-1]��һ�������ַ��������s[i]=s[j]����ôdp[i][j]=true
	 * 			����dp[i][j]Ϊfalse
	 */
	public static String longestPalindrome1(String s) {
		if(s.length() == 0 || s.length() == 1)
			return s;
		int length = s.length();
		int start = 0;
		int maxLen = 1;
		boolean[][] dp = new boolean[length][length];
		
		for (int i = 0; i < length; i++) {
			//����Ϊ1���Ӵ��϶��ǻ����ַ���
			dp[i][i] = true;
			
			//����Ϊ2���Ӵ������s[i]==s[i+1],��ô������һ�������ַ���
			if(i+1 < length && s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = true;
				maxLen = 2;
				start = i;
			}
		}
		
		//�жϳ���Ϊlen���Ӵ��Ƿ��ǻ����ַ��������ȳ�ʼֵΪ3
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
	 * 	�ⷨ1�������ⷨ
	 */
    public static String longestPalindrome(String s) {
    	//�����������ֱ��¼��Ļ����ַ������±�
    	int x = 0;
    	int y = 0;
    	int length = 0;
    	for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			for (int j = s.length()-1; j >= i; j--) {
				//���ַ�������濪ʼ�����������������ch��ͬ���ַ������ж������Χ�ڵ��ַ����Ƿ���һ�������ַ���
				if(s.charAt(j) == ch && isPalindrome(s, i, j)) {
					//����ǻ����ַ�������ȡ����
					int newLength = j - i + 1;
					if(newLength > length) {
						//�����ǰ�ҵ��ĳ��ȱ���һ�εĳ����滻
						x = i;
						y = j;
						length = newLength;
					}
					//��Ϊ�ǴӺ���ǰ����������Ѿ��ҵ���һ�������ַ������پ�û�б�Ҫj--����ʹ�У�ֻ�����
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