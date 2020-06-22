package com.mys.string;

import java.util.ArrayList;
import java.util.Arrays;

public class demo4_��Ч����ĸ��λ�� {

	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";
		System.out.println(Solution4.isAnagram2(s, t));
	}

}
class Solution4 {
    public static boolean isAnagram(String s, String t) {
    	if(s==null || t==null || s.length()!=t.length())
    		return false;
        int[] arr1=toArray(s);
        int[] arr2=toArray(t);
        if(Arrays.equals(arr1, arr2)) {
        	return true;
        }
        return false;
    }

	private static int[] toArray(String str) {
		 int[] arr=new int[26];
        for (int i = 0; i < str.length(); i++) {
        	arr[str.charAt(i)-'a']++;
		}
	    return arr;    
		
	}
	
	
	public static boolean isAnagram1(String s, String t) {
		if(s.length()!=t.length())
			return false;
		ArrayList<Character> list=new ArrayList<Character>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}
		for (int i = 0; i < t.length(); i++) {
			char ch=t.charAt(i);
			int n=list.indexOf(ch);
			if (n!=-1) {
				list.remove(n);
			}
		}
		if(list.isEmpty()) {
			return true;
		}
    	return false;
    }
	
	/*
	 * 	��һ��26��������ӳ���ַ����г��ֵ���ĸ
	 * 	s�ַ����еĵ�ǰ����i��������++
	 * 	t�ַ����еĵ�ǰ����i��������--
	 * 	��������ַ�����λ�����ģ���ô�������������е�Ԫ�ض���0
	 */
	public static boolean isAnagram2(String s, String t) {
		if(s.length()!=t.length())
			return false;
		int[] arr=new int[26];
        for (int i = 0; i < s.length(); i++) {
        	arr[s.charAt(i)-'a']++;
        	arr[t.charAt(i)-'a']--;
		}
        for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0)
				return false;
		}
        return true;
    }
}