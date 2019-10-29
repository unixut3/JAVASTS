package com.itwill.summer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.controller.GuestDeleteActionController;
import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;

public class DispatcherServletSecond1 extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.processRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.processRequest(request, response);
	}
	private void processRequest(HttpServletRequest  request,
								HttpServletResponse response)
										throws ServletException, IOException  {
		
		/*
		<<요청command>>
		/guest_main.do
		/guest_write_form.do
		/guest_write_action.do
		/guest_list.do
		/guest_view.do
		/guest_modify_form.do
		/guest_modify_action.do
		/guest_delete_action.do
		
		*/
		/*
		 * 1.클라이언트 요청분석(URI)
		 */
		String requestURI = request.getRequestURI();
		//System.out.println("requstURI:"+requestURI);
		String contextPath=request.getContextPath();
		//System.out.println("contextPath:"+contextPath);
		String command = requestURI.substring(contextPath.length());
		System.out.println("command:"+command);
		/*
		 * 2.클라이언트요청에따른 Controller객체생성
		 */
		String forwardPath="";
		boolean isRedirect=false;
		Controller controller=null;
		
		if(command.equals("/guest_main.do")) {
			controller=new GuestMainController();
		}else if(command.equals("/guest_list.do")) {
			controller=new GuestListController();
		}else if(command.equals("/guest_view.do")) {
			controller=new GuestViewController();
		}else if(command.equals("/guest_write_form.do")) {
			controller=new GuestWriteFormController();
		}else if(command.equals("/guest_write_action.do")) {
			controller=new GuestWriteActionController();
		}else if(command.equals("/guest_delete_action.do")) {
			controller=new GuestDeleteActionController();
		}else if(command.equals("/guest_modify_form.do")) {
			controller=new GuestModifyFormController();
		}else if(command.equals("/guest_modify_action.do")) {
			controller=new GuestModifyActionController();
		}else {
			controller=new GuestErrorController();
		}
		
		
		/*
		*  3.클라이언트요청에따른 생성된 
		*  	Controller객체메쏘드(handleRequst)호출
		*/
		forwardPath = controller.handleRequest(request, response);
		/*
		 * 4. JSP로 forward or *.do redirect(forward)
		 */
		/**************forward:xxx.jsp,redirect:xxx.do*************/
		String[] tempForwardPaths = forwardPath.split(":");
		String redirectStr=tempForwardPaths[0];
		forwardPath=tempForwardPaths[1];
		if(redirectStr.equals("forward")) {
			isRedirect=false;
		}else if(redirectStr.equals("redirect")) {
			isRedirect=true;
		}
		/********************************************************/
		if(isRedirect) {
			response.sendRedirect(forwardPath);
		}else {
			RequestDispatcher rd=
					request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}
	}
	

}











