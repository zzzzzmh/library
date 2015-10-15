package com.lashouinc.library.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FilterTest2 implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {	
		HttpServletRequest hrequest = (HttpServletRequest) request; 
		System.out.println("test filter 2 begin" + hrequest.getRequestURI());

		HttpSession session = hrequest.getSession();
		if(session.getAttribute("username") != null) {
			chain.doFilter(request, response);
			System.out.println("test filter 2 end");
		} else {
			chain.doFilter(request, response);
			System.out.println("test filter 2 error");
		}
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("test filter 2 destory");
	}
}
