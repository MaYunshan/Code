package com.mys.array;

import java.util.Arrays;

public class demo3_加1 {

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
        digits[digits.length-1]+=1;						//首先记录个位加1后的结果
        for (int i = digits.length - 1; i >= 0; i--) {	//然后从后往前处理进位
        	sum=0;
			sum=digits[i]+count;						//将当前索引处的元素与进位相加
			count=0;									//加完以后进位归0
			digits[i]=sum%10;										
			count=sum/10;											
			if(count<1) {											//如果加完后的结果小于10，说明不需要再进行进位了
				return digits;											 	//当前加完后的结果大于9，则还需要向前进位
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