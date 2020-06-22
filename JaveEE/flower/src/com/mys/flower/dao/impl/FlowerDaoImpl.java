package com.mys.flower.dao.impl;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mys.flower.bean.Flower;
import com.mys.flower.dao.FlowerDao;
import com.mysql.jdbc.Driver;
import java.sql.PreparedStatement;

public class FlowerDaoImpl implements FlowerDao {

	/**
	 * 数据库访问层要有异常处理
	 */
	@Override
	public List<Flower> selectAll() {
		List<Flower> list = new ArrayList<Flower>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm","root","sql3306");
			ps = conn.prepareStatement("select * from flower");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Flower(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
			}
			System.out.println(list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insertFlower(Flower flower) {
		int index = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm","root","sql3306");
			ps = conn.prepareStatement("insert into flower values(default,?,?,?)");
			ps.setObject(1,flower.getName());
			ps.setObject(2, flower.getPrice());
			ps.setObject(3, flower.getProducation());
			index = ps.executeUpdate();
			
			System.out.println(index);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return index;
		
	}

}
