package com.mys.easy;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.jdi.Value;


public class demo3_两数之和链表 {

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
        int sum;						//和
        int add=0;						//进位
        while(p1!=null || p2!=null){
        	sum=0;						//每加完一位，和归0
        	if(p1!=null) {				//判断p1当前指向的节点是否为null，如果为null，说明l1已经遍历结束
        		sum=sum+p1.val;
        		p1=p1.next;
        	}
        	if(p2!=null) {				//判断p2当前指向的节点是否为null，如果为null，说明l2已经遍历结束
        		sum=sum+p2.val;
        		p2=p2.next;
        	}
        	sum=sum+add;
        	add=sum/10;
        	pList.val=sum%10;			//将得到的结果模10以后保存在当前节点
        	/*
        	 * 是否需要创建新的节点有三种情况
        	 * 1. l1已经遍历结束，但是l2还没有结束，此时需要创建新节点
        	 * 2. l2已经遍历结束，但是l1还没有结束，此时也需要创建节点
        	 * 3. l1和l2都遍历结束了，但是l1和l2的最后一位相加有进位，此时也需要再创建一个节点保存最后一位相加的进位
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
 *  定义的链表节点
 *  
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}