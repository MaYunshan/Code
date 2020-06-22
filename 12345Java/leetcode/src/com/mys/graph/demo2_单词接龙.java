package com.mys.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 *	给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *		每次转换只能改变一个字母。
 *		转换过程中的中间单词必须是字典中的单词。
 *	说明:
 *		如果不存在这样的转换序列，返回 0。
 *		所有单词具有相同的长度。
 *		所有单词只由小写字母组成。
 *		字典中不存在重复的单词。
 *		你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *	输入:
 *		beginWord = "hit",
 *		endWord = "cog",
 *		wordList = ["hot","dot","dog","lot","log","cog"]
 *	输出: 5
 *		解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *    	返回它的长度 5。
 */

public class demo2_单词接龙 {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>();
		wordList.add("dot");
		wordList.add("hot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		Solution2 solution = new Solution2();
		int length = solution.ladderLength(beginWord, endWord, wordList);
		System.out.println(length);
	}

}
class Solution2 {
	class LevelWord{
		String word;	//单词
		int index;		//该单词在wordList中的索引
		int level;		//从begin到该单词需要的转换次数
		public LevelWord(String word,int index, int level) {
			this.word = word;
			this.index = index;
			this.level = level;
		}
	}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	if(wordList.isEmpty() || !wordList.contains(endWord))
    		return 0;
    	
    	//如果wordList没有包含beginWord，将beginWord加入链表中
    	if(!wordList.contains(beginWord))
    		wordList.add(0, beginWord);
    	
    	int v = wordList.size();
    	
    	//根据字符串数组构造一张图
    	boolean[][] graph = new boolean[v][v];
    	for (int i = 0; i < v; i++) {
			for (int j = i+1; j < v; j++) {
				//如果两个单词只有一个字母不相同，则它们两个之间存在路径
				if(hasEdge(wordList.get(i),wordList.get(j))) {
					graph[i][j] = true;
					graph[j][i] = true;
				}
			}
		}
    	
    	printGraph(graph);
    	
    	//起始索引
    	int startIndex = wordList.indexOf(beginWord);
    	//结束索引
    	int endIndex = wordList.indexOf(endWord);
    	
    	return getMinPath(wordList,graph,startIndex,endIndex);
    }

    /**
     * 
     * @param wordList:		单词列表
     * @param graph:		图		
     * @param startIndex:	开始点
     * @param endIndex:		结束点
     * @return
     */
	private int getMinPath(List<String> wordList, boolean[][] graph, int startIndex, int endIndex) {
		int v = wordList.size();
		//创建一个队列用来做bfs
    	Queue<LevelWord> queue = new LinkedList<LevelWord>();
    	
    	//一维数组用来标记字符串列表中第i个字符串是否被访问过
    	boolean[] marked = new boolean[v];
    	
    	//将起始字符串begin加入到队列中，并且标记
    	queue.offer(new LevelWord(wordList.get(startIndex),startIndex, 1));
    	marked[startIndex] = true;
    	
    	LevelWord newWord = null;
    	while(!queue.isEmpty()) {
    		//取出队首元素
    		newWord = queue.poll();
    		
    		//如果当前取出的字符串已经是结束字符串，返回层数
    		if(newWord.word.equals(wordList.get(endIndex)))
				return newWord.level;
    		
    		//获取当前字符串在字符串列表中的索引
    		int index = newWord.index;
    		
    		//寻找与第index个字符串的邻边元素，如果邻边元素还没有被访问，将其加入队列并且标记
    		for (int i = 0; i < graph[index].length; i++) {
    			String words = wordList.get(i);
				
    			if (graph[index][i] == true && marked[i] == false) {
					queue.add(new LevelWord(words, i, newWord.level+1));
					marked[i] = true;
				}
			}
    	}
        return 0;
	}

	private boolean hasEdge(String str1, String str2) {
		int len = 0;
		for (int i = 0; i < str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				len++;
				if(len > 1)
					break;
			}
		}
		return len == 1;
	}
	
	private void printGraph(boolean[][] graph) {
		for (boolean[] bs : graph) {
			for (int i = 0; i < bs.length; i++) {
				System.out.print((bs[i] == true ? 1 : 0)+" ");
			}
			System.out.println();
		}
	}
}