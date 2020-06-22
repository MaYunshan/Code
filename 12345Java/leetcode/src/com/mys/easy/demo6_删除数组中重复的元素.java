package com.mys.easy;

import java.util.Arrays;



public class demo6_删除数组中重复的元素 {

	public static void main(String[] args) {
		int[] nums= {0,0,1,1,2,2,3,4};
		int n=Solution6.removeDuplicates1(nums);
		System.out.println(n);
		System.out.println(Arrays.toString(nums));
	}

}
class Solution6 {
    public static int removeDuplicates(int[] nums) {
    	int i=0;
    	int count=1;
    	int k=0;
        while(i<nums.length) {
        	k=i+1;
        	for (int j = i+1; j < nums.length; j++) {
        		//从第i个元素开始遍历，先找出第一个元素的重复范围[i,j)
        		//nums[j]与前面nums[i]~nums[j-1]不相同，因此只留下一个nums[i]，将nums[i+1]~nums[j-1]全部替换成nums[j]，
        		//这时候nums[0]~nums[i]之间的元素肯定互不相同，因此i++,继续上面的步骤
				if(nums[j]!=nums[i]) {
					
					for(int n=k; n<j ;n++) {
						nums[n]=nums[j];
					}
					
					count++;
					break;
				}
			}
        	i++;
        }
        return count;
    }
    
    public static int removeDuplicates1(int[] nums) {
    	int count=1;				//用来统计新数组中元素的个数
    	int k=1;					//用来记录插入新数组的索引
    	//从数组第一个元素开始遍历，
    	for (int i = 1; i < nums.length; i++) {
    		//如果第i个元素和第i-1个元素不相等，那么就将第二个元素添加到第k个位置，
			if(nums[i]!=nums[i-1]) {
				nums[k]=nums[i];
				count++;
				k++; 
			}
		}
        return count;
    }
}