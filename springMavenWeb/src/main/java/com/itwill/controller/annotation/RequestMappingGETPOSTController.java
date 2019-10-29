package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestMappingGETPOSTController {

	@RequestMapping(value="/login.do",method=RequestMethod.GET) // method=RequestMethod.GET  <<-- value 가 같더라도 GET 방식을 처리함
	public String login_form() {
		return "/WEB-INF/view/get_login_form.jsp";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST) // method=RequestMethod.POST  <<-- value 가 같더라도 POST 방식을 처리함
	public String login_action(@RequestParam("id") String id,@RequestParam("password") String password) {
	/*
	 * POST /login.do ->> 로그인작업수행
	 */
	System.out.println("### id:"+id);
	System.out.println("### password:"+password);
	return "/WEB-INF/view/post_login_result.jsp";
	}
	
	
}
