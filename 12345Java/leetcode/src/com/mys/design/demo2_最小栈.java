package com.mys.design;

import java.util.ArrayList;

public class demo2_最小栈 {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		int min = minStack.getMin();   //--> 返回 -3.
		minStack.pop();
		minStack.top();      //--> 返回 0.
		int min2 = minStack.getMin();   //--> 返回 -2.
	}

}
class MinStack {
	//记录stack中当前最后一个元素的索引，如果stack为null，该值为-1
	private int index;
	//用一个动态数组来模拟栈
	private ArrayList<Integer> stack = null;
	//记录最小值的索引
	private int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<Integer>();
        index = -1;
        min = 0;
    }
    
    /**
     * 	每添加一个元素，就将最小值的索引更新
     * @param x
     */
    public void push(int x) {
        stack.add(x);
        index++;
        if(x < stack.get(min)) {
        	min = index;
        }
    }
    
    public void pop() {
        if(index != -1) {
        	int y = stack.get(min);
        	int x = stack.remove(index);
        	index--;
        	//如果删除的元素恰好是最小值，那么最小值得索引就会发生变化，否则，无需改变
        	if (x == y) {
        		min = 0;
        		for (int i = 1; i <= index; i++) {
        			if(stack.get(i) < stack.get(min))
        				min = i;
        		}
			}
        }
    }
    
    public int top() {
        return stack.get(index);
    }
    
    public int getMin() {
        return stack.get(min);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */