<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello_redirected_servlet.jsp</h1><hr/>
<ol>
	<li>/hello_redirect_servlet.do 요청</li>
	<li>redirect:hello_redirected_servlet.do 로 redirect 응답</li>
	<li>/hello_redirected_servlet.do 요청</li>
	<li>/WEB-INF/view/hello_redirected_servlet.jsp 로 forward</li>
	<li>/WEB-INF/view/hello_redirected_servlet.jsp 출력</li>
</ol>
</body>
</html>