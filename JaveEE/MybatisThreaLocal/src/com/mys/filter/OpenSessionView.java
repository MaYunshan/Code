package com.mys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.mys.utils.MybatisUtils;

@WebFilter("/*")
public class OpenSessionView implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {
		
		SqlSession session = MybatisUtils.getSession();
		try {
			chain.doFilter(request, response);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			MybatisUtils.closeSession();
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
