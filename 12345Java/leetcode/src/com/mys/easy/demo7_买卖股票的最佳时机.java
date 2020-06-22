package com.mys.easy;


public class demo7_������Ʊ�����ʱ�� {

	public static void main(String[] args) {
		int[] arrs= {2,1,4,5,2,9,7};
		System.out.println(Solution7.maxProfit1(arrs));
	}

}
class Solution7 {
	/*
	 * 	��������������Ͳ���֮��ľ���϶����������۳���
	 * 	���һֱ��������������һ�죨�ȣ������һ�죨�壩�϶����������۳��㣬
	 * 	������ָ��
	 * 		һ��ָ��������������
	 * 		һ��ָ������ȷ�ϲ���
	 * 		һ��ָ������ȷ�ϲ���
	 */
	public static int maxProfit1(int[] prices) {
		int i=0;
		int max=0;
		int v=0;
		int h=0;
		while(i<prices.length-1) {
			while(i<prices.length-1 && prices[i]>=prices[i+1]) {
				i++;
			}
			v=prices[i];
			while(i<prices.length-1 && prices[i]<=prices[i+1]) {
				i++;
			}
			h=prices[i];
			
			max=max+h-v;
		}
		return max;
	}
    public static int maxProfit(int[] prices) {
    	return getMax(prices, 0);
    }
    
    /*
     * 	�������s��λ�ÿ�ʼ
     */
    public static int  getMax(int[] nums,int s) {
    	
        if(s>nums.length) {		//�ݹ��������
        	return 0;
        }
        int max=0;
        //������ѭ����¼���Ǵӵ�s��λ�ÿ�ʼѰ�����ֵ
        for (int start = s; start < nums.length; start++) {
        	//profit��¼���Ǵ�s��λ����Ϊ��ʼλ��Ѱ�ҵõ������ֵ
			int profit=0;
			//�ڲ�ѭ������sλ�õ�Ԫ����Ϊ��һ����Ȼ��ֱ���ʣ�µ�Ԫ����Ϊ�ڶ���Ԫ�أ���ʼѰ��
			//��������Ӧ����Ƕ����n��ѭ���������õݹ��˼·���
			for (int i = start+1; i < nums.length; i++) {
				//profit��¼����ǰ����Ԫ���Ѿ�ȷ����Ȼ��ʼ��Ѱ�õ������ֵ
				int maxProfit=0;
				if(nums[start]<nums[i]) {
					maxProfit=maxProfit+getMax(nums, i+1)+nums[i]-nums[start];
					
					//ÿһ�δӵݹ�������ͻ�õ���nums[start],nums[i]�ֱ�Ϊ��һ�����ڶ���Ԫ�ص����ֵmaxProfit
					//������ֵ����nums[start],nums[i-1]�ֱ�Ϊ��һ�����ڶ���Ԫ�ص����ֵprofit����ô�����滻
					if(maxProfit>profit) {
						profit=maxProfit;
					}
				}
			}
			
			//����������õ�profit������nums[start]��Ϊ��һ��Ԫ�صõ������ֵ��
			//������ֵ����nums[start-1]��Ϊ��һ��Ԫ�صõ������ֵ��Ҫ��������滻
			if(profit>max) {
				max=profit;
			}
		}
        
        return max;
	}
}