package com.mys.design;

import java.util.ArrayList;
import java.util.List;

public class demo6_������� {

	public static void main(String[] args) {
		List<List<Integer>> list = Solution6.generate(5);
		System.out.println(list);
	}

}
class Solution6 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        //��һ��ֻ��һ��1
        list1.add(1);
        //����һ�е�list1���뵽list��
        list.add(list1);
        //�ӵڶ��е���numRows�У�ѭ������ÿһ��
        for (int i = 1; i < numRows; i++) {
        	//�Ȼ�ȡ��һ�е�����
        	List<Integer> listfront = list.get(i-1);
        	//�½�һ��listi�����洢��ǰ��һ�е�����
			List<Integer> listi = new ArrayList<Integer>(i);
			//�ڵ�ǰ��һ�е�listi�м���i+1������
			for (int j = 0; j <= i; j++) {
				//��ȡ��ǰλ��Ԫ�ص���һ�������ϽǺ����Ͻǵ�Ԫ�ص�����
				int prei = j;
				int prej = j-1;
				//�ֱ��ж������ĺϷ����Լ�ȡ���Ϸ���������Ԫ��
				//prej�п�����-1
				//prei�п��ܳ�����һ�е�Ԫ�ظ���
				int x = prei < listfront.size() ? listfront.get(prei) : 0;
				int y = prej >=0 ? listfront.get(prej) : 0;
				listi.add(x+y);
			}
			list.add(listi);
		}
        return list;
    }
}