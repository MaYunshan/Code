package com.mys.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class demo3_课程表 {

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
    	
        int[] inDegree = new int[numCourses];   			//用来保存各个顶点的入度
        int count = 0;										//记录入过栈的元素
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>();		//邻接表
        for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}

        //邻接表的构造，以及每个顶点入度的统计
        for (int[] edge : prerequisites) {
			inDegree[edge[0]]++;
			graph.get(edge[1]).add(edge[0]);
		}
        
        //bfs过程
        List<Integer> topoList = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        //开始将所有的入度为0的顶点加入队列，并且统计入度为0的顶点的个数
        for (int v = 0; v < numCourses; v++) {
			if(inDegree[v] == 0) {
				queue.add(v);
				count++;
			}
		}
        
        while(!queue.isEmpty()) {
        	//取出队首顶点v,并且将它加入集合
        	int v = queue.poll();
        	topoList.add(v);
        	//遍历v的邻边顶点
        	for (int w : graph.get(v)) {
        		//去掉所有从v->w的边，也就是w顶点的入度-1
				inDegree[w]--;
				//如果w顶点的入度为0，就将它加入队列
				if(inDegree[w] == 0) {
					queue.add(w);
					count++;
				}   
			}
        }
        //如果所有入过队列的顶点的个数和图的顶点的个数相同，说明可以进行拓扑排序
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