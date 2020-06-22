package com.mys.string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo5_��֤�����ַ��� {

	public static void main(String[] args) {
		String s1="A man, a plan, a canal: Panama";
		String s4 = s1.replaceAll("[^a-z|^1-9|^A-Z]", "");
		System.out.println(s4);
		String s2="abba";
		String s3="";
		System.out.println(Solution5.isPalindrome2(s1));
	}

}
class Solution5 {
	/*
	 * 	һ��ָ��ָ��ͷ����һ��ָ��ָ��β��
	 * 	���������ĸ�������֣�������λ�ã�
	 * 	�ж���������������ĸ�Ƿ���ͬ
	 */
    public static boolean isPalindrome(String s) {
    	if (s==null) {
			return false;
		}
    	if(s.isEmpty()) {
    		return true;
    	}
    	int i=0;
    	int j=s.length()-1;
    	while(i<=j) {
    		while(i<=j && !Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))) {
    			i++;
    		}
    		while(i<=j && !Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))) {
    			j--;
    		}
    		if(i<=j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
    			return false;
    		}
    		i++;
    		j--;
    	}
        return true;
    }
    
    public static boolean isPalindrome1(String s) {
    	if (s==null) {
			return false;
		}
    	
    	//���������ַ����еķ����ַ���ĸ�ַ�ȫ������
    	String regex="[^a-z^A-Z^0-9]+";
    	String str=s.replaceAll(regex, "").toLowerCase();
    	int len=str.length();
    	for (int i = 0; i < len/2; i++) {
			if(str.charAt(i)!=str.charAt(len-1-i))
				return false;
		}
    	return true;
    }
    
    public static boolean isPalindrome2(String s) {
    	if (s==null) {
			return false;
		}
    	int i=0;
    	int j=s.length()-1;
    	s=s.toLowerCase();
    	while(i<=j) {
    		while(i<=j && !Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))) {
    			i++;
    		}
    		while(i<=j && !Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))) {
    			j--;
    		}
    		if(i<=j && s.charAt(i) != s.charAt(j)) {
    			return false;
    		}
    		i++;
    		j--;
    	}
        return true;
    }
}