package com.mys.flower.service;

import java.util.List;

import com.mys.flower.bean.Flower;

public interface FlowerService {
	/**
	 * 	获取所有花卉信息
	 * @return
	 */
	public List<Flower> show();
	
	/**
	 * 增加花卉信息
	 */
	public int add(Flower flower);
}
