package com.mys.dy_program;

public class demo7_²»Í¬Â·¾¶ {

	public static void main(String[] args) {
		int ret = Solution7.uniquePaths(50, 50);
		System.out.println(ret);
	}

}
class Solution7 {
    public static int uniquePaths(int n, int m) {
    	
        return (int)combine(m+n-2,m-1);
    }
    
    /**
     * 	Cnm
     * @param n
     * @param m
     * @return
     */
    public static long combine(int n,int m){
    	if(n/2 < m)
    		m = n-m;
        long sum1 = 1;
        long sum2 = 1;
        for(int i = m; i >= 1; i--){
            sum1 = sum1 * i;
            sum2 = sum2 * (n-m+i);
        }
        return (sum2/sum1);
    }
}