package com.mys.testStudent;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mys.bean.Student;

public class TestStudent {
	public static void main(String[] args) throws IOException {
		
		/**
		 * 	纯xml映射器，利用SqlSession的各种方法实现增删改查
		 */
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession session = factory.openSession();
		
		//查询所有学生
		//selectAllStudent(session);
		
		//根据id查询学生信息，输入参数类型是Integer基本类型
		System.out.println("===================根据id查询学生信息===========================");
		Student student = session.selectOne("com.mys.mapper.StudentMapper.selectbyId",2);
		System.out.println(student);
		
		//根据学生name在数据库中模糊查询，返回结果有可能是多个
		System.out.println("===================根据学生name在数据库中模糊查询===========================");
		List<Student> nameLikeList = session.selectList("com.mys.mapper.StudentMapper.selectbyName","王五");
		for (Student student2 : nameLikeList) {
			System.out.println(student2);
		}
		
		//根据学生name和age查询信息，如果输入参数类型是多个参数，需要使用map或者对象
		System.out.println("==================根据学生name和age在数据库中模糊查询==========================");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "王五");
		map.put("age","44");
		Student student2 = session.selectOne("com.mys.mapper.StudentMapper.selectbyNameAndAge", map);
		System.out.println(student2);
		
		System.out.println("==================根据年龄范围查询学生信息==========================");
		//根据年龄范围查询学生信息，此处在config配置文件中加入了别名
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("floor", 40);
		map2.put("ceil", 45);
		//因为使用了别名，所以不需要写入namespace的全名
		List<Student> ageList = session.selectList("selectbyAge",map2);
		for (Student student3 : ageList) {
			System.out.println(student3);
		}
		
		System.out.println("==================向学生表中新增学生==========================");
		//插入数据
		Student newStudent = new Student();
		newStudent.setName("mys");
		newStudent.setAge(25);
		newStudent.setSex(false);
		int index = session.insert("insertStudent",newStudent);
		if(index > 0) {
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
		
		System.out.println("==================更新学生表中的某条记录==========================");
		//更新数据
		Student updateStudent = new Student();
		updateStudent.setName("mys");
		updateStudent.setAge(25);
		updateStudent.setSex(false);
		int index1 = session.insert("insertStudent",updateStudent);
		if(index1 > 0) {
			System.out.println("更新成功");
		}else {
			System.out.println("更新失败");
		}
		
		System.out.println("==================删除学生表中的某条记录==========================");
		//删除数据
		
		int index2 = session.delete("deleteStudent",5);
		if(index2 > 0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}

	private static void selectAllStudent(SqlSession session) {
		List<Student> lists = session.selectList("com.mys.mapper.StudentMapper.selectAll");
		
		for (Student student : lists) {
			System.out.println(student);
		}
	}
}
