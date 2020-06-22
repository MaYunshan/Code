package com.mys.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mys.bean.People;
import com.mys.service.PeopleService;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public List<People> show() throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
		//前面是工厂模式，实例化工厂对象时使用的是构建者设计模式  名称标志：后面有Builder
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = factory.openSession();
		
		List<People> list = session.selectList("com.mys.mapper.PeopleMapper.selAll");
		
		session.close();
		
		return list;
	}

}
