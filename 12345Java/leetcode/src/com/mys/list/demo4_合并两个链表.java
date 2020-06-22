package com.mys.list;

public class demo4_�ϲ��������� {

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
	 * �ϲ�������������
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	//����һ��ͷָ�����������´���������
    	ListNode head = new ListNode(0);
    	//ָ��p����ָ��ǰ����������һ��Ԫ��
    	ListNode p = head;
    	
    	/**
    	 * ����������һ��������������
    	 * 	1.��������û�б�������
    	 * 	2.l1��������������l2��û�н���
    	 * 	3.l2��������������l1��û�н���
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