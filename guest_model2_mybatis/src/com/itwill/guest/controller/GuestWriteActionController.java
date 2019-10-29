package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestWriteActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				String guest_name=request.getParameter("guest_name");
				String guest_email=request.getParameter("guest_email");
				String guest_homepage=request.getParameter("guest_homepage");
				String guest_title=request.getParameter("guest_title");
				String guest_content=request.getParameter("guest_content");
				GuestService guestService=new GuestService();
				boolean insertOK = guestService.insertGuest(
				new Guest(
						0,
						guest_name,
						"",
						guest_email,
						guest_homepage,
						guest_title,
						guest_content)
				);
				if(insertOK){
					forwardPath="redirect:guest_list.do";
				}else{
					forwardPath="forward:/WEB-INF/view/guest_error.jsp";
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/view/guest_error.jsp";
		}
		return forwardPath;
	}

}
