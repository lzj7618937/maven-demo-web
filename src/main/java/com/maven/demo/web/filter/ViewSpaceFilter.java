package com.maven.demo.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.maven.demo.constant.Constant;
import com.maven.demo.entity.User;

import java.io.IOException;


public class ViewSpaceFilter implements Filter {
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";

	// ① 需要登录即可访问的URI资源
	private static final String[] INHERENT_URIS = {"/add", "/save", "/edit", "/update", "/delete"};

	// ② 执行过滤
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// ②-1 保证该过滤器在一次请求中只被调用一次
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {

			// ②-2 设置过滤标识，防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			User userContext = getSessionUser(httpRequest);

			// ②-3 用户未登录, 且当前URI资源需要登录才能访问
			if (userContext == null && isURILogin(httpRequest.getRequestURI(), httpRequest)) {
				String toUrl = httpRequest.getRequestURL().toString();
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toUrl += "?" + httpRequest.getQueryString();
				}

				// ②-4将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
				httpRequest.getSession().setAttribute(Constant.LOGIN_TO_URL, toUrl);

				// ②-5转发到登录页面
				request.getRequestDispatcher("/login").forward(request,response);
				return;
			}
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	/**
	 * 当前URI资源是否需要登录才能访问
	 *
	 * @param requestURI
	 * @param request
	 * @return
	 */
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		for (String uri : INHERENT_URIS) {
			if (requestURI != null && requestURI.indexOf(uri) >= 0) {
				return true;
			}
		}
		return false;
	}

	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(Constant.USER_CONTEXT);
	}

	public void destroy() {

	}
}
