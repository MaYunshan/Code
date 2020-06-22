package com.mys.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 	�����ĸ����������������б� A , B , C , D ,�����ж��ٸ�Ԫ�� (i, j, k, l) ��ʹ�� A[i] + B[j] + C[k] + D[l] = 0��
 *	����:
 *		A = [ 1, 2]
 *		B = [-2,-1]
 *		C = [-1, 2]
 *		D = [ 0, 2]
 *
 *	���:
 *		2
 *
 *	����:
 *		����Ԫ������:
 *		1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 *		2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class demo921_����֮�� {

	public static void main(String[] args) {
		int[] A= {1, 2};
		int[] B= {-2,-1};
		int[] C= {-1, 2};
		int[] D= { 0, 2};
		
		int ret = Solution921.fourSumCount1(A, B, C, D);
		System.out.println(ret);
	}

}
class Solution921 {
	
	/**
	 * 	�ⷨ2������hashmap����ʱ�临�Ӷȴ�O(n4)���͵�O(n2)
	 * 		�Ƚ�A��B�����еĸ��ֽ���ó���
	 * 		Ȼ���ó�C��D����Ͻ������map��Ѱ���෴ֵ
	 * 
	 */
	public static int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
		if(A == null || A.length == 0)
        	return 0;
		
		int ret = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sumAB = 0;
		for (int a : A) {
			for (int b : B) {
				sumAB = a + b;
				map.put(sumAB, map.getOrDefault(sumAB, 0)+1);
			}
		}
		
		int sumCD = 0;
		for (int c : C) {
			for (int d : D) {
				sumCD = c + d;
				ret += map.getOrDefault(-sumCD, 0);
			}
		}
		return ret;
	}
	
	
	/**
	 * 	�ⷨ1���ݹ飬�����ڱ����ⷨ��
	 * @param A
	 * @param B
	 * @param C
	 * @param D
	 * @return
	 */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A == null || A.length == 0)
        	return 0;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        int count = dfs(0,0,A,B,C,D,stack,lists);
        System.out.println(lists);
        return count;
    }

	private static int dfs(int pos,int index, int[] a, int[] b, int[] c, int[] d, Stack<Integer> stack, List<List<Integer>> lists) {
		if(pos >= a.length)
			return 0;
		
		if(index == 4) {
			int sum = a[stack.get(0)]+b[stack.get(1)]+c[stack.get(2)]+d[stack.get(3)];
			if(sum == 0) {
				List<Integer> list = new ArrayList<Integer>();
				for (Integer integer : stack) {
					list.add(integer);
				}
				lists.add(list);
				return 1;
			}
			else {
				return 0;
			}
		}
		
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			stack.push(i);
			count += dfs(i, index+1, a, b, c, d,stack, lists);
			stack.pop();
		}
		
		return count;
	}
}