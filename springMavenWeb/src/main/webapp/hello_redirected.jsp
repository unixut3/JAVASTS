<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello_redirected.jsp</h1><hr/>
<ol>
	<li>/hello_redirect_jsp.do</li>
	<li>HelloAnnotationMultiRequestMapperingController 객체의 hello_redirected_jsp() 메소드 실행</li>
	<li>HelloAnnotationMultiRequestMapperingController 객체의 hello_redirected_jsp() 메소드 실행결과
	[redirect:hello_redirected.jsp]를 DispatchterServlet에 반환</li>
	<li>DispatchterServlet hello_redirected.jsp로 redirect</li>
</ol>
</body>
</html>