package com.mys.array;


/**
 * [0,0,0,0,1,1,1,1,1,1,1,1,1,1]
 * 	这道题的意思类似于在上面的数组中找到第一个1出现的位置
 * 	
 * @author dell
 *
 */
public class demo9_第一个错误的版本 {

	public static void main(String[] args) {
		int ret = Solution9.firstBadVersion(5);
		System.out.println(ret);
	}

}
class Solution9 {
	
	/**
	 * 迭代
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
	 *  递归
	 * @param n
	 * @return
	 */
    public static int firstBadVersion(int n) {
        return firstBad1(1,n);
    }
    
    /**
     * 采用二分查找
     * @return
     */
    private static int firstBad(int first,int last){
    	//当分割的长度小于10时，逐个寻找
       if(last - first <=10) {
    	   for (int i = first; i <= last; i++) {
    		   if(isBadVersion(i)){
                   return i;
               }
    	   }
       }
       //开始二分
       int mid = first + (last - first) / 2;
       //如果mid处还是1，搜寻前半部分
       if(isBadVersion(mid))
    	   return firstBad1(first, mid);
       //搜寻后半部分
       else
    	   return firstBad(mid+1, last);
    }
    
    /**
     * 真正的二分查找
     * @param first
     * @param last
     * @return
     */
    private static int firstBad1(int first,int last){
    	
    	//如果first和last相遇，
    	if(first == last) {
    		//如果当前元素是0 那么它的后一个元素肯定是1
    		/**
    		 *  比如执行到这里的结果是[3,3],那么上一步的结果只有一种
    		 *  	[first=2,mid=2,last=3] 其中mid为0 走firstBad1(mid+1, last)即[3,3]
    		 *  这时候判断mid，，如果mid是0，那么mid+1是第一个1
    		 *  			     如果mid是1，那么mid就是第一个1
    		 */
				return first;
    	}
       //开始二分
       int mid = first + (last - first) / 2;
       //如果mid处还是1，搜寻前半部分
       if(isBadVersion(mid))
    	   return firstBad1(first, mid);
       //搜寻后半部分
       else
    	   return firstBad1(mid+1, last);
    }
    
    
	private static boolean isBadVersion(int mid) {
		if(mid >= 1)
			return true;
		return false;
	}
}