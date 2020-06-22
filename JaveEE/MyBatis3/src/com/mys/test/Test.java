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
import com.mys.mapper.FlowerMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//使用factory工厂生产SqlSession
		SqlSession session = factory.openSession();
		
		/**
		 * 	需要给接口一个实例化对象
		 * 	
		 * 	使用的是JDK动态代理模式。
		 * 		面向接口的代理设计模式（必须有接口）
		 */
		selectAll(session);
		
		
		/**
		 * 	传入多个参数进行查询
		 */
		  selectbyNameAndId(session);
		  
		  /**
		   * 	动态SQL ,根据name和producation查询，name和producation或为空或不为空
		   */
		 
		  java.util.Scanner sc = new java.util.Scanner(System.in);
		  //System.out.println("请输入名称：");
		  //String name = sc.nextLine();
		  
		  //System.out.println("请输入产地:");
		  //String producation = sc.nextLine();
		  String name = "测试";
		  String producation = "";
		  
		  FlowerMapper mapper3 = session.getMapper(FlowerMapper.class);
		  List<Flower> list3 = mapper3.selbyNameAndProducation(name, producation);            
		  System.out.println(list3);
		  
	}

	private static void selectbyNameAndId(SqlSession session) {
	    FlowerMapper mapper2 = session.getMapper(FlowerMapper.class); 
	    List<Flower> list2 = mapper2.selbyNameAndId("百日草", 2); 
	    System.out.println(list2);
	}

	private static void selectAll(SqlSession session) {
		FlowerMapper mapper = session.getMapper(FlowerMapper.class);
		List<Flower> list = mapper.selAll();
		for (Flower flower : list) {
			System.out.println(flower);
		}
	}

}
