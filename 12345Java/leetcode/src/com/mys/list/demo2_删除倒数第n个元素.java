package com.mys.list;

public class demo2_ɾ��������n��Ԫ�� {

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
        
        //�ȱ���һ�������õ�����ڵ����
        while(p != null){
            size ++;
            p = p.next;
        }
        int i = 0;
        p = head;
        
        //�ҵ�Ҫɾ���Ľڵ�
        while(i < size - n){
        	pParent = p;
            p = p.next;
            i ++;
        }
        
        //���p.nextΪ�գ���ô˵��p�����һ���ڵ�
        if(p.next == null) {
        	//ֻ��һ���ڵ�����
        	if(head == p) {
        		head = null;
        	}
        	//�����һ���ڵ㣬�ҵ�����ǰһ���ڵ㣬ɾ�����һ���ڵ�
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