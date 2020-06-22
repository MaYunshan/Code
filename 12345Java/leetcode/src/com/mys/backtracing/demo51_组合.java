package com.mys.backtracing;

import java.util.ArrayList;
import java.util.List;

public class demo51_×éºÏ {

	public static void main(String[] args) {
		char[] chs = {'a','b','c','d'};
		List<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int m = 2;
		combine(list,chs,sb,m,0);
		System.out.println(list);
	}

	private static void combine(List<String> list, char[] chs, StringBuilder sb, int m,int index) {
		if(m == 0) {
			list.add(new String(sb));
			return;
		}
		if(index >= chs.length)
			return;
		
		sb.append(chs[index]);
		combine(list, chs, sb, m-1, index+1);
		sb.deleteCharAt(sb.length()-1);
	
		combine(list, chs, sb, m, index+1);
	}

}
