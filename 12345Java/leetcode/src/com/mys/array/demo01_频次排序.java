package com.mys.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class demo01_Ƶ������ {

	public static void main(String[] args) {
		int[] nums = {2,3,56,4,5,6,7,8,10,2,3,4,5,6,73,2,4,5,6};
		Solution01 solution01 = new Solution01();
		
		List<Integer> freSort = solution01.freSort(nums);
		System.out.println(freSort);
		
		List<Integer> freSort1 = solution01.freSort1(nums);
		System.out.println(freSort1);
	}

}
class Solution01{
	static class Node{
		private Integer key;
		private Integer value;
		
		public Node() {
			key = 0;
			value = 0;
		}

		public Node(Integer key, Integer value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
	}
	public List<Integer> freSort1(int[] nums){
		List<Integer> resList = new ArrayList<Integer>();
		
		//��һ��˳��mapͳ�ƹ��ʺͶ�Ӧ��Ƶ��
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}
			else {
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		
		//��ͳ�ƵĽ����װ��һ��Node������
		Node[] nodes = new Node[map.size()];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			nodes[i++] = new Node(entry.getKey(), entry.getValue());
		}
		
		//��Node�������ֱ�Ӳ�������
		for (int j = 1; j < nodes.length; j++) {
			Node temp = nodes[j];
			int k = j;
			while(k-1 >= 0 && nodes[k-1].value < temp.value) {
				nodes[k] = nodes[k-1];
				k--;
			}
			nodes[k] = temp; 
		}
		
		//������õ�Node����ŵ�list��
		for (int j = 0; j < nodes.length; j++) {
			for (int k = 0; k < nodes[j].value; k++) {
				resList.add(nodes[j].key);
			}
		}
		return resList;
	}
	
	/**
	 * 	Ƶ�����򣬽�����Ԫ�ذ��ճ��ֵ�Ƶ�ν������򣬸÷���û��ʵ���ȶ�����
	 * @param nums
	 * @return
	 */
	public List<Integer> freSort(int[] nums){
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}
			else {
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		
		//��map�����entrySetת��Ϊlist
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
		list.sort(new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
				return -(entry1.getValue() - entry2.getValue());
			}

		});
		
		List<Integer> resList = new ArrayList<Integer>();
		for (Entry<Integer, Integer> entry : list) {
			int k = 0;
			while(k++ < entry.getValue()) {
				resList.add(entry.getKey());
			}
		}
		return resList;
	}
}
