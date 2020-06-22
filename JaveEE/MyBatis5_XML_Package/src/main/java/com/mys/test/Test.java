package com.mys.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mys.mapper.StudentMapper;
import com.mys.pojo.Student;

public class Test {
		
	public static void main(String[] args) throws IOException {
		
		/**
		 * 	XML映射器+接口映射器方式使用mybatis
		 * 		1.定义映射器接口
		 * 		2.用XML方式创建映射器
		 */
		
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = factory.openSession();
		
		//通过session获取StudentMapper映射接口的代理对象
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		
		System.out.println("====================查询所有学生的信息====================");
		List<Student> allList = mapper.selectAll();
		for (Student student : allList) {
			System.out.println(student);
		}
		
		System.out.println("====================通过id查询学生的信息====================");
		Student stId = mapper.selectbyId(3);
		System.out.println(stId);
		
		System.out.println("====================通过姓名和年龄模糊查询学生的信息====================");
		//当传递多个参数时，不需要在xml文件中的select写parameterType
		List<Student> stNameAge = mapper.selectbyNameAndAge("王五", 40);
		System.out.println(stNameAge);
	}
		
}
