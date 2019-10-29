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

public class DispatcherServletFirst2 extends HttpServlet {
		
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
		 * 2.클라이언트요청에따른 업무실행(Service)
		 */
		String forwardPath="";
		boolean isRedirect=false;
		if(command.equals("/guest_main.do")) {
			forwardPath="forward:/WEB-INF/view/guest_main.jsp";
		}else if(command.equals("/guest_list.do")) {
			try {
				GuestService guestService=new GuestService();
				ArrayList<Guest> guestList=guestService.selectAll();
				request.setAttribute("guestList",guestList);
				forwardPath="forward:/WEB-INF/view/guest_list.jsp";
			}catch (Exception e) {
				forwardPath="forward:/WEB-INF/view/guest_error.jsp";
				e.printStackTrace();
			}
		}else if(command.equals("/guest_view.do")) {
			String guest_noStr=request.getParameter("guest_no");
			if(guest_noStr==null||guest_noStr.equals("")){
				forwardPath="redirect:guest_main.do";
			}else {
				try {
					GuestService guestService=new GuestService();
					Guest guest = 
					guestService.selectByNo(Integer.parseInt(guest_noStr));
					if(guest==null){
						forwardPath="redirect:guest_list.do";
					}else {
						request.setAttribute("guest", guest);
						forwardPath="forward:/WEB-INF/view/guest_view.jsp";
					}
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/view/guest_error.jsp";
				}
			}
		}else if(command.equals("/guest_write_form.do")) {
			forwardPath="forward:/WEB-INF/view/guest_write_form.jsp";
		}else if(command.equals("/guest_write_action.do")) {
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
		}else if(command.equals("/guest_delete_action.do")) {
			
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				try {
					String guest_noStr=request.getParameter("guest_no");
					GuestService guestService=new GuestService();
					boolean deleteOK=
					guestService.deleteGuest(Integer.parseInt(guest_noStr));
					if(deleteOK){
						forwardPath="redirect:guest_list.do";
					}else{
						forwardPath="forward:/WEB-INF/view/guest_error.do";
					}
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/view/guest_error.jsp";
				}
			}
		}else if(command.equals("/guest_modify_form.do")) {
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
		}else if(command.equals("/guest_modify_action.do")) {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				try {
					String guest_noStr = request.getParameter("guest_no");
					String guest_name = request.getParameter("guest_name");
					String guest_email = request.getParameter("guest_email");
					String guest_homepage = request.getParameter("guest_homepage");
					String guest_title = request.getParameter("guest_title");
					String guest_content = request.getParameter("guest_content");
					GuestService guestService=new GuestService();
					Guest updateGuest=
					new Guest(
							Integer.parseInt(guest_noStr),
							guest_name,
							"",
							guest_email,
							guest_homepage,
							guest_title,
							guest_content);
					boolean updateOK = guestService.updateGuest(updateGuest);
					if(updateOK){
						forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
						//forwardPath="forward:guest_view.do";
					}else{
						forwardPath="redirect:guest_error.do";
					}
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/view/guest_error.jsp";
				}
			}
			
		}else {
			forwardPath="forward:/WEB-INF/view/guest_error.jsp";
		}
		/*
		 * 3. JSP로 forward or *.do redirect(forward)
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











