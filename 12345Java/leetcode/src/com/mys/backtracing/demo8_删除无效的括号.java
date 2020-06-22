package com.mys.backtracing;

/**
 * 	删除无效的括号
 * 		删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *		说明: 输入可能包含了除(和)以外的字符。
 *		示例 1:
 *			输入: "()())()"
 *			输出: ["()()()", "(())()"]
 *		示例 2:
 *			输入: "(a)())()"
 *			输出: ["(a)()()", "(a())()"]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class demo8_删除无效的括号 {

	public static void main(String[] args) {
		String str = "(()";
		Solution8 solution8 = new Solution8();
		int[] mis = solution8.misParenthesis(str);
		System.out.println(Arrays.toString(mis));
		
		List<String> list = solution8.removeInvalidParentheses(str);
		System.out.println(list);
	}

}

class Solution8 {
	/**
	 * 	字符串中左右括号各有m和n个，不合法的左右括号各有left和right个
	 * 	采用递归法删除不合法的括号时，其实就是在m个左括号中选择left个并且将其删除，在n个右括号中选择right个并且将其删除
	 * 	然后判断当不合法的左右括号的数量都被删除时，剩下的字符串是否是一个合法的字符串。
	 * 	
	 */
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<String>();
        //获取s中不合法的左右括号的各自的数量
        int[] mis = misParenthesis(s);
        dfs(s,list,0,mis[0],mis[1]);
        
        return list;
    }
    
    /**
     * 	遍历s的每一个字符，逐个删除不合法的括号，直到不合法的括号的个数为0，此时检查字符串中的括号是否合法，如果合法将其保存
     * @param s：		源字符串
     * @param list：		用来保存删除有限数量括号后依然合法的字符串
     * @param index：	当前递归层s的起始位置
     * @param left：		不合法左括号的数目
     * @param right：	不合法右括号的数目
     */
    private void dfs(String s, List<String> list, int index, int left, int right) {
    	if(left == 0 && right == 0) {
    		//如果已经删除了不合法的左右括号数目，对余下的字符串进行判断，如果合法则将其保存
    		int[] mis = misParenthesis(s);
    		if(mis[0] == 0 && mis[1] == 0) {
    			list.add(s);
    			System.out.println(123);
    			return ;
    		}
    	}
    	
    	for (int i = index; i < s.length(); i++) {
    		//去重，避免重复，当当前遍历的字符跟它前一个字符一样，那么就忽略这个字符
    		if(i - 1 >= index && s.charAt(i-1) == s.charAt(i))
    			continue;
    		
    		//如果当前位置是一个左括号并且不合法的左括号数目任然大于0，就将这个左括号删除
    		if(left > 0 && s.charAt(i) == '(') {
    			System.out.println(s.substring(0, i)+s.substring(i+1)+"abc");
    			dfs(s.substring(0, i)+s.substring(i+1), list, i, left-1, right);
    		}
    		
    		//如果当前位置是一个右括号并且不合法的左括号数目任然大于0，就将这个左括号删除
    		if(right > 0 && s.charAt(i) == ')') {
    			System.out.println(s.substring(0, i)+s.substring(i+1)+"cde");
    			dfs(s.substring(0, i)+s.substring(i+1), list, i, left, right-1);
    		}
		}
	}

	/**
     * 	判断某个字符串中不合法的左括号和右括号的个数
     */
    int[] misParenthesis(String str) {
    	//用来记录栈中有多少个左括号
    	int left = 0;
    	int right = 0;
    	for (int i = 0; i < str.length(); i++) {
    		//如果是左括号，left++，表示当前栈中多了一个左括号
			if(str.charAt(i) == '(')
				left++;
			
			/**
			 * 	如果是右括号，先判断当前栈中是否有左括号是否和它匹配，
			 * 		如果left<=0,说明当前栈中没有左括号，说明str中的括号是不合法的
			 * 		如果left>0，说明当前栈中还有左括号，则可以消去一对括号，栈中的左括号减少一个，即left--
			 */
			else if(str.charAt(i) == ')') {
				if(left <= 0)
					right++;
				else
					left--;
			}
		}
    	return new int[] {left,right};
    }
}
