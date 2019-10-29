<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int status=0;
	String msg="";
	StringBuffer data=new StringBuffer();
	if(request.getMethod().equalsIgnoreCase("GET")){
		status=1;
		msg="잘못된 요청입니다.";
		data.append("[]");
	}else{
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
			status=0;
			msg="방명록쓰기성공";
			data.append("[]");
		}else{
			status=2;
			msg="방명록쓰기실패";
			data.append("[]");
		}
	}
%>	
{
	"status":<%=status%>,
	"msg":"<%=msg %>",
	"data":<%=data.toString()%>
}











