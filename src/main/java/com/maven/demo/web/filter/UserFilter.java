package com.maven.demo.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;

import java.io.IOException;


@Component
public class UserFilter  implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("===========执行-类名：UserFilter 方法名：init===========");
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("===========执行-类名：UserFilter 方法名：doFilter===========");
		filterChain.doFilter(servletRequest, servletResponse);

	}

	public void destroy() {
		System.out.println("===========执行-类名：UserFilter 方法名：destroy===========");
	}
}
