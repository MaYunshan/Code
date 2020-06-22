package com.mys.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class demo3_�γ̱� {

	public static void main(String[] args) {
		int[][] graph = {
				{0,2}, 
				{1,4}, 
				{1,3}, 
				{3,0}, 
				{4,2}
		};
		
		int[] finish = Solution3.canFinish(5, graph);
		System.out.println(Arrays.toString(finish));
	}

}

class Solution3 {
	
    public static int[] canFinish(int numCourses, int[][] prerequisites) {
    	
        int[] inDegree = new int[numCourses];   			//�������������������
        int count = 0;										//��¼���ջ��Ԫ��
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();		//�ڽӱ�
        for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}

        //�ڽӱ�Ĺ��죬�Լ�ÿ��������ȵ�ͳ��
        for (int[] edge : prerequisites) {
			inDegree[edge[0]]++;
			graph.get(edge[1]).add(edge[0]);
		}
        
        //bfs����
        List<Integer> topoList = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        //��ʼ�����е����Ϊ0�Ķ��������У�����ͳ�����Ϊ0�Ķ���ĸ���
        for (int v = 0; v < numCourses; v++) {
			if(inDegree[v] == 0) {
				queue.add(v);
				count++;
			}
		}
        
        while(!queue.isEmpty()) {
        	//ȡ�����׶���v,���ҽ������뼯��
        	int v = queue.poll();
        	topoList.add(v);
        	//����v���ڱ߶���
        	for (int w : graph.get(v)) {
        		//ȥ�����д�v->w�ıߣ�Ҳ����w��������-1
				inDegree[w]--;
				//���w��������Ϊ0���ͽ����������
				if(inDegree[w] == 0) {
					queue.add(w);
					count++;
				}   
			}
        }
        //�������������еĶ���ĸ�����ͼ�Ķ���ĸ�����ͬ��˵�����Խ�����������
    	if(count == numCourses) {
    		int[] arrs = new int[count];
    		for (int i = 0; i < arrs.length; i++) {
				arrs[i] = topoList.get(i);
			}
    		return arrs;
    	}
    	return null;
    }
}