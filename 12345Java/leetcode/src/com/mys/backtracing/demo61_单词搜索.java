package com.mys.backtracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

 /**
 * 	给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 
 *	单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 *	同一个单元格内的字母在一个单词中不允许被重复使用。
 * @author dell
 *
 */
public class demo61_单词搜索 {

	public static void main(String[] args) {
		char[][] board = {
					{'o','a','a','n'},
					{'e','t','a','e'},
					{'i','h','k','r'},
					{'i','f','l','v'}
    			};

		String[] words = {"oath","pea","eat","rain"};
		
		Solution61 solution = new Solution61();
		List<String> lists = solution.findWords(board, words);
		System.out.println(lists);
	}

}
class Solution61 {
	
	/**
	 * 内部类：用来实现前缀树的每一个节点的数据结构
	 */
	class TrieNode{
		protected TrieNode[] TrieNodes;		//每一个节点都有26个子节点
		protected boolean isWord;			//以当前节点为结束字符的字符序列是不是一个单词
		
		public TrieNode() {
			isWord = false;
			TrieNodes = new TrieNode[26];
		}
	}
	
	public void insert(String word) {
    	//让一个pNode节点指向root节点
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
        	int index = word.charAt(i) - 'a';
        	//从头开始遍历每一个字符，判断当前字符是否存在，如果不存在，在当前PNode位置处新创建一个节点
			if(pNode.TrieNodes[index] == null) {
				pNode.TrieNodes[index] = new TrieNode();
			}
			//让pNode指向指向下一层节点，判断下一个字符
			pNode = pNode.TrieNodes[index];
		}
        //字符串遍历结束，将最后一个字符的isWord属性设置为true，代表从根节点到当前位置的字符序列是一个字符串
        pNode.isWord = true;
    }
	
	private TrieNode root = new TrieNode();								//前缀树的根节点
	private Set<String> reSet = new HashSet<String>();
   
	/**
	 * 	把字符串数组转换为一个前缀树，然后让单词矩阵中的每一个字符去匹配前缀树的路径上的每个节点
	 * 	如果单词矩阵当前位置处的字符和节点node中26个位置处的某个索引对应，那么就让节点指向下一层，然后
	 *	在矩阵中当前位置处的上下左右四个位置处跟下一个节点去匹配，如果不能匹配到，直接返回上一层
	 *	如果匹配到的节点的isWord属性为真，说明在单词矩阵中找到一个单词
	 * @param board
	 * @param words
	 * @return
	 */
	public List<String> findWords(char[][] board, String[] words) {
    	if(words.length == 0)
    		return new ArrayList<String>(reSet);
    	
    	//构建前缀树
    	for (String string : words) {
			insert(string);
		}
    	int m = board.length;
    	int n = board[0].length;
    	
    	//用来记录矩阵元素是否被访问
    	boolean[][] visited = new boolean[m][n];
    	
    	//记录前缀树上已经遍历过的节点
    	StringBuilder sb = new StringBuilder();
    	
    	
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
				dfs(board,root,visited,sb,i,j);
			}
		}
        return new ArrayList<String>(reSet);
    }

	private void dfs(char[][] board, TrieNode node, boolean[][] visited, StringBuilder sb, int i, int j) {
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return ;
		if(visited[i][j])
			return ;
		
		char ch = board[i][j];
		//如果矩阵中当前位置处的字符不在当前node的列表中，返回
		if(node.TrieNodes[ch-'a'] == null)
			return ;
		
		//如果在，把该字符添加到栈中，然后让node指向下一层
		sb.append(ch);
		node = node.TrieNodes[ch-'a'];
		
		//如果当前节点的isWord属性为true，说明已经找到了一个单词，并且这个单词被记录在了sb中，将它加入set中
		if(node.isWord == true) {
			reSet.add(sb.toString());
		}
		
		//当前位置标记为访问，遍历该位置的四个邻边位置，
		visited[i][j] = true;
		dfs(board, node, visited, sb, i+1, j);
		dfs(board, node, visited, sb, i-1, j);
		dfs(board, node, visited, sb, i, j+1);
		dfs(board, node, visited, sb, i, j-1);
		visited[i][j] = false;
		sb.deleteCharAt(sb.length()-1);
	}
}

