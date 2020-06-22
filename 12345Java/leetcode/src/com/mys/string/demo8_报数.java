package com.mys.string;

import java.util.ArrayList;
import java.util.List;

public class demo8_���� {

	public static void main(String[] args) {
		System.out.println(Solution8.countAndSay(5));
	}

}
class Solution8 {
    public static String countAndSay(int n) {
        String[] strs=new String[n];
        strs[0]="1";
        //���ÿһ���������ı���
        for (int i = 1; i < strs.length; i++) {
			strs[i]=getDataString1(strs[i-1]);
		}
    	return strs[n-1];
    }

    //���ݴ������һ�����ģ�������һ������
	private static String getDataString1(String str) {
		List<Character> listKey=new ArrayList<Character>();
		List<Integer> listValue=new ArrayList<Integer>();
		int index=0;
		int count=0;
		while(index<str.length()) {
			for (int i = index; i < str.length(); i++) {
				if(str.charAt(i) != str.charAt(index)) {
					break;
				}
				count++;
			}
			listKey.add(str.charAt(index));
			listValue.add(count);
			index=index+count;
			count=0;
		}
		
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < listKey.size(); i++) {
			sb.append(listValue.get(i));
			sb.append(listKey.get(i));
		}
		return sb.toString();
	}
	
	 private static String getDataString(String str) {
			List<Character> listKey=new ArrayList<Character>();
			List<Integer> listValue=new ArrayList<Integer>();
			int index=0;
			int count=0;
			while(index<str.length()) {
				count=getKeyValue(str,index);
				listKey.add(str.charAt(index));
				listValue.add(count);
				index=index+count;
				count=0;
			}
			
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < listKey.size(); i++) {
				sb.append(listValue.get(i));
				sb.append(listKey.get(i));
			}
			return sb.toString();
		}
	
	private static int getKeyValue(String str, int index) {
		int count=0;
		for (int i = index; i < str.length(); i++) {
			if(str.charAt(i) != str.charAt(index)) {
				break;
			}
			count++;
		}
		return count;
	}
}
