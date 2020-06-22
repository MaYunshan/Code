package com.mys.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class demo2_两个数组的交集 {

	public static void main(String[] args) {
		int[] arr1= {4,9,5};
		int[] arr2= {9,4,9,8,4};
		int[] arr3=Solution2.intersection3(arr1, arr2);
		System.out.println(Arrays.toString(arr3));
	}

}

class Solution2 {
	/*
	 *  两个数组的交集
	 *  无重复元素的交集
	 */
    public static int[] intersection(int[] nums1, int[] nums2) {
    	
    	ArrayList<Integer> list=new ArrayList<Integer>();
        HashSet<Integer> set=new HashSet<Integer>();
        for (int a : nums1) {
			set.add(a);
		}
        for (int i = 0; i < nums2.length; i++) {
			if(set.contains(nums2[i])) {
				list.add(nums2[i]);
				set.remove(nums2[i]);
			}
		}
        int[] newNums=new int[list.size()];
        for (int i = 0; i < newNums.length; i++) {
			newNums[i]=list.get(i);
		}
        return newNums;
    }
    
    /*
	 *  两个数组的交集
	 *  保留重复元素的交集
	 */
    public static int[] intersection1(int[] nums1, int[] nums2) {
    	
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	ArrayList<Integer> li=new ArrayList<Integer>();
        for (int a : nums1) {
			li.add(a);
		}
        for (int i = 0; i < nums2.length; i++) {
        	if(li.size()<0) {
        		break;
        	}
			if(li.contains(nums2[i])) {
				list.add(nums2[i]);
				li.remove(li.indexOf(nums2[i]));
			}
		}
        int[] newNums=new int[list.size()];
        for (int i = 0; i < newNums.length; i++) {
			newNums[i]=list.get(i);
		}
        return newNums;
    }
    
    /*
	 *  两个数组的交集
	 *  保留重复元素的交集
	 */
    public static int[] intersection3(int[] nums1, int[] nums2) {
    	
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int a : nums1) {
			map.put(a, !map.containsKey(a) ? 1 : map.get(a)+1);
		}
        for (int i = 0; i < nums2.length; i++) {
        	if(map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
        		list.add(nums2[i]);
        		map.put(nums2[i], map.get(nums2[i])-1);
        	}
			
		}
        int[] newNums=new int[list.size()];
        for (int i = 0; i < newNums.length; i++) {
			newNums[i]=list.get(i);
		}
        return newNums;
    }
    
    /*
	 *  两个数组的交集
	 *  先将两个数组排序
	 *  保留重复元素的交集
	 */
    public static int[] intersection2(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	//两个指针分别指向数组1和数组2
    	for (int i = 0, j = 0; i < nums1.length && j<nums2.length; ) {
    		//如果i指向的元素小于j指向的元素，那么i指向的元素肯定不可能属于交集
			if(nums1[i]<nums2[j]) {
				i++;
			}
			//如果i指向的元素大于j指向的元素，那么j指向的元素肯定不可能属于交集
			else if(nums1[i]>nums2[j]) {
				j++;
			}
			else {
				//如果当前两个指针指向的元素的相等，那么它们属于交集，两个指针后移
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
        int[] newNums=new int[list.size()];
        for (int i = 0; i < newNums.length; i++) {
			newNums[i]=list.get(i);
		}
        return newNums;
    }
}