package com.mys.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 *	�����������ʣ�beginWord �� endWord����һ���ֵ䣬�ҵ��� beginWord �� endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���
 *		ÿ��ת��ֻ�ܸı�һ����ĸ��
 *		ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 *	˵��:
 *		���������������ת�����У����� 0��
 *		���е��ʾ�����ͬ�ĳ��ȡ�
 *		���е���ֻ��Сд��ĸ��ɡ�
 *		�ֵ��в������ظ��ĵ��ʡ�
 *		����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 *	����:
 *		beginWord = "hit",
 *		endWord = "cog",
 *		wordList = ["hot","dot","dog","lot","log","cog"]
 *	���: 5
 *		����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *    	�������ĳ��� 5��
 */

public class demo2_���ʽ��� {

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
		String word;	//����
		int index;		//�õ�����wordList�е�����
		int level;		//��begin���õ�����Ҫ��ת������
		public LevelWord(String word,int index, int level) {
			this.word = word;
			this.index = index;
			this.level = level;
		}
	}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	if(wordList.isEmpty() || !wordList.contains(endWord))
    		return 0;
    	
    	//���wordListû�а���beginWord����beginWord����������
    	if(!wordList.contains(beginWord))
    		wordList.add(0, beginWord);
    	
    	int v = wordList.size();
    	
    	//�����ַ������鹹��һ��ͼ
    	boolean[][] graph = new boolean[v][v];
    	for (int i = 0; i < v; i++) {
			for (int j = i+1; j < v; j++) {
				//�����������ֻ��һ����ĸ����ͬ������������֮�����·��
				if(hasEdge(wordList.get(i),wordList.get(j))) {
					graph[i][j] = true;
					graph[j][i] = true;
				}
			}
		}
    	
    	printGraph(graph);
    	
    	//��ʼ����
    	int startIndex = wordList.indexOf(beginWord);
    	//��������
    	int endIndex = wordList.indexOf(endWord);
    	
    	return getMinPath(wordList,graph,startIndex,endIndex);
    }

    /**
     * 
     * @param wordList:		�����б�
     * @param graph:		ͼ		
     * @param startIndex:	��ʼ��
     * @param endIndex:		������
     * @return
     */
	private int getMinPath(List<String> wordList, boolean[][] graph, int startIndex, int endIndex) {
		int v = wordList.size();
		//����һ������������bfs
    	Queue<LevelWord> queue = new LinkedList<LevelWord>();
    	
    	//һά������������ַ����б��е�i���ַ����Ƿ񱻷��ʹ�
    	boolean[] marked = new boolean[v];
    	
    	//����ʼ�ַ���begin���뵽�����У����ұ��
    	queue.offer(new LevelWord(wordList.get(startIndex),startIndex, 1));
    	marked[startIndex] = true;
    	
    	LevelWord newWord = null;
    	while(!queue.isEmpty()) {
    		//ȡ������Ԫ��
    		newWord = queue.poll();
    		
    		//�����ǰȡ�����ַ����Ѿ��ǽ����ַ��������ز���
    		if(newWord.word.equals(wordList.get(endIndex)))
				return newWord.level;
    		
    		//��ȡ��ǰ�ַ������ַ����б��е�����
    		int index = newWord.index;
    		
    		//Ѱ�����index���ַ������ڱ�Ԫ�أ�����ڱ�Ԫ�ػ�û�б����ʣ����������в��ұ��
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