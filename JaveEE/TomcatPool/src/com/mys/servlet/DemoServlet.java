package com.mys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resources;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/pool")
public class DemoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Context ctx = new InitialContext();	
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/test");
			
			//获取数据库连接对象
			Connection conn = ds.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("select * from flower");
			ResultSet rs = ps.executeQuery();
			
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			while(rs.next()) {
				out.print(rs.getInt(1)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(2)+"<br />");
			}
			out.write("success");
			out.flush();
			out.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
