package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestModifyFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				String guest_noStr = request.getParameter("guest_no");
				GuestService guestService=new GuestService();
				Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
				request.setAttribute("guest",guest);
				forwardPath="forward:/WEB-INF/view/guest_modify_form.jsp";
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:guest_error.jsp";
			}
		}
		return forwardPath;
	}

}
