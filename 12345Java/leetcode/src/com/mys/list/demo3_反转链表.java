package com.mys.list;


public class demo3_��ת���� {

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
	 * ��ת����
	 * �����������ָ�뽫����ֳ����Ρ�1<-2<-p1----[3]head----p2->4->5��
	 * headָ��ǰ���ָ�������Ԫ��
	 * p1ָ���Ѿ�����ĵ�һ��Ԫ��
	 * p2ָ��û������ĵ�һ��Ԫ��
	 */
    public static ListNode reverseList(ListNode head) {
    
    	ListNode p1 = null;
    	ListNode p2 = head;
    	int i = 0;
    	while(head != null) {
    		//��һ��ָ�뻻���Ѿ���ɣ���ʼ��һ�Σ���p2ָ����һ����û�л����Ԫ�أ�
    		p2 = head.next;
    		
    		//��head���л���
    		head.next = p1;
    		
    		//��p1ָ��ǰ�Ѿ���������һ��Ԫ��head
    		p1 =head;
    		
    		//headָ���Ԫ�صĻ����Ѿ���ɣ�headָ����һ��δ�����Ԫ��p2
    		head = p2;
    	}
    	return p1;
    }
    
    /**
     * �ݹ�ⷨ
     * 	1.�ҵ����һ���ڵ㣬�����һ���ڵ㷵�أ���Ϊ�������head�ڵ�
     * 	2.�ڵ����ڶ���ݹ飬headָ�����ڶ����ڵ㣬��ʱhead.next=���һ���ڵ㣬head.next.next=null
     * 		��head.next.next=head,�򽫵�����һ����nextָ��ָ���˵����ڶ���Ԫ�أ�
     * 		Ȼ��ԭ����ָ��Ͽ�����head.next=null;
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
     * ������ָ�뽫����ֳ�������
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