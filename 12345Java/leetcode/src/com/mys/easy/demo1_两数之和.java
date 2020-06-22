package com.mys.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class demo1_����֮�� {

	/**
	 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ
	 */
	public static void main(String[] args) {
		int[] nums= {2,2};
		int[] nums1= {3,4,6,7,8,9};
		int target=15;
		int[] result=Solution.twoSum2(nums1, target);
		System.out.println(Arrays.toString(result));
	}

}
class Solution {
	
	/**
	   *  ��һ�ַ���������forѭ���������ⷨ��
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] twoSum(int[] nums, int target) {
        
        for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length && j != i ; j++) {
				if(nums[i]+nums[j]==target) {
					return new int[]{i,j};
				}
			}
		}
        throw new IllegalArgumentException("No Find!");
    }
    
    /**
     *  ����2������hashMap����һ���Ƚ����е�����Ԫ�ط���map�У��ڶ���Ѱ��
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        LinkedHashMap<Integer, Integer> map=new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i],i);
		}
        System.out.println(map);
        for (Integer key : map.keySet()) {
			int other=target-key;
			
			if( map.containsKey(other) ) {
				return new int[]{map.get(key),map.get(other)};
			}
		}
        
        throw new IllegalArgumentException("No Find!");
    }
    
    /**
     * ����3���ռ�������
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
    	Integer[] result=new Integer[2];
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        
        //��һ�α�������
        for (int i = 0; i < nums.length; i++) {
        	//���targetΪż������ô�п����������д���������ͬ����ʹ�ú�Ϊtarget����������²��ܼ���map����Ϊmap�е�key�����ظ��ġ�
        	if(target%2==0 && target/2==nums[i]) {
        		if(result[0]==null) {
        			//��һ���ҵ�target/2���������䱣�棬��Ϊ�������п��ܻ����������
        			result[0]=i;
        		}
        		else {
        			//�ڶ����ҵ�target/2����ʱ����ҵ���������ͬ���������ǵĺ�Ϊtarget
        			result[1]=i;
        		}
        	}
        	else {
        		//���������������������������Ԫ�أ�������Ԫ����Ϊkey���±���Ϊvalue������map
        		map.put(nums[i],i);
        	}
		}
        
        //�ڶ��α�������
        if(result[0]==null || result[1]==null) {
        	for (Integer key : map.keySet()) {
    			int other=target-key;
    			
    			if(map.containsKey(other) ) {
    				return new int[]{map.get(key),map.get(other)};
    			}
    		}
        }
        else {
        	//������������ҵ�����ͬ�������������ǵĺ�Ϊtarget,���ؼ���
        	return new int[] {result[0],result[1]};
        }
        throw new IllegalArgumentException("No Find!");
    }
}