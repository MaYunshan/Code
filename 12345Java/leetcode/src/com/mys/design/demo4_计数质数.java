package com.mys.design;

/**
 * 	ͳ������С�ڷǸ����� n ��������������
 * @author dell
 *
 */
public class demo4_�������� {

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
     * 	�ж�һ�����Ƿ�������
     * 	���ڵ���5������һ����6�ı������ڡ�
     * @param i
     * @return
     */
	private static boolean isPrime(int i) {
		if(i == 2 || i == 3)
			return true;
		
		//����6��������϶���������
		if(i % 6 != 1 && i % 6 != 5)
			return false;
		
		//ִ�е����ֻ�п����Ǵ��ڵ���5������������5,7,11,13.....
		//������������ܱ�2���������ܱ�3���������ܱ�4���������ܱ�5����������Ψһ��5����ֻ�п��ܱ�6x+1����6x+5����
		for (int j = 5; j <= Math.sqrt(i); j+=6) {
			if(i % j == 0 || i % (j+2) == 0)
				return false;
		}
		return true;
	}
}