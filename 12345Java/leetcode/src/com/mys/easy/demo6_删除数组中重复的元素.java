package com.mys.easy;

import java.util.Arrays;



public class demo6_ɾ���������ظ���Ԫ�� {

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
        		//�ӵ�i��Ԫ�ؿ�ʼ���������ҳ���һ��Ԫ�ص��ظ���Χ[i,j)
        		//nums[j]��ǰ��nums[i]~nums[j-1]����ͬ�����ֻ����һ��nums[i]����nums[i+1]~nums[j-1]ȫ���滻��nums[j]��
        		//��ʱ��nums[0]~nums[i]֮���Ԫ�ؿ϶�������ͬ�����i++,��������Ĳ���
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
    	int count=1;				//����ͳ����������Ԫ�صĸ���
    	int k=1;					//������¼���������������
    	//�������һ��Ԫ�ؿ�ʼ������
    	for (int i = 1; i < nums.length; i++) {
    		//�����i��Ԫ�غ͵�i-1��Ԫ�ز���ȣ���ô�ͽ��ڶ���Ԫ����ӵ���k��λ�ã�
			if(nums[i]!=nums[i-1]) {
				nums[k]=nums[i];
				count++;
				k++; 
			}
		}
        return count;
    }
}