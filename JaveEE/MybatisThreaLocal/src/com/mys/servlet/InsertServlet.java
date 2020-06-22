package com.mys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mys.bean.Flower;
import com.mys.service.FlowerService;
import com.mys.serviceImpl.FlowerServiceImpl;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	
	private FlowerService flowerService = new FlowerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Flower flower = new Flower();
		flower.setName(req.getParameter("name"));
		flower.setPrice(Float.parseFloat(req.getParameter("price")));
		flower.setProducation(req.getParameter("producation"));
		
		int index = flowerService.add(flower);
		if(index > 0) {
			resp.sendRedirect("success.jsp");
		}else {
			resp.sendRedirect("error.jsp");
		}
	}
}
