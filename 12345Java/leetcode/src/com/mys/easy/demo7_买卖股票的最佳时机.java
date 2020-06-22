package com.mys.easy;


public class demo7_买卖股票的最佳时机 {

	public static void main(String[] args) {
		int[] arrs= {2,1,4,5,2,9,7};
		System.out.println(Solution7.maxProfit1(arrs));
	}

}
class Solution7 {
	/*
	 * 	连续的两个波峰和波谷之间的距离肯定是买入点和售出点
	 * 	如果一直在连续增长，第一天（谷）和最后一天（峰）肯定是买入点和售出点，
	 * 	用三个指针
	 * 		一个指针用来遍历数组
	 * 		一个指针用来确认波谷
	 * 		一个指针用来确认波峰
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
     * 	从数组第s个位置开始
     */
    public static int  getMax(int[] nums,int s) {
    	
        if(s>nums.length) {		//递归结束条件
        	return 0;
        }
        int max=0;
        //最外层的循环记录的是从第s个位置开始寻找最大值
        for (int start = s; start < nums.length; start++) {
        	//profit记录的是从s个位置作为起始位置寻找得到的最大值
			int profit=0;
			//内层循环是以s位置的元素作为第一个，然后分别以剩下的元素作为第二个元素，开始寻找
			//整个过程应该是嵌套了n层循环，所以用递归的思路求解
			for (int i = start+1; i < nums.length; i++) {
				//profit记录的是前两个元素已经确定，然后开始搜寻得到的最大值
				int maxProfit=0;
				if(nums[start]<nums[i]) {
					maxProfit=maxProfit+getMax(nums, i+1)+nums[i]-nums[start];
					
					//每一次从递归出来，就会得到以nums[start],nums[i]分别为第一个，第二个元素的最大值maxProfit
					//如果这个值比以nums[start],nums[i-1]分别为第一个，第二个元素的最大值profit大，那么进行替换
					if(maxProfit>profit) {
						profit=maxProfit;
					}
				}
			}
			
			//从这里出来得到profit的是以nums[start]作为第一个元素得到的最大值，
			//如果这个值比以nums[start-1]作为第一个元素得到的最大值还要大，则进行替换
			if(profit>max) {
				max=profit;
			}
		}
        
        return max;
	}
}