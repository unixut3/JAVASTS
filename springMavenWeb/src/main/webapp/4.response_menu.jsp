﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>response_menu.jsp</h1><hr/>
	<ol>
		<li><a href='response_view_name.do'>Controller가 view name 을반환 [forward]</a></li>
		<li><a href='response_view_object.do'>Controller가 view 객체[InternalResourceView]를반환 [forward]</a></li>
		<li><a href='response_redirect_view_name.do'>Controller가 view name을반환 [redirect]</a></li>
		<li><a href='response_redirect_view_object.do'>Controller가 view 객체[RedirectView]을반환 [redirect]</a></li>
		<li><a href='response_xml_view_object.do'>Controller가 view 객체[XMLView]을반환 [출력]</a></li>
		<li><a href='response_xml_view_name.do'>Controller가 view name[xmlView]을반환 [출력]</a></li>
		<li><a href='response_string.do'>Controller가 응답 text데이타를반환[@ResponseBody]</a></li>
		<li><a href='response_html.do'>Controller가 응답 html데이타를반환[@ResponseBody]</a></li>
		<li><a href='response_xml.do'>Controller가 응답 Dto객체를반환[@ResponseBody]</a></li>
		
	</ol>
</body>
</html>