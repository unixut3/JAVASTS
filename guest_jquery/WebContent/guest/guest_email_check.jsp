<%@ page language="java" contentType="text/plain; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String guest_email=request.getParameter("guest_email");
	
	if(guest_email==null){
		guest_email="";
	}
	String result="";
	if(!guest_email.startsWith("guard")){
		result="true";
	}else{
		result="false";
	}
	System.out.println("guest_email_check.jsp-->"+guest_email+":"+result);
%>
<%=result%>