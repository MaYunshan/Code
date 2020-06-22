package com.mys.list;

public class ListDeal {
	
	/*
	 *	创建一个单链表 
	 */
	public static ListNode createListNode(int[] arrs) {
		ListNode head = null;
		ListNode pHead = head;
		for (int i = 0; i < arrs.length; i++) {
			if (head == null) {
				head = new ListNode(arrs[i]);
				pHead = head;
			}else {
				pHead.next = new ListNode(arrs[i]);
				pHead = pHead.next;
			}
			
		}
		return head;
	}
	
	/**
	 * 	打印单链表
	 * @param head
	 */
	public static void print(ListNode head) {
		ListNode p = head;
		while(p != null) {
			if(p.next == null) {
				System.out.println(p.val);
				return;
			}
			System.out.print(p.val+"->");
			p = p.next;
		}
	}
	
	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	public static ListNode reverse(ListNode head) {
		ListNode tail = null;
		ListNode p = head;
		while(p != null) {
			ListNode newNode =new ListNode(p.val);
			newNode.next = tail;
			tail = newNode;
			p = p.next;
		}
		return tail;
	}

}
