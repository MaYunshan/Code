package com.mys.dy_program;

public class demo2_��¥�� {

	public static void main(String[] args) {
		int ret = Solution3.climbStairs1(4);
		System.out.println(ret);
	}

}
class Solution3 {
	/**
	 * 	��¥������
	 * 		ÿһ��¥�ݵ����һ��¥�ݵ��߷����ǹ̶��ģ�����
	 * 			������һ�㵽���һ��ֻ��һ���߷� ��f(n-1)=1;
	 * 			�����ڶ��㵽���һ��ֻ�������߷���f(n-2)=2;
	 * 			��ô���������㵽���һ�����������
	 * 				1).����һ�����ﵹ���ڶ��㣬Ȼ��ӵ����ڶ��㵽�����һ�㣬һ����f(n-2)���߷�
	 * 				2).�����������ﵹ����һ�㣬Ȼ��ӵ�����һ�㵽�����һ�Σ�һ����f(n-1)���߷�
	 * 			���ԣ��ӵ��������㵽���һ����ܹ����߷���f(n-3)=f(n-1)+f(n-2);
	 * 		�ӵ�һ��(��������n��)�����һ�㣬��Ҫf(0)=f(1)+f(2)
	 * ������쳲�������������
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
    	int[] arrs = new int[n+1];
    	return climStair(0,n,arrs);
    }
	private static int climStair(int i, int n,int[] arrs) {
		if(i > n)
			return 0;
		if(i == n) {
			return 1;
		}
		if (arrs[i] > 0) {
			return arrs[i];
		}
		arrs[i] = climStair(i+1, n, arrs)+climStair(i+2, n, arrs);
		return arrs[i];
	}
	
	/**
	 * �����ⷨ
	 * 	��Ҫ��n��̨�ף���ôһ����n+1��̨�ף���0�㣬��1��.....��n��
	 * @param n
	 * @return
	 */
	public static int climbStairs1(int n) {
		if(n == 0) {
			return 0;
		}else if (n == 1) {
			return 1;
		}else {
			int[] arrs = new int[n+1];
	    	arrs[n] = 0;
	    	arrs[n-1] = 1;
	    	arrs[n-2] = 2;
	    	for (int i = n-3; i >= 0; i--) {
				arrs[i] = arrs[i+1] +arrs[i+2];
			}
	    	return arrs[0];
		}
    }
}