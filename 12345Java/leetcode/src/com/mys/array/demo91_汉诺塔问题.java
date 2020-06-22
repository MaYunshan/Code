package com.mys.array;

import java.util.Iterator;
import java.util.Stack;

/**
 * 	����n��������Ҫ�ƶ�ʱ���ܵĴ�����2^n-1
 * @author dell
 *
 */
public class demo91_��ŵ������ {	

	public static void main(String[] args) {
		int count = 3;
        Stack<Integer> a = new Stack<Integer>();
        Stack<Integer> b = new Stack<Integer>();
        Stack<Integer> c = new Stack<Integer>();

        for (int i=count; i>0; i--) {
             a.push(i);
        }
        System.out.println(a);
        recursion(count,a,b,c);
        System.out.println(c);
        
        for (int i = 1; i < 10; i++) {
        	System.out.println(recursion(i, 'a', 'b', 'c'));
        	System.out.println();
		}
	}

	private static int recursion(int n, char a, char b, char c) {
		if(n==0)
			return 0;
		int sum = recursion(n-1, a, c, b);
		System.out.print(a+"->"+c+" ");
		sum = sum + 1;
		sum = sum + recursion(n-1, b, a, c);
		return sum;
	}

	private static void recursion(int n, Stack<Integer> a1, Stack<Integer> b1, Stack<Integer> c1) {
		if(n==0)
			return;
		recursion(n-1, a1, c1, b1);
		c1.push(a1.pop());
		recursion(n-1, b1, a1, c1);
	}

}
