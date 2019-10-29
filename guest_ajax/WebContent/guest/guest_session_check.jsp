<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String isLogin="fail";
	String user_id=(String)session.getAttribute("user_id");
	if(user_id != null){
		isLogin="success";
	}
%>
<%=isLogin%>