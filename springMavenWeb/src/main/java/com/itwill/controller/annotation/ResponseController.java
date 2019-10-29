package com.itwill.controller.annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import com.itwill.dto.Guest;

@Controller
public class ResponseController {
	/**********xml출력 View[XMLView]*****************/
	@RequestMapping("/response_xml_view_object.do")
	public View response_xml_view_object(Map map) {
		ArrayList<String> friendsList = new ArrayList<String>();
		friendsList.add("아줌마");
		friendsList.add("아저씨");
		friendsList.add("애시키");
		friendsList.add("짜잉남");
		
		map.put("friendsList",friendsList);
		XMLView xmlView = new XMLView();
		return xmlView;
	}
	
	@RequestMapping("/response_xml_view_name.do")
	public String response_xml_view_name(Map map) {
		ArrayList<String> friendsList = new ArrayList<String>();
		friendsList.add("아줌마");
		friendsList.add("아저씨");
		friendsList.add("애시키");
		friendsList.add("짜잉남");
		map.put("friendsList",friendsList);
		return "xmlView";
	}
	
	/**********forward view*****************/
	@RequestMapping("/response_view_name.do")
	public String responseViewName() {
		
		/* 
		  0 . view name(String)
		  1 . InternalResourceViewResolver객체
		  2 . InternalResourceView 객체(URL:/WEB-INF/view/response_view_name.jsp)
		  3 . URL--> /WEB-INF/view/response_view_name.jsp forward	
		*/
		
		return "/response_view_name";
		
	}
	@RequestMapping("/response_view_object.do")
	public View responseViewObject() {
		InternalResourceView internalResourceView=
				new InternalResourceView("/WEB-INF/view/response_view_object.jsp");
		/*
		 * 1.InternalResourceView 객체(URL:/WEB-INF/view/response_view_object.jsp)반환
		 * 2.URL--> /WEB-INF/view/response_view_object.jsp forward
		 */
		return internalResourceView;
	}
	/**********redirect view****************/
	@RequestMapping("/response_redirect_view_object.do")
	public View response_redirect_view_object(Model model) {
		RedirectView redirectView=
				new RedirectView("response_redirect_view_object.jsp");
		/*
		 * response_redirect_view_object.jsp?id=xxx&name=kim
		 */
		model.addAttribute("id","xxx");
		model.addAttribute("name","kim");
		
		return redirectView;
	}
	@RequestMapping("/response_redirect_view_name.do")
	public String response_redirect_view_name(Model model) {
		/*
		 * response_redirect_view_name.jsp?id=xxx&name=kim
		 */
		model.addAttribute("id","xxx");
		model.addAttribute("name","kim");
		
		return "redirect:response_redirect_view_name.jsp";
	}
	/*
	 * Controller-->MessageConverter-->클라이언트로 출력
	 */
	@RequestMapping(value="/response_string.do",
					produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String responseString() {
		return "string response body data[한글]";
	}
	@ResponseBody
	@RequestMapping(value="/response_html.do",
			produces="text/html;charset=UTF-8")
	public String responseHtml() {
		return "<h1>string response body data[한글]</h1>";
	}
	
	@RequestMapping(value="/response_xml.do",
	produces="text/xml;charset=UTF-8")
	@ResponseBody
	public Guest responseXml() {
		Guest guest=
				new Guest(1, "KIM", new Date().toLocaleString(),
						"email","homepage", "guest_title",
						"guest_content");
		return guest;
	}
	
	
}
