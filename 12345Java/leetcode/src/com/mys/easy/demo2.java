package com.mys.easy;

import java.util.Scanner;

public class demo2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=0;
		if(sc.hasNextInt()) {
			n=sc.nextInt();
		}
		int[] arrs=new int[n];
		int[] Ai=new int[n-1];
		int[] Pi=new int[n-1];
		for(int i=0;i<arrs.length;i++)
	    {
			arrs[i]=sc.nextInt();
        }
		
		getMin(arrs, Ai, Pi);
	}

	private static void getMin(int[] arrs, int[] Ai, int[] Pi) {
		for (int i = 1; i < arrs.length; i++) {
			int value=Integer.MAX_VALUE;
			for (int j = i-1; j < arrs.length && j >= 0; j--) {
				if(Math.abs(arrs[i]-arrs[j])<=value) {
					value=Math.abs(arrs[i]-arrs[j]);
					Ai[i-1]=value;
					Pi[i-1]=j+1;
				}
			}
		}
		
		for (int i = 0; i < Pi.length; i++) {
			System.out.println(Ai[i]+" "+Pi[i]);
		}
	}
}
