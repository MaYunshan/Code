package com.mys.zhongxing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int[][] gridTopo = new int[956][];// 存放原始拓扑信息
	public static int[][] request = new int[4001][];// 存放所有业务需求信息

	public static void readTxt() throws IOException {
		String s;
		int i;
		// 1.read gridtopo
		BufferedReader br = new BufferedReader(new FileReader("D:\\12345Java\\leetcode\\src\\gridtopoAndRequest.txt"));
		s = br.readLine();
		i = 0;
		for (i = 0; i < 956; i++) {
			String[] temp = s.split(" ");
			gridTopo[i] = new int[temp.length];
			for (int kk = 0; kk < temp.length; kk++) {
				gridTopo[i][kk] = Integer.parseInt(temp[kk]);
			}
			s = br.readLine();
		}
		// 2.read request
		i = 0;
		for(i = 0; i< 4001;i++) {
			String[] temp = s.split(" ");
			request[i] = new int[temp.length];
			for (int kk = 0; kk < temp.length; kk++) {
				request[i][kk] = Integer.parseInt(temp[kk]);
			}
			s = br.readLine();
		}
	}

	public static void main(String[] args) throws IOException {
		//1.输入
		readTxt();
		
		//2.write you code
		System.out.println(1);
	}
}
