package com.mys.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mys.bean.People;

public class TestPeople {

	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = factory.openSession();
		
		//向查询语句中传入参数
		//selectbyId(session);
		
		//使用对象或者map向查询语句中传递参数
		//selectbyMap(session);
		
		//实现分页查询
		//pageSelect(session);
		
		//向表中插入数据
		insert(session);
		
		session.close();
	}

	private static void insert(SqlSession session) {
		People p = new People();
		p.setName("王五");
		p.setAge(39);
		int index = session.insert("com.mys.mapper.PeopleMapper.insert", p);
		if(index > 0) {
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
	}

	private static void selectbyId(SqlSession session) {
		People people = session.selectOne("com.mys.mapper.PeopleMapper.selbyId", 2);
		System.out.println(people);
	}

	private static void selectbyMap(SqlSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",1);
		map.put("name", "张三");
		People peo1 = session.selectOne("com.mys.mapper.PeopleMapper.selbyIdAndName",map);
		System.out.println(peo1);
	}

	private static void pageSelect(SqlSession session) {
		int pageSize=5;				//每一页的条数
		int pageNumber=1;			//第几页
		Map<String, Object> mapPage = new HashMap<String, Object>();
		mapPage.put("pageSize", pageSize);
		mapPage.put("pageStart", pageSize*(pageNumber-1));
		List<Object> pageList = session.selectList("com.mys.mapper.PeopleMapper.selbyPage", mapPage);
		System.out.println(pageList);
	}

}
