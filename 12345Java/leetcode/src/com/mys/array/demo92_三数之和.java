package com.mys.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * ����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��
 * ʹ�� a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ�顣
 * Ҫ��
 * 		Ԫ�ؿ����ظ�ʹ��
 * 		��Ԫ�鲻�����ظ�
 * @author dell
 *
 */
public class demo92_����֮�� {

	public static void main(String[] args) {

		int[] nums = {0,-1,0,1,0};
		Arrays.sort(nums);
		List<List<Integer>> sum = Solution92.threeSum(nums);
		System.out.println(sum);
	}

}
class Solution92 {
	/**
	 * �ⷨ1�������ⷨ������forѭ��,
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> threeSum(int[] nums) {
    	boolean flag0 = false;
    	List<List<Integer>> list = new ArrayList<List<Integer>>(); 
        for (int i = 0; i < nums.length -2; i++) {
        	if(nums[i] > 0)
        		break;
			for (int j = i+1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if(nums[i] + nums[j] + nums[k] == 0) {
						if(nums[i] == 0 && nums[k] == 0) {
							flag0 = true;
						}else {
							List<Integer> list1 = new ArrayList<Integer>();
							list1.add(nums[i]);
							list1.add(nums[j]);
							list1.add(nums[k]);
							
							int m = 0;
							for (; m < list.size(); m++) {
								List<Integer> keyList = list.get(m);
								if(keyList.containsAll(list1)) {
									break;
								}
							}
							if(m == list.size()) {
								list.add(list1);
							}
						}
						
					}
				}
			}
		}
        if(flag0 == true) {
        	list.add(Arrays.asList(0,0,0));
        }
        return list;
    }
    
    /**
     * �ⷨ2���Ȱ�n������ѡ��3���������
     * 		Ȼ���������ϱ���һ�飬�ҳ��������������
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>(); 
    	Stack< Integer> stack = new Stack<Integer>();
    	perm(nums, 0, list, 3, stack);
        return list;
    }
    
    private static void perm(int[] nums,int i, List<List<Integer>> list, int m, Stack<Integer> stack) {
		if(m == 0) {
			if (stack.get(0) + stack.get(1) + stack.get(2) == 0) {
				List<Integer> listNew = new ArrayList<Integer>();
				listNew.addAll(stack);
				int j = 0;
				for (; j < list.size(); j++) {
					List<Integer> keyList = list.get(j);
					if(keyList.containsAll(listNew) && listNew.containsAll(keyList)) {
						break;
					}
				}
				if(j == list.size()) {
					list.add(listNew);
				}
			}
			return;
		}
		if(i == nums.length)
			return;
		
		stack.push(nums[i]);
		perm(nums, i+1, list, m-1, stack);
		stack.pop();
		
		perm(nums, i+1, list, m, stack);
	}
}