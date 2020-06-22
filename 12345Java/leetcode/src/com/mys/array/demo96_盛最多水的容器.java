package com.mys.array;
/**
 * 	���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
 * 	�������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)���ҳ����е������ߣ�
 * 	ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 *
 */
public class demo96_ʢ���ˮ������ {

	public static void main(String[] args) {
		int[] nums = {1,8,6,2,5,4,8,3,7};
		int ret = Solution96.maxArea(nums);
		System.out.println(ret);
	}

}
class Solution96 {
	/**
	 * 	������ָ��i��j�ֱ�ָ�����������ߺ����ұߵ�����
	 * 		��ʼ�����������ݻ���V=(j-i)*min{height[i],height[j]}
	 * 		��Ϊ����������ݻ���height[i],height[j]�еĽ�С����������˽���С���������ƶ�һλ
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
    			//���x<y��x�����������ƶ�һλ
    			sum = Math.max(sum, x*(j-i));
    			i++;
    		}
    		else {
    			//���y<x,�е����������ƶ�һλ
				sum = Math.max(sum, y*(j-i));
				j--;
			}
    	}
        return sum;
    }
}