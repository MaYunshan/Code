package com.mys.list;

public class demo5_�������� {

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
	 * ��������
	 * ������ת��Ȼ���ԭ����������бȽϣ�����ǻ�����������������������ͬ�ģ�������ǣ�����
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
     *	�����ÿ���ָ���ҵ�������е�
     *	Ȼ�󽫺�벿����������
     *	������ָ��ֱ�ָ���һ���ڵ���м�ڵ㣬Ȼ��Ƚ� 
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
    	//ѭ�������������pslowָ��(n+1)/2��λ��
    	//Ȼ��pslow�Ժ��Ԫ�ط���
    	ListNode last = reverseList(pslow.next);
    	ListNode first = head;
    	//��ʼѭ���Ƚ�last��first���ظ���
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