package com.mys.list;

import java.util.HashMap;
import java.util.Map;

public class demo8_�ཻ���� {

	public static void main(String[] args) {
		ListNode headA = new ListNode(4);
		ListNode headA1 = new ListNode(1);
		ListNode headA2 = new ListNode(8);
		ListNode headA3 = new ListNode(4);
		ListNode headA4 = new ListNode(5);
		headA.next = headA1;
		headA1.next = headA2;
		headA2.next = headA3;
		headA3.next = headA4;
		
		ListNode headB = new ListNode(5);
		ListNode headB1 = new ListNode(0);
		ListNode headB2 = new ListNode(1);
		headB.next = headB1;
		headB1.next = headB2;
		headB2.next = headA2;
		
		ListDeal.print(headA);
		ListDeal.print(headB);
		
		ListNode node = Solution8.getIntersectionNode1(headA, headB);
		ListDeal.print(node);
		
	}

}
class Solution8 {
	/**
	 * 	�ⷨ1�������ⷨ
	 * 		������B��ÿһ���ڵ�Ϊ��׼������A����Ѱ�Ҵ˽ڵ�
	 * 		ʱ�临�Ӷ�ΪO(mn)
	 * @param headA
	 * @param headB
	 * @return
	 */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        	return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        //��B��ÿһ���ڵ�pBΪ׼��ѭ������A�����A��ĳ���ڵ����pB����ô˵�������ཻ
        while(pB != null) {
        	pA = headA;
        	while(pA != null) {
        		if(pA == pB)
        			return pB;
        		else {
					pA = pA.next;
				}
        	}
        	pB = pB.next;
        }
        return null;
    }
    
    /**
     * 	��pAָ������A��ͷ������hashMap��¼ÿһ���������Ľڵ�
     * 	�ú���pBָ������B��ͷ��������hashMap
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        	return null;
        
        //��pAָ������A��ͷ��
        ListNode pA = headA;
        ListNode pB = headB;
        Map<ListNode, Boolean> map = new HashMap<ListNode, Boolean>();
        while(pA != null) {
        	map.put(pA, true);
        	pA = pA.next;
        }
        while(pB != null) {
        	if(map.get(pB) != null)
        		return pB;
        	pB = pB.next;
        }
        
        return null;
    }
    
    /**
     * 	�ⷨ3����B�����β��ָ��ͷ��������һ������Ȼ���ÿ���ָ��Ѱ��A�е�һ���ظ�Ԫ��
     */
    
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }
}