package com.mys.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class demo9_最长公共前缀 {

	public static void main(String[] args) {
		String[] strs1 = {"flower","flow","flight"};
		String[] strs2 = {"d","a"};
		
		System.out.println(Solution9.longestCommonPrefix(strs1));
		System.out.println(Solution9.longestCommonPrefix(strs2));
	}

}
class Solution9 {
    public static String longestCommonPrefix(String[] strs) {
    	//如果字符串数组的长度为空，返回
    	if (strs.length==0) {
			return "";
		}
    	//先找到长度最短的字符串
        String str = strs[0];
        for (String string : strs) {
			if (string.length() < str.length()) {
				str = string;
			}
		}
        if(str.isEmpty()) {
        	return "";
        }
        //以str的前1个，前2个....字符作为基准字符串key，然后分别与其它字符串进行正则匹配
        String key = "";
        for (int i = 0; i < str.length(); i++) {
			key = str.substring(0, i+1);
			for (String string : strs) {
				if(!string.startsWith(key)) {
					return key.substring(0, i);
				}
			}
		}
        //循环从这里出来，说明所有字符串都与str匹配，则最长前缀就是str
    	return str;
    }
    
    //此方法有误
    public static String longestCommonPrefix1(String[] strs) {
    	//如果字符串数组的长度为空，返回
    	if (strs.length==0) {
			return "";
		}
    	//将字符串数组进行排序，分别
    	TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
    		
    		//将字符串进行排序，第一原则为长度，如果长度相同，指定第二原则为字典顺序
			@Override
			public int compare(String str1, String str2) {
				int len = str1.length() - str2.length();
				return len == 0 ? (str1.compareTo(str2) <= 0 ? -1 : 1) : len;
			}
		});
    	for (String string : strs) {
			set.add(string);
		}
    	System.out.println(set);
    	//获取字符串中的最小和最大字符串，它们两个的重复前缀即为所求
    	String strMin = set.first();
    	String strMax = set.last();
    	
    	for (int i = 0; i < strMin.length(); i++) {
			String key = strMin.substring(0,i+1);
			if(!strMax.startsWith(key)) {
				return key.substring(0,i);
			}
		}
    	return strMin;
    }
}