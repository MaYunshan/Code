package com.mys.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo92_�滻���Ų���չ�� {

	public static void main(String[] args) {
		//�ҵ����еĿո��ÿո����
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
		//�ڸ����ַ�����ƥ��������ʽ��������У����������滻
		while(pattern.matcher(str2).find()) {
			//�õ�ƥ����
			Matcher matcher = pattern.matcher(str2);
			//�������ƥ�䵽
			if(matcher.find()) {
				//�ѵ�һ�������ַ�����ȡ����
		    	String string = str2.substring(matcher.start(), matcher.end());
		    	System.out.println(string);
		    	//�����ظ��������������
		    	StringBuffer sBuffer = new StringBuffer();
		    	//������ȡǰ�������
		    	StringBuffer sInt = new StringBuffer();
		    	int i = 0;
		    	
		    	//forѭ��������ȡstring�￪ͷ������
		    	for (; i < string.length(); i++) {
		    		char ch = string.charAt(i);
					if (!Character.isDigit(ch)) {
						break;
					}
					sInt.append(ch);
				}
		    	
		    	//forѭ��������������������ݽ����ظ�
		    	for (int j = 0; j < Integer.valueOf(sInt.toString()); j++) {
					sBuffer.append(string, i + 1, string.length() - 1);
				}
		    	System.out.println(sBuffer);
		    	//��ԭ���ַ�����һ�������ַ������ֵ�λ�������ַ������
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
