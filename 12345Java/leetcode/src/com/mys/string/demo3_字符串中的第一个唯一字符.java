package com.mys.string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class demo3_字符串中的第一个唯一字符 {

	public static void main(String[] args) {
		String str="aadadaad";
		System.out.println(Solution3.firstUniqChar1(str));
	}

}
class Solution3 {
    public static int firstUniqChar(String s) {
    	Character c=' ';
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
        	char ch=s.charAt(i);
			map.put(ch, !map.containsKey(ch) ? 1 :map.get(ch)+1 );
		}
        System.out.println(map);
        for (Character ch : map.keySet()) {
			if(map.get(ch)==1) {
				c=ch;
				break;
			}
		}
    	return s.indexOf(c);
    }
    
    public static int firstUniqChar1(String s) {
        int[] arr=new int[26];
        for (int i = 0; i < s.length(); i++) {
        	arr[s.charAt(i)-'a']++;
		}
        for (int i = 0; i < s.length(); i++) {
			if(arr[s.charAt(i)-'a']==1) {
				return s.indexOf(s.charAt(i));
			}
		}
        return -1;
    }
    
    
}