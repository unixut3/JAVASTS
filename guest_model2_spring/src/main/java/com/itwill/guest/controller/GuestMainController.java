package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



/*
 * - DispatcherServlet이 요청command당 1개씩생성하는 객체
 * - DispatcherServlet이 이객체의메쏘드를 호출해서 업무실행  
 * - DispatcherServlet에게 forwardPath를 반환 
 */
public class GuestMainController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
								HttpServletResponse response) {
		String forwardPath="forward:/WEB-INF/view/guest_main.jsp";
		ModelAndView modelAndView=new ModelAndView(forwardPath);
		
		return modelAndView;
	}
}
