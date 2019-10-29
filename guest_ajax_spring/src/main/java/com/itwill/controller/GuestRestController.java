package com.itwill.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

@Controller
@RequestMapping(value = "/guest")
public class GuestRestController {
	@Autowired
	GuestDao dao;
	@RequestMapping(value = "/guest_list_html.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String guest_list_html() throws Exception {
		StringBuffer sb = new StringBuffer();
		ArrayList<Guest> guestList = dao.guestList();
		for (int i = 0; i < guestList.size(); i++) {
			Guest guest = guestList.get(i);
			sb.append("<div class=\"guest_item\">");
			sb.append("<h3 class=\"guest_title\"  guest_no=\"" + guest.getGuest_no() + "\"><a href='#'>"
					+ guest.getGuest_title() + "[HTML]</a></h3>");
			sb.append("</div>");
		}
		return sb.toString();
	}

	@RequestMapping(value = "/guest_detail_html.do", produces = "text/plain;charset=UTF-8")
	public @ResponseBody  String guest_detail_html(@RequestParam(defaultValue = "5") String guest_no)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		Guest guest = dao.selectByNo(Integer.parseInt(guest_no.trim()));
		sb.append("<div class=\"guest_date\">");
		sb.append("날짜:" + guest.getGuest_date());
		sb.append("</div>");
		sb.append("<div class=\"guest_name\">");
		sb.append("	이름:" + guest.getGuest_name());
		sb.append("</div>");
		sb.append("<div class=\"guest_email\">");
		sb.append("이메일:" + guest.getGuest_email());
		sb.append("</div>");
		sb.append("<div class=\"guest_homepage\">");
		sb.append("홈페이지:" + guest.getGuest_homepage());
		sb.append("</div>");
		sb.append("<div class=\"guest_content\">");
		sb.append("내용:" + guest.getGuest_content());
		sb.append("</div>");
		return sb.toString();
	}
	@RequestMapping(value = "/guest_insert_form.html", produces = "text/plain;charset=UTF-8")
	public String guest_insert_form(HttpServletRequest request, @RequestParam(defaultValue = "5") String guest_no)
			throws Exception {
		return "forward:guest_insert_form.html";
	}
}
