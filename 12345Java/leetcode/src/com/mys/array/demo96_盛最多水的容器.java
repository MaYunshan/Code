package com.mys.array;
/**
 * 	给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 	在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 	使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 */
public class demo96_盛最多水的容器 {

	public static void main(String[] args) {
		int[] nums = {1,8,6,2,5,4,8,3,7};
		int ret = Solution96.maxArea(nums);
		System.out.println(ret);
	}

}
class Solution96 {
	/**
	 * 	让两个指针i和j分别指向数组的最左边和最右边的索引
	 * 		开始计算容器的容积，V=(j-i)*min{height[i],height[j]}
	 * 		因为容器的最大容积由height[i],height[j]中的较小数决定，因此将较小数的索引移动一位
	 * @param height
	 * @return
	 */
    public static int maxArea(int[] height) {
    	int i = 0;
    	int j = height.length-1;
    	int sum = 0;
    	while(i < j) {
    		int x = height[i];
    		int y = height[j];
    		if(x < y) {
    			//如果x<y，x的索引往右移动一位
    			sum = Math.max(sum, x*(j-i));
    			i++;
    		}
    		else {
    			//如果y<x,有的索引往左移动一位
				sum = Math.max(sum, y*(j-i));
				j--;
			}
    	}
        return sum;
    }
}