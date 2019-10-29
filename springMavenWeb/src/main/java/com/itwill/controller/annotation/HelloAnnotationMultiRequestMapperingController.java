package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationMultiRequestMapperingController {

	public HelloAnnotationMultiRequestMapperingController() {
		System.out.println("### HelloAnnotationMultiRequestMapperingController() 기본생성자");
	}
	
	@RequestMapping("/hello3.do")
	public String hello3() {
		return "/WEB-INF/view/hello3.jsp";
	}
	
	@RequestMapping("/hello4.do")
	public String hello4() {
		
		return "/WEB-INF/view/hello4.jsp";
	}
	
	@RequestMapping("/hello5.do")
	public String hello5() {
		return "/WEB-INF/view/hello5.jsp"; //forward는 생략가능. 쓸 경우는 두번 사용하고 싶을때 
		
	}
	
	@RequestMapping("/hello_redirect_jsp.do")
	public String hello_redirect_jsp() {
		return "redirect:hello_redirected.jsp";  //redirect 대상 파일은 root에 위치해야 함
	}
	
	/*
	 * servlet --> servlet forward --> jsp로 forward
	 */
	@RequestMapping("/hello_servlet_forward.do")
	public String hello_servlet_forward() {
		return "forward:hello_servlet_forwarded.do";  //forward를 아래 forwarded로 포워딩함. 
													//결과적으로 hello_servlet_forwarded.jsp 가 실행됨
	}
	
	@RequestMapping("/hello_servlet_forwarded.do")
	public String Hello_serlvet_forwarded() {
		return "forward:/WEB-INF/view/hello_servlet_forwarded.jsp";
	}
	
	/*
	 * servlet --> servlet redirect -->  jsp forward
	 */
	@RequestMapping("/hello_redirect_servlet.do")
	public String hello_redirect_servlet() {
		return "redirect:hello_redirected_servlet.do";
	}
	@RequestMapping("/hello_redirected_servlet.do")
	public String hello_redirected_servlet() {
		return "forward:/WEB-INF/view/hello_redirected_servlet.jsp";
	}
	
}

