package com.mys.list;


public class demo3_反转链表 {

	public static void main(String[] args) {
		int[] arrs = {4,5,1,9};
		ListNode head = ListDeal.createListNode(arrs);
		ListDeal.print(head);
		head = Solution3.reverseList1(head);
		ListDeal.print(head);
	}

}
class Solution3 {
	/**
	 * 反转链表
	 * 用两个额外的指针将链表分成三段【1<-2<-p1----[3]head----p2->4->5】
	 * head指向当前被分割下来的元素
	 * p1指向已经逆序的第一个元素
	 * p2指向还没有逆序的第一个元素
	 */
    public static ListNode reverseList(ListNode head) {
    
    	ListNode p1 = null;
    	ListNode p2 = head;
    	int i = 0;
    	while(head != null) {
    		//上一次指针换向已经完成，开始下一次，让p2指向下一个还没有换向的元素，
    		p2 = head.next;
    		
    		//将head进行换向
    		head.next = p1;
    		
    		//让p1指向当前已经换向的最后一个元素head
    		p1 =head;
    		
    		//head指向的元素的换向已经完成，head指向下一个未换向的元素p2
    		head = p2;
    	}
    	return p1;
    }
    
    /**
     * 递归解法
     * 	1.找到最后一个节点，将最后一个节点返回，作为新链表的head节点
     * 	2.在倒数第二层递归，head指向倒数第二个节点，此时head.next=最后一个节点，head.next.next=null
     * 		令head.next.next=head,则将倒数第一个的next指针指向了倒数第二个元素，
     * 		然后将原来的指针断开，即head.next=null;
     * 
     */
    public static ListNode reverseList1(ListNode head) {
    	
    	if(head == null || head.next == null) {
    		return head;
    	}
    	ListNode p1 = reverseList1(head.next);
    	head.next.next = head;
    	head.next = null;
    	return p1;
    }
    
    /**
     * 用三个指针将链表分成三部分
     */
    public static ListNode reverseList2(ListNode head) {
    	ListNode pre = null;
    	ListNode nex = head;
    	while(head!= null) {
    		nex = head.next;
    		head.next = pre;
    		pre = head;
    		head = nex;
    	}
        return pre;
    }
}