package com.mys.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo41_字母异位词分组 {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = Solution41.groupAnagrams1(strs);
		System.out.println(lists);
	}

}

class Solution41 {
	/**
	 * 	解法1
	 * @param strs
	 * @return
	 */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        int length = strs.length;
        //用来标记每个字符串是否已经被加入了分组
        boolean[] marked = new boolean[length];
        for (int i = 0; i < length; i++) {
        	//如果当前索引处的字符串还没有被加入分组，就开始判断
			if(marked[i] == false) {
				List<String> list = new ArrayList<String>();
				//将当前字符串加入一个分组并且标记
				list.add(strs[i]);
				marked[i] = true;
				for (int j = i+1; j < length; j++) {
					if(marked[j] == false && strs[i].length() == strs[j].length() && isAnagram(strs[i], strs[j])) {
						list.add(strs[j]);
						marked[j] = true;
					}
				}
				lists.add(list);
			}
		}
        return lists;
    }
    
    /**
     * 	解法2:将每一个字符串排序后作为键值，List作为value保存每一个字母异位词
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        return lists;
    }
    
    /**
     * 	快速排序
     * 	挖坑填数+分治
     * @param strs
     * @param start
     * @param end
     */
    public static void sortLength(String[] strs,int start,int end) {
    	 if (strs == null || start >= end) return;
         int i = start, j = end;
         String pivotKey = strs[start];
         while (i < j) {
             while (i < j && strs[j].length() >= pivotKey.length())
            	 j--;
             if (i < j) 
            	 strs[i++] = strs[j];
             while (i < j && strs[i].length() <= pivotKey.length())
            	 i++;
             if (i < j) 
            	 strs[j--] = strs[i];
         }
         strs[i] = pivotKey;
         sortLength(strs, start, i - 1);
         sortLength(strs, i + 1, end);

	}

	/*
     * 	用一个26的数组来映射字符串中出现的字母
     * 	s字符串中的当前索引i处的数组++
     * 	t字符串中的当前索引i处的数组--
     * 	如果两个字符串是位置异或的，那么最后这个数组所有的元素都是0
     * 	保证进来的两个字符串都是长度相同的
     */
    public static boolean isAnagram(String s, String t) {
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
    
    public static boolean isAnagram(int[] arr, String s, String t) {
    	boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
        	arr[s.charAt(i)-'a']++;
        	arr[t.charAt(i)-'a']--;
    	}
        for (int i = 0; i < arr.length; i++) {
    		if(arr[i]!=0) {
    			flag = false;
    			arr[i] = 0;
    		}
    	}
        return flag;
    }
}
