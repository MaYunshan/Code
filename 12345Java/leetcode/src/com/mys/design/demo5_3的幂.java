package com.mys.design;

public class demo5_3µÄÃİ {

	public static void main(String[] args) {
		boolean b = Solution5.isPowerOfThree(1);
		System.out.println(b);
	}

}
class Solution5 {
    public static boolean isPowerOfThree(int n) {
        while(n>1) {
        	if(n%3 != 0)
        		return false;
        	n = n / 3;
        }
        return n==1;
    }
}