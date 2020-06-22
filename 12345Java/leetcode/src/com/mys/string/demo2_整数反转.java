package com.mys.string;


public class demo2_整数反转 {

	public static void main(String[] args) {
		int a=2147483647;
		int b=-123;
		int c=-2147483648;
		int d=-200;
		
		System.out.println(Solution2.reverse2(a));
		System.out.println(Solution2.reverse2(b));
		System.out.println(Solution2.reverse2(c));
		System.out.println(Solution2.reverse2(d));
	}

}
class Solution2 {
    public static int reverse(int x) {
    	StringBuilder sb=new StringBuilder(Integer.toString(x));
    	if(sb.charAt(0)=='-') {
    		StringBuilder sb1=new StringBuilder();
    		sb1=new StringBuilder();
    		sb1.insert(0, sb, 1, sb.length());
    		sb=sb1;
    	}
    	sb.reverse();
    	try {
			x=x > 0? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) {
			x=0;
		}
    	return x;
    }
    
    public static int reverse1(int x) {
    	if(x==Integer.MIN_VALUE) {
    		return 0;
    	}
    	StringBuilder sb=new StringBuilder(Integer.toString(Math.abs(x)));
    	sb.reverse();
    	try {
			x=x > 0? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) {
			x=0;
		}
    	return x;
    }
    
    public static int reverse2(int x) {
    	long s=0;
    	while(x!=0) {
    		s=s*10+x%10;
    		x=x/10;
    		if (s>Integer.MAX_VALUE || s< Integer.MIN_VALUE) {
				return 0;
			}
    	}
    	
    	return (int)s;
    }
}