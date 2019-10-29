package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.service.HelloService;

public class HelloController implements Controller{
	private HelloService helloService;
	public HelloController() {
		System.out.println("### HelloController() 생성자");
	}
	public void setHelloService(HelloService helloService) {
		System.out.println("### HelloController: setHelloService()메쏘드호출");
		this.helloService = helloService;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
									  HttpServletResponse response) throws Exception {
		System.out.println("### HelloController: handleRequest()메쏘드호출");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/WEB-INF/view/hello.jsp");
		helloService.service_method();
		request.setAttribute("msg", "안녕 Spring MVC");
		return modelAndView;
	}
	
}












