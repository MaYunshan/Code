package com.mys.array;


public class demo7_쳲��������� {

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
	 * 	���ó��淽ʽ����쳲��������У����ڶ���ظ����㣬�˷ѵ�ʱ��ܳ�
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
	 * 	����ʹ��һ��������������ÿ����������쳲��������������������е�ÿ����ֻ��Ҫ����һ��
	 * 	
	 * @param array��쳲�������������
	 * @param n������
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
	 * 	���ݴ���Ĳ����½�һ������Ϊn�����飬���������������е�쳲����������е�ÿһ��
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