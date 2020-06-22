package com.mys.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.mys.bean.Flower;
import com.mys.mapper.FlowerMapper;
import com.mys.service.FlowerService;
import com.mys.utils.MybatisUtils;

public class FlowerServiceImpl implements FlowerService {
	
	@Override
	public int add(Flower flower) {
		SqlSession session = MybatisUtils.getSession();
		FlowerMapper flowerMapper = session.getMapper(FlowerMapper.class);
		int index = flowerMapper.insert(flower);
		return index;
	}

}
