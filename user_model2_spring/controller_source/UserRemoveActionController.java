package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;

public class UserRemoveActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_main.do";
			return forwardPath;
		}

		String userId = request.getParameter("userId");
		try{
			UserService userService=new UserServiceImpl();
			userService.remove(userId);
			if(request.getSession().getAttribute("sUserId").equals(userId)) {
				forwardPath="redirect:user_logout_action.do";
			}else {
				forwardPath="redirect:user_main.do";
			}
			
		}catch(Exception e){
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/view/user_error.jsp";
		}
		return forwardPath;
	}
}
