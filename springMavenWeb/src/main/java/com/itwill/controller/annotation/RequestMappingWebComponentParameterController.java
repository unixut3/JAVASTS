package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RequestMappingWebComponentParameterController {
	@RequestMapping("/controller_servletapi.do")
	public String request(HttpServletRequest request, 
							HttpServletResponse response,
							HttpSession session,
							@CookieValue("JSESSIONID") String sessionId) {

		System.out.println("### HttpServletRequest: "+request);
		System.out.println("### HttpServletResponse: "+response);
		System.out.println("### HttpSessoin: "+session);
		System.out.println("### @CookieValue('JSESSIONID'): "+sessionId);
		return "/WEB-INF/view/controller_servletapi.jsp";
		
	}

}
