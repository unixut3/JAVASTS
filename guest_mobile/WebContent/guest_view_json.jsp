<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int status=0;
	String msg=""; 
	String data="";
	String guest_noStr=request.getParameter("guest_no");
	guest_noStr="124";
	if(guest_noStr==null||guest_noStr.equals("")){
		status=1;
		msg="아이디가 없어요";
		data="[]";
	}else{
		GuestService guestService=new GuestService();
		Guest guest = 
		guestService.selectByNo(Integer.parseInt(guest_noStr));
		if(guest==null){
			status=2;
			msg="존재하지않는 아이디 입니다.";
			data="[]";
		}else{
			status=0;
			msg="";
			StringBuffer sb=new StringBuffer();
			sb.append("[{");
			sb.append("\"guest_no\":"+guest.guest_no+",");
			sb.append("\"guest_name\":\""+guest.guest_name+"\",");
			sb.append("\"guest_date\":\""+guest.guest_date.substring(0,10)+"\",");
			sb.append("\"guest_email\":\""+guest.guest_email+"\",");
			sb.append("\"guest_title\":\""+guest.guest_title+"\",");
			sb.append("\"guest_content\":\""+guest.guest_content+"\"");
			sb.append("}]");
			data=sb.toString();
		}
	}
	
%>
{
	"status":<%=status%>,
	"msg":"<%=msg%>",
	"data":<%=data%>
}