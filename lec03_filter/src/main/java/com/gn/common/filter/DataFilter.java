package com.gn.common.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class DataFilter
 */
//@WebFilter(servletNames = "receiveDataServlet")
//@WebFilter(urlPatterns = "/*")
//@WebFilter(urlPatterns = "/receive/*") 
//@WebFilter(urlPatterns = {"/receive/data", "/abcd"}) // 경로는 복수로 사용할 수 있음
@WebFilter(urlPatterns = "/receive/*")
public class DataFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public DataFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// 필터가 소멸될 때 실행
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청과 응답 처리
		// 1. 요청이 필터를 지나가기 전에 할 작업
		System.out.println("[DataFilter] 요청을 가로챔");
		// 2.다음 필터나 서블릿으로 요청을 넘김
		chain.doFilter(request, response);
		// 3. 서블릿의 작업이 끝나고 클라이언트로 가기전 작업
		System.out.println("[DataFilter] 응답을 가로챔");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 필터가 초기화될 때 실행
	}

}
