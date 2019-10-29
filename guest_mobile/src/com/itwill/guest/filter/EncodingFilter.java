package com.itwill.guest.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/*
<filter>
	<filter-name>Encoding Filter</filter-name>
	<filter-class>mvc.util.filter.EncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>euc-kr</param-value>
	</init-param>
</filter>

<filter-mapping>
	<filter-name>Encoding Filter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
 */

@WebFilter(value = "*.jsp")
public class EncodingFilter implements Filter {
	private String encoding = null;
	
	public void destroy() {
		this.encoding = null;
	}

	/**
	 * ServletRequest객체에 web.xml에서 전달된 인코딩을 설정하는 메써드.
	 */
	public void doFilter(
		ServletRequest request,
		ServletResponse response,
		FilterChain chain)
		throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		//System.out.println("request...");
		chain.doFilter(request, response);
	}

	/**
	 * web.xml에서 전달된 인코딩 값을 초기화하는 메써드.
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	
}
