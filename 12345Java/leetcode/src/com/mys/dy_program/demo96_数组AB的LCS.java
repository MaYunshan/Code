package com.mys.dy_program;

import java.util.Scanner;

public class demo96_Êý×éABµÄLCS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String lineNum = sc.nextLine();
		int n = Integer.valueOf(lineNum);
		int[] A = new int[n];
		int[] B = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		for (int i = 0; i < B.length; i++) {
			B[i] = sc.nextInt();
		}
		
		int ret = dfs(A,B,0,0);
		System.out.println(n);
	}

	private static int dfs(int[] a, int[] b, int i, int j) {
		
		return 0;
	}

}
