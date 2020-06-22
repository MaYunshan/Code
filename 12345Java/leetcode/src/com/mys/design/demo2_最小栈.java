package com.mys.design;

import java.util.ArrayList;

public class demo2_��Сջ {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		int min = minStack.getMin();   //--> ���� -3.
		minStack.pop();
		minStack.top();      //--> ���� 0.
		int min2 = minStack.getMin();   //--> ���� -2.
	}

}
class MinStack {
	//��¼stack�е�ǰ���һ��Ԫ�ص����������stackΪnull����ֵΪ-1
	private int index;
	//��һ����̬������ģ��ջ
	private ArrayList<Integer> stack = null;
	//��¼��Сֵ������
	private int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<Integer>();
        index = -1;
        min = 0;
    }
    
    /**
     * 	ÿ���һ��Ԫ�أ��ͽ���Сֵ����������
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
        	//���ɾ����Ԫ��ǡ������Сֵ����ô��Сֵ�������ͻᷢ���仯����������ı�
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