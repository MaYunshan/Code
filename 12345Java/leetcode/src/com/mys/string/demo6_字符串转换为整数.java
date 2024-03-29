package com.mys.string;

public class demo6_字符串转换为整数 {

	public static void main(String[] args) {
		String s1="  00000000000123456784225346453654ccccc";
		String s2="-91283472332";
		String s3="2147483648";
		String s4="dfgfdgsdg121";
		String s5="    -867546546363634252345243sf";
		System.out.println(Solution6.myAtoi(s3));
	}

}
class Solution6 {
    public static int myAtoi1(String str) {
        if(str==null||str.length()==0)
        	return 0;
        StringBuilder sb=new StringBuilder();
        if(str.charAt(0)=='+'||str.charAt(0)=='-'||Character.isDigit(str.charAt(0))){
        	sb.append(str.charAt(0));
        }
        else {
        	return 0;
        }
        int i=1;
        while(i<str.length()){
			if(!Character.isDigit(str.charAt(i))) {
				break;
			}
			sb.append(str.charAt(i));
			if (Long.valueOf(sb.toString())>Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if(Long.valueOf(sb.toString())<Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			i++;
		}
        if((sb.charAt(0)=='+' || sb.charAt(0)=='-') && i==1) {
        	return 0;
        }
        return Integer.valueOf(sb.toString());
    }
    
    public static int myAtoi(String str) {
    	//先剔除空格
    	str=str.trim();
        if(str==null||str.length()==0)
        	return 0;
        StringBuilder sb=new StringBuilder();
        
        //字符串开头只能是‘+’、‘-’或者是数字，排除这些外，全都不符合规则
        if(str.charAt(0)=='+' || str.charAt(0)=='-' || Character.isDigit(str.charAt(0))) {
        	sb.append(str.charAt(0));
        }
        else {
        	return 0;
        }
        int i=1;
        while(i<str.length()) {
        	//碰到非数字字符，直接返回
    	    if(!Character.isDigit(str.charAt(i))) {
    		    break;
    	    }
    	    sb.append(str.charAt(i));
    	    //因为int 的范围是-2147483648——2147483647，只要截取的长度超过8位，就有可能超过int的范围
    	    if(i>8) {
    		    if (Long.valueOf(sb.toString())>Integer.MAX_VALUE) {
				 	return Integer.MAX_VALUE;
	    	    }
	    	    if(Long.valueOf(sb.toString())<Integer.MIN_VALUE) {
				 	return Integer.MIN_VALUE;
	    	    }
    	    }
    	    i++;
        }
        //如果字符串只是"+"或者是"-"，返回0
        if((sb.charAt(0)=='+' || sb.charAt(0)=='-') && i==1) {
        	return 0;
        }
        return Integer.valueOf(sb.toString());
    }
    
   
}