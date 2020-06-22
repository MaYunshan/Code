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

import com.mys.bean.Teacher;


public class Test {

	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//使用factory工厂生产SqlSession
		SqlSession session = factory.openSession();
		
		List<Teacher> list = session.selectList("com.mys.mapper.TeacherMapper.selectAll");
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}	
		  
	}

	

}
