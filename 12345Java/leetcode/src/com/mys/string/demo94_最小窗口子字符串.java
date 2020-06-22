package com.mys.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。 示例： 输入: S = "ADOBECODEBANC", T =
 * "ABC" 输出: "BANC" 说明： 如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 */
public class demo94_最小窗口子字符串 {

	public static void main(String[] args) throws IOException {
		String s = "abdcdddddeeeefdfdf";
		String t = "cde";
		String window = Solution94.minWindow(s, t);
		System.out.println(window);
	}

}

class Solution94 {
	public static String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0)
			return "";

		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
		}

		int charCount = tMap.size();
		int left = 0;
		int right = 0;

		int formed = 0;

		Map<Character, Integer> windowMap = new HashMap<Character, Integer>();

		int[] ans = { -1, 0, 0 };

		while (right < s.length()) {
			char ch = s.charAt(right);
			windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
			if (tMap.containsKey(ch) && tMap.get(ch).intValue() == windowMap.get(ch).intValue()) {
				formed++;
			}
			while(left <= right && charCount == formed) {
				if(ans[0] == -1 || right - left +1 < ans[0]) {
					ans[0] = right - left + 1;
					ans[1] = left;
					ans[2] = right;
				}
				
				char leftCh = s.charAt(left);
				
				windowMap.put(leftCh, windowMap.get(leftCh)-1);
				if(tMap.containsKey(leftCh) && tMap.get(leftCh).intValue() > windowMap.get(leftCh).intValue()) {
					formed--;
				}
				left++;
			}
			right++;
		}

		return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	}
}