<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>   
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%-- 붙어서 넘어온다 뭐가??
	request.setAttribute("price0", 21321321);
	request.setAttribute("name0", "춥다고 ㅆㅂ");
	
	request.setAttribute("price1", 18181818);
	request.setAttribute("name1", "짜증나네");
	request.setAttribute("married1", false);
	
	request.setAttribute("price2", 18181818);
	request.setAttribute("name2", "온도좀 높이자 ㅆㅂ");
	request.setAttribute("married2", true);
	
	request.setAttribute("guest", 
								new Guest(1, "짜증", new Date().toLocaleString(), 
								"dsds@naver.com", "www.naver.com", "sdsadsad", "2132132"));
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Spring CustromTag, SPEL</h1>
<p>
	-Spring Custom Tag : Spring에서 정의한 태그<br/>
	-SPEL(Spring Expression Language)
	Spring CustomTag 의 속성의 표현식
</p>
<ul>
	<li>문자열리터럴:<s:eval expression="'추우면 온도를 낮출 생각을 해야지'.substring(1)"></s:eval>></li>
	<li>숫자리터럴:<s:eval expression="1181818"></s:eval>></li>
	<li>논리리터럴:<s:eval expression="true"></s:eval>></li>
	<li>SPEL + EL(문자열 리터럴)<s:eval expression="'${name0}'.substring(1)"></s:eval></li>
	<li>SPEL + EL(숫자열 리터럴)<s:eval expression="${price0}"></s:eval></li>
	<li>SPEL(숫자열 리터럴)<s:eval expression="${price0}+1818"></s:eval></li>
	<li>SPEL(SCOPE객체에등록된 문자열리터럴):
		<s:eval expression="name0.replace('kim','hong').substring(4)"/>
	</li>
	<li>SPEL(SCOPE객체에등록된 숫자리터럴):
		<s:eval expression="price0/2"/>
	</li>
	<li>
		EL(SCOPE객체에등록된 빈객체(DTO)) : ${guest.guest_date.substring(0,4)} 
		  
	</li>
	<li>
		SPEL(SCOPE객체에등록된 빈객체(DTO)) :
		  <s:eval expression="guest.guest_date.substring(0,4)"/>
	</li>
	<li>
		클래스의 생성자 호출(EL에서는 생성자호출이 불가능) : 
		{new java.text.DecimalFormat('###,###.0').format(new Integer(price1))"}
	</li>
	<li>
		클래스의 생성자 호출(SPEL에서는 생성자호출이 가능) : 
		<s:eval expression="new java.text.DecimalFormat('###,###.0').format(new Integer(price1))"/><br/>
		<s:eval expression="new java.util.Date().toLocaleString()"></s:eval>
	</li>
	<li>
		@를 이용하여 SpringBean 사용가능(SPEL)
		- @elBean:<s:eval expression="@elBean.toString()"/><br/>
		- @elBean.member1:<s:eval expression="@elBean.member1"/><br/>
		- @elBean.printMembers():
		<s:eval expression="@elBean.printMembers()"/><br/>
	</li>
</ul>

</body>
</html>