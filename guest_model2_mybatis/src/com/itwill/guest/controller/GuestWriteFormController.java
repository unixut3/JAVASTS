package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;

public class GuestWriteFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		forwardPath="forward:/WEB-INF/view/guest_write_form.jsp";
		return forwardPath;
	}

}
