package com.mys.list;

/**
 * 	给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 	请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 */
public class demo7_奇偶链表 {

	public static void main(String[] args) {
		int[] arrs1 = {1,2,3,4,5,6};
		int[] arrs2 = {2,1,3,5,6,4,7};
		
		ListNode head1 = ListDeal.createListNode(arrs1);
		ListNode head2 = ListDeal.createListNode(arrs2);
		
		 head1 = Solution7.oddEvenList1(head1);
		 head2 = Solution7.oddEvenList(head2);
		 
		 ListDeal.print(head1);
		 ListDeal.print(head2);
	}

}
class Solution7 {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
        	return head;
        int i = 1;
        ListNode pHead = head;						//pHead后面的元素都是需要移动的，pHead位置处的元素是移动好的
        ListNode pTemp = null;						//一直指向pHead后面的第一个元素
        ListNode pNow = null;						//一直指向pNode的上一个元素
        ListNode pNode = null;						//一直指向第一个需要移动的元素
        while(pHead != null) {
        	pTemp = pHead.next;
        	pNow = pHead;
        	for (int j = 0; j < i; j++) {
				if(pNow != null)
					pNow = pNow.next;
				else {
					break;
				}
			}
        	if(pNow != null && pNow.next != null) {
        		
        		/**
        		 * 程序执行到此处，满足这样一个关系
        		 * 1 -> 3 -> 2 -> 4 -> 5
        		 * 	其中pHead指向3
        		 * 	pTemp指向pHead.next为2
        		 * 	pNow指向(pHead+i)为4
        		 * 	pNode指向pNow.next为5
        		 */
        		
        		pNode = pNow.next;
        		
        		pNow.next = pNode.next;
        		pHead.next = pNode;
        		pNode.next = pTemp;
        	}
        	
        	pHead = pHead.next;
        	i++;
        }
    	return head;
    }

	
    public static ListNode oddEvenList1(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
        	return head;
        int i = 1;
        ListNode pHead = head;						//pHead后面的元素都是需要移动的，pHead位置处的元素是移动好的
        ListNode pTemp = pHead.next;				//一直指向pHead后面的第一个元素
        ListNode pNow = pTemp;						//一直指向pNode的上一个元素
        ListNode pNode = pNow.next;					//一直指向第一个需要移动的元素
        while(pHead != null) {
    		
    		pNow.next = pNode.next;
    		pHead.next = pNode;
    		pNode.next = pTemp;
        	
    		if(pNow.next != null && pNow.next.next != null)
    		{
    			pNow = pNow.next;
    			pNode = pNow.next;
    			pHead = pHead.next;
    		}else {
				break;
			}
        }  	
    	return head;
    }
    
}