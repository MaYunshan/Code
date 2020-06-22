package com.mys.flower.service.impl;

import java.util.List;

import com.mys.flower.bean.Flower;
import com.mys.flower.dao.FlowerDao;
import com.mys.flower.dao.impl.FlowerDaoImpl;
import com.mys.flower.service.FlowerService;


public class FlowerServiceImpl implements FlowerService {

	private FlowerDao flowerDao = new FlowerDaoImpl();
	
	@Override
	public List<Flower> show() {
		return flowerDao.selectAll();
	}

	@Override
	public int add(Flower flower) {
		return flowerDao.insertFlower(flower);
	}

}
