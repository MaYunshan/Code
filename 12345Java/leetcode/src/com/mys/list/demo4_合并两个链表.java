package com.mys.list;

public class demo4_合并两个链表 {

	public static void main(String[] args) {
		int[] arrs1 = {1,5,8,14,21};
		int[] arrs2 = {1,2,7,9,15,22,26,67};
		ListNode head1 = ListDeal.createListNode(arrs1);
		ListNode head2 = ListDeal.createListNode(arrs2);
		ListDeal.print(head1);
		ListDeal.print(head2);
		ListNode head = Solution4.mergeTwoLists(head1, head2);
		ListDeal.print(head);
	}

}
class Solution4 {
	/**
	 * 合并两个有序链表
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	//创建一个头指针用来返回新创建的链表
    	ListNode head = new ListNode(0);
    	//指针p用来指向当前新链表的最后一个元素
    	ListNode p = head;
    	
    	/**
    	 * 遍历过程中一共会出现三种情况
    	 * 	1.两个链表都没有遍历结束
    	 * 	2.l1遍历结束，但是l2还没有结束
    	 * 	3.l2遍历结束，但是l1还没有结束
    	 */
        while(l1 != null && l2 != null) {
        	ListNode newNode = new ListNode(0);
        	if(l1.val <= l2.val) {
        		newNode.val = l1.val;
        		l1 = l1.next;
        	}
        	else {
        		newNode.val = l2.val;
        		l2 = l2.next;
			}
        	p.next = newNode;
        	p = p.next;
        }
        while(l1 != null) {
        	ListNode newNode = new ListNode(l1.val);
        	p.next = newNode;
        	p = p.next;
        	l1 = l1.next;
        }
        while(l2 != null) {
        	ListNode newNode = new ListNode(l2.val);
        	p.next = newNode;
        	p = p.next;
        	l2 = l2.next;
        }
        head = head.next;
    	return head;
    }
}