package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.GuestServiceImpl;
public class GuestListController implements Controller{
	private GuestService guestService;
	public GuestListController() {
		System.out.println("5.### GuestListController():생성자");
	}
	public void setGuestService(GuestService guestService) {
		System.out.println("6.### GuestListController: setGuestService()메쏘드실행");
		this.guestService = guestService;
	}


	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView=new ModelAndView();
		String forwardPath="";
		try {
			List<Guest> guestList=guestService.selectAll();
			request.setAttribute("guestList",guestList);
			forwardPath="forward:/WEB-INF/view/guest_list.jsp";
		}catch (Exception e) {
			forwardPath="forward:/WEB-INF/view/guest_error.jsp";
			e.printStackTrace();
		}
		modelAndView.setViewName(forwardPath);
		return modelAndView;
	}
}
