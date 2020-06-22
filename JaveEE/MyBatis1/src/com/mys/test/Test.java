package com.mys.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.IbatisException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mys.bean.Flower;

public class Test {

	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//使用factory工厂生产SqlSession
		SqlSession session = factory.openSession();
		
		
		/**
		 * 	获取flower表中所有数据
		 */
//		 List<Flower> lists = session.selectList("a.b.selAll");
//		 for(Flower flower :lists){
//			 System.out.println(flower.toString()); 
//		 }
		 
		/**
		 * 
		 */
//		int count = session.selectOne("a.b.selbyId");
//		System.out.println(count);
		
		Map<Object, Object> map = session.selectMap("a.b.selMap", "name");
		for (Object key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		System.out.println(map);
		
		session.close();
	}

}
