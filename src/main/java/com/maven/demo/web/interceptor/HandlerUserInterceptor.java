package com.maven.demo.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by BiaoQier on 2014/9/10 0010.
 */
public class HandlerUserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out
				.println("============执行-类名：HandlerUserInterceptor 方法名：preHandle===========");
		/*
		 * System.out.println("Protocol: " + request.getProtocol());
		 * System.out.println("Scheme: " + request.getScheme());
		 * System.out.println("Server Name: " + request.getServerName()); //
		 * 获得服务器的名字 System.out.println("Server Port: " +
		 * request.getServerPort()); // 获得服务器的端口号
		 * System.out.println("Protocol: " + request.getProtocol());
		 * System.out.println("Remote Addr: " + request.getRemoteAddr()); //
		 * 获得客户端的ip地址 System.out.println("Remote Host: " +
		 * request.getRemoteHost()); // 获得客户端电脑的名字，若失败，则返回客户端电脑的ip地址
		 * System.out.println("Character Encoding: " +
		 * request.getCharacterEncoding());
		 * System.out.println("Content Length: " + request.getContentLength());
		 * System.out.println("Content Type: " + request.getContentType());
		 * System.out.println("Auth Type: " + request.getAuthType());
		 * System.out.println("HTTP Method: " + request.getMethod()); //
		 * 获得客户端向服务器端传送数据的方法有get、post、put等类型 System.out.println("Path Info: " +
		 * request.getPathInfo()); System.out.println("Path Trans: " +
		 * request.getPathTranslated()); System.out.println("Query String: " +
		 * request.getQueryString()); System.out.println("Remote User: " +
		 * request.getRemoteUser()); System.out.println("Session Id: " +
		 * request.getRequestedSessionId()); System.out.println("Request URI: "
		 * + request.getRequestURI());// 获得发出请求字符串的客户端地址
		 * System.out.println("Servlet Path: " + request.getServletPath()); //
		 * 获得客户端所请求的脚本文件的文件路径 System.out.println(request.getHeaderNames()); //
		 * 返回所有request // header的名字，结果集是一个enumeration（枚举）类的实例
		 * System.out.println("Accept: " + request.getHeader("Accept"));
		 * System.out.println("Host: " + request.getHeader("Host"));
		 * System.out.println("Referer : " + request.getHeader("Referer"));
		 * System.out.println("Accept-Language : " +
		 * request.getHeader("Accept-Language"));
		 * System.out.println("Accept-Encoding : " +
		 * request.getHeader("Accept-Encoding"));
		 * System.out.println("User-Agent : " +
		 * request.getHeader("User-Agent")); // 返回客户端浏览器的版本号、类型
		 * System.out.println("Connection : " +
		 * request.getHeader("Connection")); System.out.println("Cookie : " +
		 * request.getHeader("Cookie"));
		 */
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("============执行-类名：HandlerUserInterceptor 方法名：postHandle===========");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("============执行-类名：HandlerUserInterceptor 方法名：afterCompletion===========");
	}
}
