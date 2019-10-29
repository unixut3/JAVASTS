package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;

@Controller
public class RequestMappingParameterController {

	@RequestMapping(value="/parameter_guest_write_form.do")
	public String parameter_guest_write_form() {
		
		return "/WEB-INF/view/guest_write_form.jsp";
	}
	
	@RequestMapping(value="/parameter_guest_write_action.do",
					method=RequestMethod.POST)
	public String parameter_guest_write_action(@RequestParam("guest_name") String name,
												@RequestParam("guest_title") String guest_title,
												@RequestParam("guest_email") String guest_email,
												@RequestParam String guest_homepage,
												@RequestParam String guest_content,
												Model model)
	{
		System.out.println("guest_name: "+name);
		System.out.println("guest_title: "+guest_title);
		System.out.println("guest_email: "+guest_email);
		System.out.println("guest_homepage: "+guest_homepage);
		System.out.println("guest_content: "+guest_content);
		
		Guest guest = new Guest(name, guest_email, guest_homepage, guest_title,guest_content);
		
		model.addAttribute("guest", guest);
		/*
		 * GuestService 메소드 호출
		 */
		return "/WEB-INF/view/guest_write_result.jsp";
	}
	
	@RequestMapping(value="/model_attribute_guest_write_form.do")
	public String model_attribute_guest_write_form() {
		return "/WEB-INF/view/guest_write_form.jsp";
	}
	
	@RequestMapping(value="/model_attribute_guest_write_action.do",method=RequestMethod.POST)
	public String model_attribute_guest_write_action(@ModelAttribute Guest guest) {
		System.out.println("### "+ guest);
	/* 
	 * 1. 파라메타의 모든 객체 받기
	 * 2. 선언된 DTO객체[Guest]생성(기본생성자)
	 * 3. 받은 파라메타 데이터를 파라메타 이름과 일치하는 Guest객체의 속성메소드(setter method)호출해서 대입
	 * 4.  Guest클래스이름 첫글자를 소문자로변경한이름(guest)으로
		 *    request객체에 속성(attribute)등록
		 *    request.setAttribute("guest",guest);
	 * 
	 */
		return "/WEB-INF/view/guest_write_result.jsp";
	}
	
	
}
