package com.mys.design;

public class demo31_ººÃ÷¾àÀë {

	public static void main(String[] args) {
		int ret = Solution31.hammingDistance(4, 8);
		System.out.println(ret);
	}

}
class Solution31 {
    public static int hammingDistance(int x, int y) {
    	int count = 0;
        String str1 = getBinary(x);
        String str2 = getBinary(y);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(-3));
        for (int i = 0; i < 32; i++) {
			if(str1.charAt(i) != str2.charAt(i))
				count++;
		}
        return count;
    }

	private static String getBinary(int n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 32; i++) {
			int x = (n & 0x80000000 >>> i) >>> (31 - i);
			sb.append(x);
		}
		return sb.toString();
	}
	
	
}