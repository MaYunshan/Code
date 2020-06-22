package com.mys.design;

public class Trie {
	/**
	 * 内部类：用来实现前缀树的每一个节点的数据结构
	 */
	class TrieNode{
		protected TrieNode[] TrieNodes;		//每一个节点都有26个子节点
		protected boolean isWord;		//以当前节点为结束字符的字符序列是不是一个单词
		
		public TrieNode() {
			isWord = false;
			TrieNodes = new TrieNode[26];
		}
	}
	
	private TrieNode root;				//前缀树的根节点
	
    public Trie() {
        root = new TrieNode();
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
    
    public boolean search(String word) {
    	TrieNode pNode = root;
    	for (int i = 0; i < word.length(); i++) {
    		int index = word.charAt(i) - 'a';
			if(pNode.TrieNodes[index] == null)
				return false;
			pNode = pNode.TrieNodes[index];
		}
    	//从for循环出来，pNode指向字符串的最后一个字符，如果该节点处isWord是true，代表它是一个字符串
    	return pNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        
    	TrieNode pNode = root;
    	//遍历prefix的每一个字符，如果每个字符处的节点都存在，就返回true
    	for (int i = 0; i < prefix.length(); i++) {
    		int index = prefix.charAt(i) - 'a';
			if(pNode.TrieNodes[index] == null)
				return false;
			pNode = pNode.TrieNodes[index];
		}
    	return true;
    }
}
