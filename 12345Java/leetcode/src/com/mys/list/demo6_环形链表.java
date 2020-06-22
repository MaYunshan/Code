package com.mys.list;

import java.util.HashSet;
import java.util.Set;

public class demo6_环形链表 {

	public static void main(String[] args) {

	}

}
class Solution6 {
	/**
	 * 让一个hashset保存每一个node，如果当前遍历到的node在set里面已经存在，说明有环
	 * @param head
	 * @return
	 */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null) {
        	if(set.contains(head)) {
        		return true;
        	}else {
        		set.add(head);
        	}
        	head = head.next;
        }
    	return false;
    }
    
    /**
     * 如果一个链表有环的话，那么这个链表里面是没有null的
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null) {
        	if(set.contains(head)) {
        		return true;
        	}else {
        		set.add(head);
        	}
        	head = head.next;
        }
    	return false;
    }
}