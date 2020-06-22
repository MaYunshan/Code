package com.mys.flower.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mys.flower.bean.Flower;
import com.mys.flower.service.FlowerService;
import com.mys.flower.service.impl.FlowerServiceImpl;

public class ShowServlet extends HttpServlet {
private FlowerService flowerService= new FlowerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Flower> list = flowerService.show();
		req.setAttribute("list",list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
