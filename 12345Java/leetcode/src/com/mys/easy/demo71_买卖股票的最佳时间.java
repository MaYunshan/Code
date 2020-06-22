package com.mys.easy;

/**
 * 
 *	 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
	如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
	注意你不能在买入股票前卖出股票。
 *
 */
public class demo71_买卖股票的最佳时间 {

	public static void main(String[] args) {
		int[] arrs = {7,1,5,3,6,4};
		int profit = Solution71.maxProfit2(arrs);
		System.out.println(profit);
	}

}
class Solution71 {
	/**
	 * 	暴力解法
	 * 		分别以各个元素作为买入点，往后寻找售出点即可
	 * 		【两层for循环，时间复杂度O(n2)】
	 * @param prices
	 * @return
	 */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if(prices[j] - prices[i] > profit) {
					profit = prices[j] - prices[i];
				}
			}
		}
        return profit;
    }
    
    public static int maxProfit2(int[] prices) {
        int profit = 0;
        int priceV = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
			if(prices[i] < priceV) {
				priceV = prices[i];
			}
			else {
				profit = profit > (prices[i] - priceV)  ? profit : (prices[i] - priceV);
			}
		}
        return profit;
    }
    
    /**
     * 	一遍遍历找到结果
     * 		思想就是，一组一组的找，找到一组最低点和最高点以后，就做差然后与上一组的差进行比较，如果差更大，则进行替换
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        int i = 0;
        int priceV = Integer.MAX_VALUE;
        int priveH = -1;
        while(i < prices.length) {
        	/**
        	 * 	第一个点肯定不是最高点，因此先将它假设为最低点
        	 * 	
        	 */
        	if(prices[i] < priceV) {
        		priceV = prices[i];
        	}
        	
        	/**
        	 * 	在最低点后面的元素中，如果有比已经记录的最低点的元素还大，那么这个点可以暂时标记为最高点
        	 */
        	else if (prices[i] > priceV) {
        		priveH = prices[i];
        		/**
        		 * 	将找到的最高点与最低点的差与上一组的差进行比较，如果差距更大，则进行替换
        		 */
				if(priveH - priceV > profit) {
	        		profit = priveH - priceV;
	        	}
			}
        	i++;
        }
        return profit;
    }
    
//    private static int getMax() {
//		
//	}
}