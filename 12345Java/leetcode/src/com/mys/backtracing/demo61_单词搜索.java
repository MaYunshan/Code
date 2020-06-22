package com.mys.backtracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

 /**
 * 	����һ����ά���� board ��һ���ֵ��еĵ����б� words���ҳ�����ͬʱ�ڶ�ά������ֵ��г��ֵĵ��ʡ�
 * 
 *	���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��
 *	ͬһ����Ԫ���ڵ���ĸ��һ�������в������ظ�ʹ�á�
 * @author dell
 *
 */
public class demo61_�������� {

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
	 * �ڲ��ࣺ����ʵ��ǰ׺����ÿһ���ڵ�����ݽṹ
	 */
	class TrieNode{
		protected TrieNode[] TrieNodes;		//ÿһ���ڵ㶼��26���ӽڵ�
		protected boolean isWord;			//�Ե�ǰ�ڵ�Ϊ�����ַ����ַ������ǲ���һ������
		
		public TrieNode() {
			isWord = false;
			TrieNodes = new TrieNode[26];
		}
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
	
	private TrieNode root = new TrieNode();								//ǰ׺���ĸ��ڵ�
	private Set<String> reSet = new HashSet<String>();
   
	/**
	 * 	���ַ�������ת��Ϊһ��ǰ׺����Ȼ���õ��ʾ����е�ÿһ���ַ�ȥƥ��ǰ׺����·���ϵ�ÿ���ڵ�
	 * 	������ʾ���ǰλ�ô����ַ��ͽڵ�node��26��λ�ô���ĳ��������Ӧ����ô���ýڵ�ָ����һ�㣬Ȼ��
	 *	�ھ����е�ǰλ�ô������������ĸ�λ�ô�����һ���ڵ�ȥƥ�䣬�������ƥ�䵽��ֱ�ӷ�����һ��
	 *	���ƥ�䵽�Ľڵ��isWord����Ϊ�棬˵���ڵ��ʾ������ҵ�һ������
	 * @param board
	 * @param words
	 * @return
	 */
	public List<String> findWords(char[][] board, String[] words) {
    	if(words.length == 0)
    		return new ArrayList<String>(reSet);
    	
    	//����ǰ׺��
    	for (String string : words) {
			insert(string);
		}
    	int m = board.length;
    	int n = board[0].length;
    	
    	//������¼����Ԫ���Ƿ񱻷���
    	boolean[][] visited = new boolean[m][n];
    	
    	//��¼ǰ׺�����Ѿ��������Ľڵ�
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
		//��������е�ǰλ�ô����ַ����ڵ�ǰnode���б��У�����
		if(node.TrieNodes[ch-'a'] == null)
			return ;
		
		//����ڣ��Ѹ��ַ���ӵ�ջ�У�Ȼ����nodeָ����һ��
		sb.append(ch);
		node = node.TrieNodes[ch-'a'];
		
		//�����ǰ�ڵ��isWord����Ϊtrue��˵���Ѿ��ҵ���һ�����ʣ�����������ʱ���¼����sb�У���������set��
		if(node.isWord == true) {
			reSet.add(sb.toString());
		}
		
		//��ǰλ�ñ��Ϊ���ʣ�������λ�õ��ĸ��ڱ�λ�ã�
		visited[i][j] = true;
		dfs(board, node, visited, sb, i+1, j);
		dfs(board, node, visited, sb, i-1, j);
		dfs(board, node, visited, sb, i, j+1);
		dfs(board, node, visited, sb, i, j-1);
		visited[i][j] = false;
		sb.deleteCharAt(sb.length()-1);
	}
}

