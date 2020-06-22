package com.mys.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * ����һ���ǿյ��������飬�������г���Ƶ��ǰ k �ߵ�Ԫ�ء�
 * @author dell
 *
 */
public class demo2_ǰk����Ƶ��ĸ {

	public static void main(String[] args) {
		int[] nums = {4,1,-1,2,-1,2,3};
		List<Integer> list = Solution2.topKFrequent(nums, 2);
		System.out.println(list);
	}

}
class Solution2 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
    	//���ݼ�ֵ��Ƶ�ι���map
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i])+1 : 1);
		}
    	
    	//����һ�����ȶ��У��������ȶ��������k��Ԫ�أ��ٺ����Ԫ�أ������������
    	PriorityQueue<Freq> pq = new PriorityQueue<Freq>();
    	
    	for (Integer key : map.keySet()) {
			if(pq.size() < k) {
				pq.add(new Freq(key, map.get(key)));
			}
			else if(map.get(key).compareTo(pq.peek().frequency) > 0) {
				pq.poll();
				pq.add(new Freq(key, map.get(key)));
			}
		}
    	List<Integer> list = new ArrayList<Integer>();
    	while(!pq.isEmpty()) {
    		list.add(pq.poll().key);
    	}
    	return list;
    }
}

class Freq implements Comparable<Freq> {
	public int key;
	public int frequency;
	

	public Freq(int key, int frequency) {
		super();
		this.key = key;
		this.frequency = frequency;
	}


	@Override
	public int compareTo(Freq o) {
		return this.frequency - o.frequency;
	}
	
}