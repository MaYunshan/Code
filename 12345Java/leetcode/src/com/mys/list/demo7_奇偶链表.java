package com.mys.list;

/**
 * 	����һ�������������е������ڵ��ż���ڵ�ֱ�����һ��
 * 	��ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�
 *
 */
public class demo7_��ż���� {

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
        ListNode pHead = head;						//pHead�����Ԫ�ض�����Ҫ�ƶ��ģ�pHeadλ�ô���Ԫ�����ƶ��õ�
        ListNode pTemp = null;						//һֱָ��pHead����ĵ�һ��Ԫ��
        ListNode pNow = null;						//һֱָ��pNode����һ��Ԫ��
        ListNode pNode = null;						//һֱָ���һ����Ҫ�ƶ���Ԫ��
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
        		 * ����ִ�е��˴�����������һ����ϵ
        		 * 1 -> 3 -> 2 -> 4 -> 5
        		 * 	����pHeadָ��3
        		 * 	pTempָ��pHead.nextΪ2
        		 * 	pNowָ��(pHead+i)Ϊ4
        		 * 	pNodeָ��pNow.nextΪ5
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
        ListNode pHead = head;						//pHead�����Ԫ�ض�����Ҫ�ƶ��ģ�pHeadλ�ô���Ԫ�����ƶ��õ�
        ListNode pTemp = pHead.next;				//һֱָ��pHead����ĵ�һ��Ԫ��
        ListNode pNow = pTemp;						//һֱָ��pNode����һ��Ԫ��
        ListNode pNode = pNow.next;					//һֱָ���һ����Ҫ�ƶ���Ԫ��
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