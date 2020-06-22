package com.mys.string;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


public class demo91_8¸ö×Ö·û·Ö¸ô {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	     String str = sc.nextLine();
	     System.out.println(str);
	     
	     String[] strs = str.split(" ");
	     TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2) >= 0 ? 1 : -1;
			}
		});
	     for (int i = 1; i < strs.length; i++) {
			add(strs[i],set);
		}
	     System.out.println(set);
	}

	private static void add(String string, TreeSet<String> set) {
		if(string.length() == 8) {
			set.add(string);
		}
		else if(string.length() < 8) {
			while(string.length() < 8) {
				string = string + "0";
			}
			set.add(string);
		}
		else {
			while(string.length() > 8) {
				String str = string.substring(0, 8);
				string = string.substring(8);
				set.add(str);
			}
			if(string.length() == 8) {
				set.add(string);
			}
			else if(string.length() < 8) {
				while(string.length() < 8) {
					string = string + "0";
				}
				set.add(string);
			}
		}
	}
}

