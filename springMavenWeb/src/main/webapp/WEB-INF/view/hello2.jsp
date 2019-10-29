<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello2.jsp</h1><hr/>
<ol>
	<li>/hello2.do요청</li>
	<li>DispatcherServlet실행</li>
	<li>
		DispatcherServlet이 HandlerMapping객체로부터 요청url[/hello2.do]에
		해당하는 HelloAnnotationController2객체얻기
	</li>
	<li>
		DispatcherServlet이 HelloAnnotationController2객체의 
		mapping된  hello2() 메쏘드실행
	</li>
	<li>
		DispatcherServlet이 HelloAnnotationController2객체의 
		mapping된  hello2() 메쏘드실행후 반환된 String path로 
		forwarding[forward:/WEB-INF/view/hello1.jsp]
	</li>
	<li>/WEB-INF/view/hello2.jsp 응답</li>
	
</ol>
</body>
</html>










