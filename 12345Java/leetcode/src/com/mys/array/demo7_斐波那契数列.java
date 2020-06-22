package com.mys.array;


public class demo7_斐波那契数列 {

	public static void main(String[] args) {
		long startTime1=System.currentTimeMillis();
		System.out.println(Solution7.fun(50));
		long endTime1=System.currentTimeMillis();
		
		long startTime2=System.currentTimeMillis();
		System.out.println(Solution7.Feibo(50));
		long endTime2=System.currentTimeMillis();
		
		System.out.println(endTime1-startTime1);
		System.out.println(endTime2-startTime2);
	}
	
	
}
class Solution7{
	
	/**
	 * 	采用常规方式计算斐波那契数列，存在多次重复计算，浪费的时间很长
	 */
	public static long fun(int n) {
		if(n<=2) {
			return 1;
		}
		else {
			return fun(n-1)+fun(n-2);
		}
	}
	
	/**
	 * 	可以使用一个数组用来保存每个索引处的斐波那契数，这样，数列中的每个数只需要计算一次
	 * 	
	 * @param array：斐波那契数列数组
	 * @param n：项数
	 * @return
	 */
	private static long fun(long[] array,int n) {
		if(n<=2) {
			array[n]=1;
			return array[n];
		}
		
		else {
			array[n]=fun(array, n-1)+array[n-2];
		}
		return array[n];
	}
	
	/**
	 * 	根据传入的参数新建一个长度为n的数组，用来保存计算过程中的斐波那契数列中的每一项
	 * @param n
	 * @return
	 */
	public static long Feibo(int n) {
		if(n<1) {
			return 0;
		}
		else if(n<=2) {
			return 1;
		}
		else {
			long[] arr=new long[n+1];
			arr[1]=1;
			long ret=fun(arr, n);
			return ret;
		}
	}
}