package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationController1 {
	
	public HelloAnnotationController1() {
		System.out.println("### HelloAnnotationController1() : 생성자");
	}
	@RequestMapping("/hello1.do")
	public String hello1(HttpServletRequest request) {
		System.out.println("### HelloAnnotationController1 : hello1() 메쏘드실행");
		request.setAttribute("msg","안녕어노테이션Controller");
		return "forward:/WEB-INF/view/hello1.jsp";
	}
	
}
