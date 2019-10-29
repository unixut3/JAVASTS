<%@page import="com.itwill.guest.Guest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg="";
	int status=0;
	ArrayList<Guest> guestList=null;
	try{
		GuestService guestService=new GuestService();
		guestList = guestService.selectAll();
		status=0;
		msg="";
	}catch(Exception e){
		e.printStackTrace();
		msg=e.getMessage();
		status=1;
	}
%>    
<result>
	<status><%=status%></status>
	<msg><%=msg%></msg>
	<data>
		<guestList>
			<%
			for(int i=0;i< guestList.size();i++){
				Guest guest=guestList.get(i);
			%>
			<guest no="<%=guest.guest_no%>" >
				<guest_name><%=guest.guest_name%></guest_name>
				<guest_date><%=guest.guest_date%></guest_date>
				<guest_email><%=guest.guest_email%></guest_email>
				<guest_homepage><%=guest.guest_homepage%></guest_homepage>
				<guest_title><%=guest.guest_title%></guest_title>
				<guest_content><%=guest.guest_content%></guest_content>
			</guest>
			<%}%>
		</guestList>
	</data>
</result>