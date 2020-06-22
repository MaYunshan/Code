package com.mys.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 	����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 *  �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 *  2-abc 3-def 4-ghi 5-jkl 6 mno 7 pqrs 8 tuv 9-wxyz
 *	���룺"23"
 *	�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class demo1_�绰�������ĸ��� {
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
     * @param list:������������ϵ��ַ�������
     * @param strs����Ӧ������ɵ��ַ�������
     * @param sb�������洢�����γɵ��ַ������
     * @param index:����ǰ�������ַ������ַ��������е�������
     * @param position����ǰ�������ַ����ַ����е�λ��
     */
	private static void letterCombine(List<String> list, String[] strs, StringBuilder sb, int index, int position) {
		//������е��ַ��������������ˣ�˵���ҵ���һ����ϣ���ջ�н������list��
		if(index == strs.length) {
			list.add(sb.toString());
			return;
		}
		
		//���ĳһ���ַ�����������ĸ���Ѿ����������ˣ���ô�Ͳ���������ִ����
		if(position == strs[index].length())
			return;
		
		//����index���ַ����ĵ�position������ĸ��ջ
		sb.append(strs[index].charAt(position));
		
		//�ӵ�ǰ�ַ�������ƫ��һλ�����Ҵ���һ���ַ����ĵ�0����ĸ��ʼ
		letterCombine(list, strs, sb, index+1, 0);
		
		//�����Ժ󣬽���index���ַ����ĵ�position������ĸ��ջ��ȡ����
		sb.deleteCharAt(sb.length()-1);
		
		//�ӵ�ǰ�ַ���������ƫ��һλ��
		letterCombine(list, strs, sb, index, position+1);
	}
}