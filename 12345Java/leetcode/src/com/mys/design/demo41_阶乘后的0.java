package com.mys.design;

import java.math.BigInteger;

public class demo41_½×³ËºóµÄ0 {

	public static void main(String[] args) {
		BigInteger n = new BigInteger("40");
		BigInteger ret = Solution41.dfs(n);
		System.out.println(ret);
		
		long re = Solution41.dfs(40);
		System.out.println(re);
		
		int a = Solution41.trailingZeroes(30);
		int abs = Math.abs(a);
		System.out.println(a);
	}

}
class Solution41 {
    public static int trailingZeroes(int n) {
    	if(n < 5)
    		return 0;
    	return n/5+trailingZeroes(n/5);
    }
    
    public static BigInteger dfs(BigInteger n) {
        if(n.equals(BigInteger.ONE))  
        	return BigInteger.ONE;
        else 
        	return n.multiply(dfs(n.subtract(BigInteger.ONE)));
    }
    
    public static long dfs(int n) {
    	if(n <= 1)
    		return 1;
    	else
    		return n*dfs(n-1);
    }
}