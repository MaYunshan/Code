package com.mys.list;

public class demo5_回文链表 {

	public static void main(String[] args) {
		int[] arrs = {4,5,5,4};
		int[] arrs2 = {1};
		int[] arrs3 = {4,5,1,5,4};
		int[] arrs4 = {4,5,1,5};
		ListNode head = ListDeal.createListNode(arrs2);
		
		System.out.println(Solution5.isPalindrome1(head));
	}

}
class Solution5 {
	/**
	 * 回文链表
	 * 将链表反转，然后和原来的链表进行比较，如果是回文链表，则这两个链表是相同的，如果不是，则不是
	 */
    public static boolean isPalindrome(ListNode head) {
    	ListNode last = ListDeal.reverse(head);
    	while(last != null) {
    		if (head.val != last.val) {
				return false;
			}
    		head = head.next;
    		last = last.next;
    	}
    	return true;
    }
    
    /**
     *	先利用快慢指针找到链表的中点
     *	然后将后半部分链表逆序
     *	让两个指针分别指向第一个节点和中间节点，然后比较 
     */
    public static boolean isPalindrome1(ListNode head) {
    	if(head == null || head.next == null)
    		return true;
    	ListNode pslow = head;
    	ListNode pfast = head;
    	while(pfast.next != null && pfast.next.next != null) {
    		pfast = pfast.next.next;
    		pslow = pslow.next;
    	}
    	//循环从这里出来，pslow指向(n+1)/2的位置
    	//然后将pslow以后的元素方向
    	ListNode last = reverseList(pslow.next);
    	ListNode first = head;
    	//开始循环比较last和first的重复性
    	while(last != null) {
    		if(first.val != last.val) {
    			return false;
    		}
    		first = first.next;
    		last = last.next;
    	}
    	return true;
    }
    
    
	public static ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}
    	ListNode p1 = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	return p1;
    }
}