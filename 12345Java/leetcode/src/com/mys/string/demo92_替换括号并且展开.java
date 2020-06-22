package com.mys.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo92_替换括号并且展开 {

	public static void main(String[] args) {
		//找到所有的空格用空格代替
		//demo1();
		
		//
		String str2 = "df5[4(ABC)]qwer4{2[2(CD)]}";
		Pattern pattern1 = Pattern.compile("\\d+\\([A-Za-z0-9]+\\)");
		Pattern pattern2 = Pattern.compile("\\d+\\[[A-Za-z0-9]+\\]");
		Pattern pattern3 = Pattern.compile("\\d+\\{[A-Za-z0-9]+\\}");
		
		int count = 0;
		str2 = replace(str2, pattern1);
		str2 = replace(str2, pattern2);
		str2 = replace(str2, pattern3);
		System.out.println("===============================================");
		System.out.println(str2);
	    
	}

	private static String replace(String str2, Pattern pattern) {
		//在给定字符串中匹配正则表达式，如果还有，继续进行替换
		while(pattern.matcher(str2).find()) {
			//拿到匹配器
			Matcher matcher = pattern.matcher(str2);
			//如果还能匹配到
			if(matcher.find()) {
				//把第一个符合字符串截取出来
		    	String string = str2.substring(matcher.start(), matcher.end());
		    	System.out.println(string);
		    	//用来重复括号里面的内容
		    	StringBuffer sBuffer = new StringBuffer();
		    	//用来读取前面的数字
		    	StringBuffer sInt = new StringBuffer();
		    	int i = 0;
		    	
		    	//for循环用来提取string里开头的数字
		    	for (; i < string.length(); i++) {
		    		char ch = string.charAt(i);
					if (!Character.isDigit(ch)) {
						break;
					}
					sInt.append(ch);
				}
		    	
		    	//for循环用来将括号里面的内容进行重复
		    	for (int j = 0; j < Integer.valueOf(sInt.toString()); j++) {
					sBuffer.append(string, i + 1, string.length() - 1);
				}
		    	System.out.println(sBuffer);
		    	//将原来字符串第一个正则字符串出现的位置用新字符串替代
		    	str2 = str2.replaceFirst(pattern.toString(),sBuffer.toString());
		    	System.out.println(str2);
		    }
		}
		return str2;
	}

	private static void demo1() {
		String str = "fdgd{1233fsfksf}fg[sdg]dsfgggd(gdgfdg)g";
		str = str.replaceAll("[(\\{)|(\\})|(\\[)|(\\])|(||()||(\\))]", "");
		System.out.println(str);
	}

}
