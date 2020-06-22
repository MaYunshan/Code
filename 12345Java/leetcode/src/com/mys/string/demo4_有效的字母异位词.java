package com.mys.string;

import java.util.ArrayList;
import java.util.Arrays;

public class demo4_有效的字母异位词 {

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
	 * 	用一个26的数组来映射字符串中出现的字母
	 * 	s字符串中的当前索引i处的数组++
	 * 	t字符串中的当前索引i处的数组--
	 * 	如果两个字符串是位置异或的，那么最后这个数组所有的元素都是0
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