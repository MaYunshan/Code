package com.mys.list;

public class demo2_删除倒数第n个元素 {

	public static void main(String[] args) {
		int[] arrs = {1,2};
		ListNode head = ListDeal.createListNode(arrs);
		ListDeal.print(head);
		head = Solution2.removeNthFromEnd(head, 1);
		ListDeal.print(head);
	}

}
class Solution2 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode pParent = head;
        int size = 0;
        
        //先遍历一遍链表，得到链表节点个数
        while(p != null){
            size ++;
            p = p.next;
        }
        int i = 0;
        p = head;
        
        //找到要删除的节点
        while(i < size - n){
        	pParent = p;
            p = p.next;
            i ++;
        }
        
        //如果p.next为空，那么说明p是最后一个节点
        if(p.next == null) {
        	//只有一个节点的情况
        	if(head == p) {
        		head = null;
        	}
        	//是最后一个节点，找到它的前一个节点，删除最后一个节点
        	else {
				pParent.next = null;
			}
        }
        else {
        	p.val = p.next.val;
        	p.next = p.next.next;
		}
        return head;
    }
}