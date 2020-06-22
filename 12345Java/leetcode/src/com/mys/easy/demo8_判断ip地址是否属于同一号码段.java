package com.mys.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class demo8_判断ip地址是否属于同一号码段 {

	public static void main(String[] args) {
		String sIP1,sIP2,sMask;
		Scanner sc=new Scanner(System.in);
		sIP1=sc.nextLine();
		sIP2=sc.nextLine();
		sMask=sc.nextLine();
		
		
//		sIP1 = "192.168.1.9";
//		sIP2 = "192.168.1.10";
//		sMask = "255.255.255.0";
		ArrayList<String> list=new ArrayList<String>();
		int n=get(sIP1,sIP2,sMask,list);
		System.out.println(n);
		System.out.println(list);
	}

	private static int get(String s1, String s2, String mask, ArrayList<String> list) {
		String[] str1=s1.split("\\.");
		String[] str2=s2.split("\\.");
		String[] strMask=mask.split("\\.");
		ArrayList<String> list1=new ArrayList<String>();
		ArrayList<String> list2=new ArrayList<String>();
		
		for (int i = 0; i < strMask.length; i++) {
			int x=(Integer.valueOf(str1[i]) & Integer.valueOf(strMask[i]));
			String b=String.valueOf(x);
			list1.add(b);
		}
		list.addAll(list1);
		for (int i = 0; i < strMask.length; i++) {
			int x=(Integer.valueOf(str2[i]) & Integer.valueOf(strMask[i]));
			String b=String.valueOf(x);
			list2.add(b);
		}
		
		for (int i = 0; i < 4; i++) {
			if(Integer.parseInt(list1.get(i))!=Integer.parseInt(list2.get(i))) {
				return 0;
			}
		}
		return 1;
	}

}
