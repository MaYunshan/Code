package com.mys.list;


public class demo1_删除链表中的节点 {

	public static void main(String[] args) {
		int[] arrs = {4,5,1,9};
		ListNode head = ListDeal.createListNode(arrs);
		ListDeal.print(head);
		Solution1.deleteNode(head, new ListNode(4));
		ListDeal.print(head);
	}
	
	
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
	    public static void deleteNode(ListNode head ,ListNode node) {
	    	ListNode p1 = head;
	    	ListNode p2 = head;
	    	while(p1 != null){
	       
	    		if(p1.val == node.val){
		              if(p1 == p2){
		                  head = head.next;
		                  return;
		              }
		              else if(p1.next == null){
		                  p2.next = null;
		                  return;
		              }
		              else {
		            	  p2.next = p1.next;
		              }
		          }
		          p2 = p1;
		          p1 = p1.next;
		     }
	    }
}

