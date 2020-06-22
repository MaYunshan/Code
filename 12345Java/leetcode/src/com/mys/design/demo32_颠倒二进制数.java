package com.mys.design;

public class demo32_颠倒二进制数 {

	public static void main(String[] args) {
		
		//以指定的进制解析字符串的十进制表示
		String string = "00000010100101000001111010011100";
		int x = Integer.parseInt(string, 2);
		System.out.println(x);
		System.out.println("-------------------------------------------------------------");
		
		//将指定数的补码反转以后返回十进制数
		int y = Integer.reverse(-3);
		System.out.println(y);
		System.out.println(Solution32.getBinary(-3));
		System.out.println(Solution32.getBinary(y));
		System.out.println("-------------------------------------------------------------");
		
		//将指定数的补码按照字节反转以后返回十进制数
		int z = Integer.reverseBytes(-3);
		System.out.println(z);
		System.out.println(Solution32.getBinary(-3));
		System.out.println(Solution32.getBinary(z));
		System.out.println("-------------------------------------------------------------");
	}

}
class Solution32 {

	public static String getBinary(int n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 32; i++) {
			int x = (n & 0x80000000 >>> i) >>> (31 - i);
			sb.append(x);
		}
		return sb.toString();
	}
	
	
}