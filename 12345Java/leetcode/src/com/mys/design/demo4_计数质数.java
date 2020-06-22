package com.mys.design;

/**
 * 	统计所有小于非负整数 n 的质数的数量。
 * @author dell
 *
 */
public class demo4_计数质数 {

	public static void main(String[] args) {
		System.out.println(Solution4.countPrimes(20));
	}

}
class Solution4 {
    public static int countPrimes(int n) {
    	int count = 0;
        for (int i = 2; i < n; i++) {
			if(isPrime(i))
				count++;
		}
    	return count;
    }

    /**
     * 	判断一个数是否是质数
     * 	大于等于5的质数一定和6的倍数相邻。
     * @param i
     * @return
     */
	private static boolean isPrime(int i) {
		if(i == 2 || i == 3)
			return true;
		
		//不是6两侧的数肯定不可能是
		if(i % 6 != 1 && i % 6 != 5)
			return false;
		
		//执行到这里，只有可能是大于等于5的奇数，，，5,7,11,13.....
		//而且这个数不能被2整除，不能被3整除，不能别4整除，不能被5整除【除了唯一的5】，只有可能被6x+1或者6x+5整除
		for (int j = 5; j <= Math.sqrt(i); j+=6) {
			if(i % j == 0 || i % (j+2) == 0)
				return false;
		}
		return true;
	}
}