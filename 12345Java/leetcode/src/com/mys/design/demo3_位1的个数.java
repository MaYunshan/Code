package com.mys.design;

public class demo3_位1的个数 {

	public static void main(String[] args) {
		Integer x = 21;
		
		int count = Solution3.hammingWeight(x);
		System.out.println(count);
	}

}
 class Solution3 {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
    	int x = 0;
		String sb = "";
		for (int i = 0; i < 32; i++) {
			int t = (n & 0x80000000 >>> i);
			t = t >>> (31-i);
			if(t==1)
				x++;
			sb+=t;
		}
		System.out.println(sb);
        return x;
    }
}