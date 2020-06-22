package com.mys.easy;

import java.util.ArrayList;
	
public class demo5_无重复字符的最长子串 {

	public static void main(String[] args) {
		String s1="bbb";
		System.out.println(Solution5.lengthOfLongestSubstring1(s1));
	}

}

class Solution5 {
	/*
	 *	这种方法的思想是滑动窗口
	 *	窗口从第一个字符开始，窗口右边动态增长，如果找到更长的字符，更新count，
	 *	如果碰到重复的，窗口右边停止增长，窗口左边移动一位，然后窗口右边继续动态增长
	 */
    public static  int lengthOfLongestSubstring(String s) {
    	int count=0;
    	int j=0;
    	for (int i = 0; i < s.length(); i++) {
    		//如果字符串已经遍历了一半，而且当前最长的子串长度已经超过字符串一半
    		//那么，剩下的字符串中最长的子串也不会超过长度的一半，直接返回就可以
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
     * 	滑动窗口方法
     * 	右边不断增长，左边不断消除一位
     */
    public static  int lengthOfLongestSubstring1(String s) {
    	int count=0;
    	int j=0;
    	ArrayList<Character> list=new ArrayList<Character>();
    	for (int i = 0; i < s.length(); i++) {
    		//进入此循环，窗口左边界已经固定，右边开始不断增长，并且把当前窗口内的字符都存入list中
    		//如果索引j到了重复的字符，那么将窗口左边的元素出栈，继续检查窗口右边
			while(j<s.length() && !list.contains(s.charAt(j))) {
				list.add(s.charAt(j));
				count=Math.max(count, j-i+1);
				j++;
				//如果j已经到了最后一个元素，此时最长字符的个数已经找到了，再移动窗口左边已经没有意义了，直接返回即可
				if(j==s.length()) {
					return count;
				}
			}
			list.remove(0);
		}
        return count;
    }

    /*
            *  判断s在开区间[i,j)内的字符是不是唯一的
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