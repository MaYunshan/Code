package com.mys.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 	给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *  2-abc 3-def 4-ghi 5-jkl 6 mno 7 pqrs 8 tuv 9-wxyz
 *	输入："23"
 *	输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class demo1_电话号码的字母组合 {
	public static void main(String[] args) {
			String string = "23";
			List<String> list = Solution1.letterCombinations(string);
			System.out.println(list);
			
	}

}
class Solution1 {
    public static List<String> letterCombinations(String digits) {
    	Map<Character, String> map = new HashMap<Character, String>();
    	map.put('2', "abc");
    	map.put('3', "def");
    	map.put('4', "ghi");
    	map.put('5', "jkl");
    	map.put('6', "mno");
    	map.put('7', "pqrs");
    	map.put('8', "tuv");
    	map.put('9', "wxyz");
    	
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if(digits != null && !digits.isEmpty()) {
        	int length = digits.length();
        	String[] strs = new String[length];
        	for (int i = 0; i < digits.length(); i++) {
				strs[i] = map.get(digits.charAt(i));
			}
        	
        	letterCombine(list,strs,sb,0,0);
        }
        
        return list;
    }

    /**
     * 	
     * @param list:存放最后所有组合的字符串集合
     * @param strs：对应数字组成的字符串数组
     * @param sb：用来存储正在形成的字符串组合
     * @param index:代表当前遇到的字符串在字符串数组中的索引，
     * @param position：当前遇到的字符在字符串中的位置
     */
	private static void letterCombine(List<String> list, String[] strs, StringBuilder sb, int index, int position) {
		//如果所有的字符串都被遍历完了，说明找到了一种组合，将栈中结果存入list中
		if(index == strs.length) {
			list.add(sb.toString());
			return;
		}
		
		//如果某一个字符串的所有字母都已经被遍历完了，那么就不用再往下执行了
		if(position == strs[index].length())
			return;
		
		//将第index个字符串的第position处的字母入栈
		sb.append(strs[index].charAt(position));
		
		//从当前字符串纵向偏移一位，并且从下一个字符串的第0个字母开始
		letterCombine(list, strs, sb, index+1, 0);
		
		//出来以后，将第index个字符串的第position处的字母从栈中取出来
		sb.deleteCharAt(sb.length()-1);
		
		//从当前字符串横向向偏移一位，
		letterCombine(list, strs, sb, index, position+1);
	}
}