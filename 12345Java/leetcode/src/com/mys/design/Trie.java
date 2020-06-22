package com.mys.design;

public class Trie {
	/**
	 * �ڲ��ࣺ����ʵ��ǰ׺����ÿһ���ڵ�����ݽṹ
	 */
	class TrieNode{
		protected TrieNode[] TrieNodes;		//ÿһ���ڵ㶼��26���ӽڵ�
		protected boolean isWord;		//�Ե�ǰ�ڵ�Ϊ�����ַ����ַ������ǲ���һ������
		
		public TrieNode() {
			isWord = false;
			TrieNodes = new TrieNode[26];
		}
	}
	
	private TrieNode root;				//ǰ׺���ĸ��ڵ�
	
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
    	//��һ��pNode�ڵ�ָ��root�ڵ�
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
        	int index = word.charAt(i) - 'a';
        	//��ͷ��ʼ����ÿһ���ַ����жϵ�ǰ�ַ��Ƿ���ڣ���������ڣ��ڵ�ǰPNodeλ�ô��´���һ���ڵ�
			if(pNode.TrieNodes[index] == null) {
				pNode.TrieNodes[index] = new TrieNode();
			}
			//��pNodeָ��ָ����һ��ڵ㣬�ж���һ���ַ�
			pNode = pNode.TrieNodes[index];
		}
        //�ַ������������������һ���ַ���isWord��������Ϊtrue������Ӹ��ڵ㵽��ǰλ�õ��ַ�������һ���ַ���
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
    	//��forѭ��������pNodeָ���ַ��������һ���ַ�������ýڵ㴦isWord��true����������һ���ַ���
    	return pNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        
    	TrieNode pNode = root;
    	//����prefix��ÿһ���ַ������ÿ���ַ����Ľڵ㶼���ڣ��ͷ���true
    	for (int i = 0; i < prefix.length(); i++) {
    		int index = prefix.charAt(i) - 'a';
			if(pNode.TrieNodes[index] == null)
				return false;
			pNode = pNode.TrieNodes[index];
		}
    	return true;
    }
}
