package com.mys.mapper;

import java.util.List;

import com.mys.pojo.Student;

public interface StudentMapper {
	
	List<Student> selectAll();
	
	Student selectbyId(int id);
	
	List<Student> selectbyNameAndAge(String name,int age);
}
