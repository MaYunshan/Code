package com.mys.easy;

/**
 * 
 *	 ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
	��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
	ע���㲻���������Ʊǰ������Ʊ��
 *
 */
public class demo71_������Ʊ�����ʱ�� {

	public static void main(String[] args) {
		int[] arrs = {7,1,5,3,6,4};
		int profit = Solution71.maxProfit2(arrs);
		System.out.println(profit);
	}

}
class Solution71 {
	/**
	 * 	�����ⷨ
	 * 		�ֱ��Ը���Ԫ����Ϊ����㣬����Ѱ���۳��㼴��
	 * 		������forѭ����ʱ�临�Ӷ�O(n2)��
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
     * 	һ������ҵ����
     * 		˼����ǣ�һ��һ����ң��ҵ�һ����͵����ߵ��Ժ󣬾�����Ȼ������һ��Ĳ���бȽϣ���������������滻
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
        	 * 	��һ����϶�������ߵ㣬����Ƚ�������Ϊ��͵�
        	 * 	
        	 */
        	if(prices[i] < priceV) {
        		priceV = prices[i];
        	}
        	
        	/**
        	 * 	����͵�����Ԫ���У�����б��Ѿ���¼����͵��Ԫ�ػ�����ô����������ʱ���Ϊ��ߵ�
        	 */
        	else if (prices[i] > priceV) {
        		priveH = prices[i];
        		/**
        		 * 	���ҵ�����ߵ�����͵�Ĳ�����һ��Ĳ���бȽϣ����������������滻
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