<%@page import="com.itwill.guest.GuestService"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Guest Web Test</h1><hr/>
<%
	WebApplicationContext wac = 
		WebApplicationContextUtils.getWebApplicationContext(application);
	DataSource dataSouce=(DataSource)wac.getBean("dataSource");
	GuestService guestService=(GuestService)wac.getBean("guestService");
%>
<ol>
	<li>Connection:<%=dataSouce.getConnection() %></li>
	<li>GuestService:<%=guestService.selectAll()%></li>
</ol>
</body>
</html>