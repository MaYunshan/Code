package com.mys.flower.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mys.flower.service.FlowerService;
import com.mys.flower.service.impl.FlowerServiceImpl;

class TestJDBC {

	@Test
	void test() {
		FlowerService flowerService = new FlowerServiceImpl();
		flowerService.show();
	}

}
