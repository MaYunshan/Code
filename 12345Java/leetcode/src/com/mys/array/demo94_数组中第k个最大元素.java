package com.mys.array;

public class demo94_�����е�k�����Ԫ�� {

	public static void main(String[] args) {
		int[] nums = {1,2};
		int ret = Solution94.findPeakElement1(nums);
		System.out.println(ret);
	}

}
class Solution94 {
    public static int findPeakElement(int[] nums) {
        int min = Integer.MIN_VALUE;
        //����ƴ��һ�����飬��0��Ԫ��ΪMin�����һ��Ԫ��Ҳ��min���м��Ԫ����nums
        int[] arrs = new int[nums.length+2];
        arrs[0] = min;
        arrs[arrs.length-1] = min;
        for(int i = 0; i < nums.length; i++){
            arrs[i+1] = nums[i];
        }
        
        for(int i = 1; i < arrs.length-1; i++){
            if(arrs[i] > arrs[i-1] && arrs[i] > arrs[i+1])
                return i-1;
        }
        return 0;
    }
    
    public static int findPeakElement1(int[] nums) {
        if(nums.length == 1)
            return 0;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i-1 < 0){
                if(nums[i] > min && nums[i] > nums[i+1])
                    return i;
            }
            else if(i+1 >= nums.length){
                if(nums[i] > nums[i-1] && nums[i] > min)
                    return i;
            }
            else{
                if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                    return i;
            }
        }
        return 0;
    }
}