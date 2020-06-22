package com.mys.design;

public class demo32_�ߵ��������� {

	public static void main(String[] args) {
		
		//��ָ���Ľ��ƽ����ַ�����ʮ���Ʊ�ʾ
		String string = "00000010100101000001111010011100";
		int x = Integer.parseInt(string, 2);
		System.out.println(x);
		System.out.println("-------------------------------------------------------------");
		
		//��ָ�����Ĳ��뷴ת�Ժ󷵻�ʮ������
		int y = Integer.reverse(-3);
		System.out.println(y);
		System.out.println(Solution32.getBinary(-3));
		System.out.println(Solution32.getBinary(y));
		System.out.println("-------------------------------------------------------------");
		
		//��ָ�����Ĳ��밴���ֽڷ�ת�Ժ󷵻�ʮ������
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