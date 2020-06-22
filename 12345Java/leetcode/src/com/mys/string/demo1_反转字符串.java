package com.mys.string;

public class demo1_·´×ª×Ö·û´® {

	public static void main(String[] args) {
		char[] chs= {'h','e','l','l','o'};
		Solution1.reverseString1(chs);
		System.out.println(chs);
	}

}
class Solution1 {
    public static void reverseString(char[] s) {
    	char ch;
        for (int i = 0; i < s.length/2; i++) {
			ch=s[i];
			s[i]=s[s.length-1-i];
			s[s.length-1-i]=ch;
		}
    }
    
    public static void reverseString1(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
			s[i]^=s[s.length-1-i];
			s[s.length-1-i]^=s[i];
			s[i]^=s[s.length-1-i];
		}
    }
}