package com.mys.easy;

import java.util.ArrayList;
	
public class demo5_���ظ��ַ�����Ӵ� {

	public static void main(String[] args) {
		String s1="bbb";
		System.out.println(Solution5.lengthOfLongestSubstring1(s1));
	}

}

class Solution5 {
	/*
	 *	���ַ�����˼���ǻ�������
	 *	���ڴӵ�һ���ַ���ʼ�������ұ߶�̬����������ҵ��������ַ�������count��
	 *	��������ظ��ģ������ұ�ֹͣ��������������ƶ�һλ��Ȼ�󴰿��ұ߼�����̬����
	 */
    public static  int lengthOfLongestSubstring(String s) {
    	int count=0;
    	int j=0;
    	for (int i = 0; i < s.length(); i++) {
    		//����ַ����Ѿ�������һ�룬���ҵ�ǰ����Ӵ������Ѿ������ַ���һ��
    		//��ô��ʣ�µ��ַ���������Ӵ�Ҳ���ᳬ�����ȵ�һ�룬ֱ�ӷ��ؾͿ���
    		if(i>s.length()/2 && count>s.length()/2)
    			return count;
    		j=i+1;
			while(j<s.length()+1) {
				if(allSingle(s, i, j)) {
					count=Math.max(count, j-i);
					j++;
				}
				else {
					break;
				}
			}
		}
        return count;
    }
    
    /*
     * 	�������ڷ���
     * 	�ұ߲�����������߲�������һλ
     */
    public static  int lengthOfLongestSubstring1(String s) {
    	int count=0;
    	int j=0;
    	ArrayList<Character> list=new ArrayList<Character>();
    	for (int i = 0; i < s.length(); i++) {
    		//�����ѭ����������߽��Ѿ��̶����ұ߿�ʼ�������������Ұѵ�ǰ�����ڵ��ַ�������list��
    		//�������j�����ظ����ַ�����ô��������ߵ�Ԫ�س�ջ��������鴰���ұ�
			while(j<s.length() && !list.contains(s.charAt(j))) {
				list.add(s.charAt(j));
				count=Math.max(count, j-i+1);
				j++;
				//���j�Ѿ��������һ��Ԫ�أ���ʱ��ַ��ĸ����Ѿ��ҵ��ˣ����ƶ���������Ѿ�û�������ˣ�ֱ�ӷ��ؼ���
				if(j==s.length()) {
					return count;
				}
			}
			list.remove(0);
		}
        return count;
    }

    /*
            *  �ж�s�ڿ�����[i,j)�ڵ��ַ��ǲ���Ψһ��
     */
	private static boolean allSingle(String s, int i, int j) {
		ArrayList<Character> list=new ArrayList<Character>();
		for (int k = i; k < j; k++) {
			if(list.contains(s.charAt(k))) {
				return false;
			}
			list.add(s.charAt(k));
		}
		return true;
	}
}