package com.itwill.user.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.UserServiceImpl;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

public class UserLoginActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, 
								HttpServletResponse response) {
		
		String forwardPath="";
		if(request.getMethod().equalsIgnoreCase("GET")){
			//response.sendRedirect("user_login_form.jsp");
			forwardPath="redirect:user_login_form.do";
			//forwardPath="forward:/WEB-INF/view/user_login_form.do";
			return forwardPath;
		}
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		try{
			UserService userService=new UserServiceImpl();
			User loginUser=userService.login(userId,password);
			HttpSession session=request.getSession();
			session.setAttribute("sUserId", userId);
			session.setAttribute("sUser", loginUser);
			//response.sendRedirect("user_main.jsp");
			forwardPath="redirect:user_main.do";
		}catch(UserNotFoundException e){
			User fuser=new User(userId, password, "","");
			request.setAttribute("msg1",e.getMessage());
			request.setAttribute("fuser",fuser);
			forwardPath="forward:/WEB-INF/view/user_login_form.jsp";
		}catch(PasswordMismatchException e){
			User fuser=new User(userId, password, "","");
			request.setAttribute("msg2",e.getMessage());
			request.setAttribute("fuser",fuser);
			forwardPath="forward:/WEB-INF/view/user_login_form.jsp";
		}catch(Exception e){
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/view/user_error.jsp";
		}
		return forwardPath;
	}

}
