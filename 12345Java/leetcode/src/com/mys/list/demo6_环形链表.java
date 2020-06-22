package com.mys.list;

import java.util.HashSet;
import java.util.Set;

public class demo6_�������� {

	public static void main(String[] args) {

	}

}
class Solution6 {
	/**
	 * ��һ��hashset����ÿһ��node�������ǰ��������node��set�����Ѿ����ڣ�˵���л�
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
     * ���һ�������л��Ļ�����ô�������������û��null��
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