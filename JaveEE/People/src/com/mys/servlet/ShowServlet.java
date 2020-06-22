package com.mys.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mys.bean.People;
import com.mys.service.PeopleService;
import com.mys.service.impl.PeopleServiceImpl;

/**
 * 	大部分注解都有默认属性，如果注解中只是给默认属性赋值，可以省略属性名；否则注解中的格式为(属性名=属性值)
 * 	如果一个属性是数组类型格式，其格式为：属性名={属性值,属性值}，如果该数组只有一个值，可以省略大括号
 * 	如果类不是一个基本数据类型或者String类型，其语法为：属性名=@类型
 * 
 */
//@WebServlet(value="{/show}")
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	
	//声明一个服务对象
	private PeopleService peopleService = new PeopleServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<People> list = peopleService.show();
		req.setAttribute("list", list);
		
		// 如果路径是以/开头，代表的是全路径，否则就是相对路径
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
