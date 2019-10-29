package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationController2 {
	
	public HelloAnnotationController2() {
		System.out.println("### HelloAnnotationController2() : 생성자");
	}
	@RequestMapping("/hello2.do")
	public String hello2() {
		System.out.println("### HelloAnnotationController2 : hello2() 메쏘드실행");
		return "forward:/WEB-INF/view/hello2.jsp";
	}
	
}
