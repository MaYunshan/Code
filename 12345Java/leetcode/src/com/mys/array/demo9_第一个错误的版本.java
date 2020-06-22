package com.mys.array;


/**
 * [0,0,0,0,1,1,1,1,1,1,1,1,1,1]
 * 	��������˼��������������������ҵ���һ��1���ֵ�λ��
 * 	
 * @author dell
 *
 */
public class demo9_��һ������İ汾 {

	public static void main(String[] args) {
		int ret = Solution9.firstBadVersion(5);
		System.out.println(ret);
	}

}
class Solution9 {
	
	/**
	 * ����
	 * @param n
	 * @return
	 */
	public static int firstBadVersion1(int n) {
        int first = 1;
        int last = n;
        
        while(first < last) {
        	int mid = first + (last - first) / 2;
        	if(isBadVersion(mid)) {
        		last = mid;
        	}
        	else {
        		first = mid + 1;
        	}
        }
        return first;
    }
	
	/**
	 *  �ݹ�
	 * @param n
	 * @return
	 */
    public static int firstBadVersion(int n) {
        return firstBad1(1,n);
    }
    
    /**
     * ���ö��ֲ���
     * @return
     */
    private static int firstBad(int first,int last){
    	//���ָ�ĳ���С��10ʱ�����Ѱ��
       if(last - first <=10) {
    	   for (int i = first; i <= last; i++) {
    		   if(isBadVersion(i)){
                   return i;
               }
    	   }
       }
       //��ʼ����
       int mid = first + (last - first) / 2;
       //���mid������1����Ѱǰ�벿��
       if(isBadVersion(mid))
    	   return firstBad1(first, mid);
       //��Ѱ��벿��
       else
    	   return firstBad(mid+1, last);
    }
    
    /**
     * �����Ķ��ֲ���
     * @param first
     * @param last
     * @return
     */
    private static int firstBad1(int first,int last){
    	
    	//���first��last������
    	if(first == last) {
    		//�����ǰԪ����0 ��ô���ĺ�һ��Ԫ�ؿ϶���1
    		/**
    		 *  ����ִ�е�����Ľ����[3,3],��ô��һ���Ľ��ֻ��һ��
    		 *  	[first=2,mid=2,last=3] ����midΪ0 ��firstBad1(mid+1, last)��[3,3]
    		 *  ��ʱ���ж�mid�������mid��0����ômid+1�ǵ�һ��1
    		 *  			     ���mid��1����ômid���ǵ�һ��1
    		 */
				return first;
    	}
       //��ʼ����
       int mid = first + (last - first) / 2;
       //���mid������1����Ѱǰ�벿��
       if(isBadVersion(mid))
    	   return firstBad1(first, mid);
       //��Ѱ��벿��
       else
    	   return firstBad1(mid+1, last);
    }
    
    
	private static boolean isBadVersion(int mid) {
		if(mid >= 1)
			return true;
		return false;
	}
}