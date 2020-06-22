package com.mys.design;

import java.util.ArrayList;
import java.util.List;

public class demo6_杨辉三角 {

	public static void main(String[] args) {
		List<List<Integer>> list = Solution6.generate(5);
		System.out.println(list);
	}

}
class Solution6 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        //第一行只有一个1
        list1.add(1);
        //将第一行的list1加入到list中
        list.add(list1);
        //从第二行到第numRows行，循环加入每一行
        for (int i = 1; i < numRows; i++) {
        	//先获取上一行的数据
        	List<Integer> listfront = list.get(i-1);
        	//新建一个listi用来存储当前这一行的数据
			List<Integer> listi = new ArrayList<Integer>(i);
			//在当前这一行的listi中加入i+1个数据
			for (int j = 0; j <= i; j++) {
				//获取当前位置元素的上一行中左上角和右上角的元素的索引
				int prei = j;
				int prej = j-1;
				//分别判断索引的合法性以及取出合法索引处的元素
				//prej有可能是-1
				//prei有可能超过上一行的元素个数
				int x = prei < listfront.size() ? listfront.get(prei) : 0;
				int y = prej >=0 ? listfront.get(prej) : 0;
				listi.add(x+y);
			}
			list.add(listi);
		}
        return list;
    }
}