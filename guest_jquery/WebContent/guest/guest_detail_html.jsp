<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--@include file="loginCheck.jspf" --%>	
<%
    String guest_no = request.getParameter("guest_no");
	if(guest_no==null||guest_no.equals(""))guest_no="207";
	String method=request.getMethod();
	System.out.println("*********jQuery Ajax��û����*********");
	System.out.println("0.jQuery Ajax��ûURL    :" + request.getRequestURI());
	System.out.println("1.jQuery Ajax��û���    :"+method);
	System.out.println("2.jQuery Ajax��û�Ķ��Ÿ:"+guest_no);
	System.out.println("*************************************");	
	GuestDao dao = new GuestDao();
	Guest guest = dao.selectByNo(Integer.parseInt(guest_no.trim()));
%>
	<div class="guest_date">
		��¥:<%=guest.getGuest_date()%>
	</div>
	<div class="guest_name">
		�̸�:<%=guest.getGuest_name()%>
	</div>
	<div class="guest_email">
		�̸���:<%=guest.getGuest_email()%>
	</div>
	<div class="guest_homepage">
		Ȩ������:<%=guest.getGuest_homepage()%>
	</div>
	<div class="guest_content">
		����:<%=guest.getGuest_content()%>
	</div>
	
	
	

	
	
	
	
	
	
	
	
	
	
	