package com.mys.flower.dao;

import java.util.List;

import com.mys.flower.bean.Flower;

public interface FlowerDao {
	/**
	 * 查询全部
	 * @return
	 */
	List<Flower> selectAll();
	
	/**
	 * 	新增
	 */
	int insertFlower(Flower flower);
}
