package com.mys.easy;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.jdi.Value;


public class demo3_����֮������ {

	public static void main(String[] args) {
		int a=0;
		int b=0;
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		
		ListNode l1=add(a);
		ListNode l2=add(b);
		
		int[] arr1=print(l1);
		int[] arr2=print(l2);
		
		int[] sum=print(addTwoNumbers(l1, l2));

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(sum));
	}

	private static int[] print(ListNode l) {
		if(l==null) {
			return null;
		}
		ListNode pNode=l;
		int n=0;
		while(pNode!=null) {
			n++;
			pNode=pNode.next;
		}
		int[] arr=new int[n];
		pNode=l;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=pNode.val;
			pNode=pNode.next;
		}
		return arr;
	}

	private static ListNode add(int n) {
		ListNode list=null;
		StringBuffer str=new StringBuffer(Integer.toString(n));
		str.reverse();
		for	(int i = 0; i < str.length(); i++) {
			ListNode node=new ListNode(Integer.parseInt(String.valueOf(str.charAt(i))));
			if(list==null) {
				list=node;
			}
			else {
				ListNode p=list;
				while(p.next!=null) {
					p=p.next;
				}
				p.next=node;
			}
		}
		return list;
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list=new ListNode(0);
        ListNode pList=list;
        ListNode p1=l1;
        ListNode p2=l2;
        int sum;						//��
        int add=0;						//��λ
        while(p1!=null || p2!=null){
        	sum=0;						//ÿ����һλ���͹�0
        	if(p1!=null) {				//�ж�p1��ǰָ��Ľڵ��Ƿ�Ϊnull�����Ϊnull��˵��l1�Ѿ���������
        		sum=sum+p1.val;
        		p1=p1.next;
        	}
        	if(p2!=null) {				//�ж�p2��ǰָ��Ľڵ��Ƿ�Ϊnull�����Ϊnull��˵��l2�Ѿ���������
        		sum=sum+p2.val;
        		p2=p2.next;
        	}
        	sum=sum+add;
        	add=sum/10;
        	pList.val=sum%10;			//���õ��Ľ��ģ10�Ժ󱣴��ڵ�ǰ�ڵ�
        	/*
        	 * �Ƿ���Ҫ�����µĽڵ����������
        	 * 1. l1�Ѿ���������������l2��û�н�������ʱ��Ҫ�����½ڵ�
        	 * 2. l2�Ѿ���������������l1��û�н�������ʱҲ��Ҫ�����ڵ�
        	 * 3. l1��l2�����������ˣ�����l1��l2�����һλ����н�λ����ʱҲ��Ҫ�ٴ���һ���ڵ㱣�����һλ��ӵĽ�λ
        	 */
        	if(p1!=null||p2!=null||(add>0)) {
        		pList.next=new ListNode(add);
        		pList=pList.next;
        	}
        }
        return list;
    }
}



/**
 *  ���������ڵ�
 *  
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}