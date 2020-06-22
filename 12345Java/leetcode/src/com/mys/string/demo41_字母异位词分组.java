package com.mys.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo41_��ĸ��λ�ʷ��� {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = Solution41.groupAnagrams1(strs);
		System.out.println(lists);
	}

}

class Solution41 {
	/**
	 * 	�ⷨ1
	 * @param strs
	 * @return
	 */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        int length = strs.length;
        //�������ÿ���ַ����Ƿ��Ѿ��������˷���
        boolean[] marked = new boolean[length];
        for (int i = 0; i < length; i++) {
        	//�����ǰ���������ַ�����û�б�������飬�Ϳ�ʼ�ж�
			if(marked[i] == false) {
				List<String> list = new ArrayList<String>();
				//����ǰ�ַ�������һ�����鲢�ұ��
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
     * 	�ⷨ2:��ÿһ���ַ����������Ϊ��ֵ��List��Ϊvalue����ÿһ����ĸ��λ��
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        return lists;
    }
    
    /**
     * 	��������
     * 	�ڿ�����+����
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
     * 	��һ��26��������ӳ���ַ����г��ֵ���ĸ
     * 	s�ַ����еĵ�ǰ����i��������++
     * 	t�ַ����еĵ�ǰ����i��������--
     * 	��������ַ�����λ�����ģ���ô�������������е�Ԫ�ض���0
     * 	��֤�����������ַ������ǳ�����ͬ��
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
