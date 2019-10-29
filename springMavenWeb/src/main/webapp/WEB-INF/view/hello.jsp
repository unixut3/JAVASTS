<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello1.jsp</h1><hr/>
<ul>
	<li>/hello1.do요청</li>
	<li>DispatcherServlet실행</li>
	<li>DispatcherServlet이 HandlerMapping객체로부터 요청url[/hello1.do]에 해당하는 HelloAnnotationController1 객체 얻기</li>
	<li>DispatcherServlet이 HelloAnnotationController1객체의 mapping된 hello1() 메소드를 실행</li>
	<li>DispatcherServlet이 HelloAnnotationController1객체의 handleRequest()메소드를 실행 후 반환된 path로 forwarding</li>
	<li>/WEB-INF/view/hello1.jsp 응답</li>
	<li></li>
</ul>
</body>
</html>