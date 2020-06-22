package com.mys.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class demo9_�����ǰ׺ {

	public static void main(String[] args) {
		String[] strs1 = {"flower","flow","flight"};
		String[] strs2 = {"d","a"};
		
		System.out.println(Solution9.longestCommonPrefix(strs1));
		System.out.println(Solution9.longestCommonPrefix(strs2));
	}

}
class Solution9 {
    public static String longestCommonPrefix(String[] strs) {
    	//����ַ�������ĳ���Ϊ�գ�����
    	if (strs.length==0) {
			return "";
		}
    	//���ҵ�������̵��ַ���
        String str = strs[0];
        for (String string : strs) {
			if (string.length() < str.length()) {
				str = string;
			}
		}
        if(str.isEmpty()) {
        	return "";
        }
        //��str��ǰ1����ǰ2��....�ַ���Ϊ��׼�ַ���key��Ȼ��ֱ��������ַ�����������ƥ��
        String key = "";
        for (int i = 0; i < str.length(); i++) {
			key = str.substring(0, i+1);
			for (String string : strs) {
				if(!string.startsWith(key)) {
					return key.substring(0, i);
				}
			}
		}
        //ѭ�������������˵�������ַ�������strƥ�䣬���ǰ׺����str
    	return str;
    }
    
    //�˷�������
    public static String longestCommonPrefix1(String[] strs) {
    	//����ַ�������ĳ���Ϊ�գ�����
    	if (strs.length==0) {
			return "";
		}
    	//���ַ�������������򣬷ֱ�
    	TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
    		
    		//���ַ����������򣬵�һԭ��Ϊ���ȣ����������ͬ��ָ���ڶ�ԭ��Ϊ�ֵ�˳��
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
    	//��ȡ�ַ����е���С������ַ����������������ظ�ǰ׺��Ϊ����
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