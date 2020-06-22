package com.mys.flower.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mys.flower.bean.Flower;
import com.mys.flower.service.FlowerService;
import com.mys.flower.service.impl.FlowerServiceImpl;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet{
	private FlowerService flowerService = new FlowerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("utf-8");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String producation = req.getParameter("producation");
		Flower flower = new Flower();
		System.out.println(producation);
		flower.setName(name);
		flower.setPrice(Float.parseFloat(price));
		flower.setProducation(producation);
		
		int index = flowerService.add(flower);
		if(index > 0) {
			resp.sendRedirect("show");
		}else {
			resp.sendRedirect("add.jsp");
		}
	}
	
	
}
