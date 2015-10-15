package com.lashouinc.library.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterTest1 implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request; 
		System.out.println("test filter 1 begin" + hrequest.getRequestURI());
		chain.doFilter(request, response);
		System.out.println("test filter 1 end");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("test filter 1 destory");
	}

}
