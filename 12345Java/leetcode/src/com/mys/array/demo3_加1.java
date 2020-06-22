package com.mys.array;

import java.util.Arrays;

public class demo3_��1 {

	public static void main(String[] args) {
		int[] arr1= {9,9,9,9};
		int[] arr2= {2,4,9,3,9};
		arr1=Solution3.plusOne1(arr1);
		arr2=Solution3.plusOne1(arr2);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

}
class Solution3 {
    public static int[] plusOne(int[] digits) {
        int count=0;
        int sum=0;
        digits[digits.length-1]+=1;						//���ȼ�¼��λ��1��Ľ��
        for (int i = digits.length - 1; i >= 0; i--) {	//Ȼ��Ӻ���ǰ�����λ
        	sum=0;
			sum=digits[i]+count;						//����ǰ��������Ԫ�����λ���
			count=0;									//�����Ժ��λ��0
			digits[i]=sum%10;										
			count=sum/10;											
			if(count<1) {											//��������Ľ��С��10��˵������Ҫ�ٽ��н�λ��
				return digits;											 	//��ǰ�����Ľ������9������Ҫ��ǰ��λ
			}
		}
    	int[] nums=new int[digits.length+1];
    	nums[0]=count;
    	for (int i = 0; i < digits.length; i++) {
			nums[i+1]=digits[i];
		}
    	return nums;
    }
    
    public static int[] plusOne1(int[] digits) {
        digits[digits.length-1]+=1;						
        for (int i = digits.length - 1; i > 0; i--) {
        	if (digits[i]==10) {
				digits[i]=0;
				digits[i-1]++;
			}
    		else {
        		return digits;
        	}
		}
        if(digits[0]==10) {
    		digits=new int[digits.length+1];
    		digits[0]=1;
    	}
    	return digits;
    }
}