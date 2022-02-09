package com.example.demo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;


/**
 * Servlet Filter implementation class InsertFilter
 */
//@WebFilter("/InsertFilter")
@Component
public class InsertFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public InsertFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	
	//필터를 설정하면 필터클래스의 doFilter메소드가 동작함
	//필터가 해야하는 일을 doFilter메소드에 작성
	//doFilter메소드는 request매개변수로 가짐
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			// TODO Auto-generated method stub
			// place your code here
			
			 //이필터에서 로그인을 했는지 확인하기 : session필요
			//request객체를 통해서 session을  받아옴
			//request는 ServletRequest라서 HttpServletRequest로 캐스팅 필수
			HttpSession session	= ((HttpServletRequest)request).getSession();
			
			//로그인과 관련한 값을 읽어와서 저장할 변수를 선언
			int re = -1;
			if(session.getAttribute("re") != null) {
				//세션에 로그인과 관련된 re값이 있다면 읽어와서 변수에 저장
				re =(Integer)session.getAttribute("re");
			}
			
			if(re==1) {
				// pass the request along the filter chain
				//요청한 서비스로 이동하라는 명령 ->로그인을 했을 때만 이 명령 만나기
				chain.doFilter(request, response);	
				
			}else {
				//로그인을 하는 데로 보내기
				((HttpServletResponse)response).sendRedirect("/login");
			}
		}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
