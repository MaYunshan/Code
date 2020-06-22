package com.mys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mys.bean.Flower;

public interface FlowerMapper {
	List<Flower> selAll();
	
	List<Flower> selbyNameAndId(String name,int id);
	
	List<Flower> selbyNameAndProducation(@Param("name") String name, @Param("producation") String producation);
}
