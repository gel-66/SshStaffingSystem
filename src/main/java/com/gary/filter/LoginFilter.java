package com.gary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		//修改编码，防止中文
		String character = config.getInitParameter("character");
		if(character == null){
			character = "utf-8";
		}
		req.setCharacterEncoding(character);
		System.out.println(req.getRequestURI());
		if(req.getRequestURI().indexOf("index") != -1){
			System.out.println("index.jsp.....");
			chain.doFilter(request, response);
		}else{
			System.out.println("other jsp.....");
			//如果存在登陆信息
			if(session.getAttribute("existEmployee") != null){
				//允许放行
				chain.doFilter(request, response);
				System.out.println("login success.....");
			}else{
				System.out.println("no login.....");
				res.sendRedirect("index.jsp");
			}
		}
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

}
