<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring I18N[Internationalization]</h1>
<xmp>
	1. application-config.xml파일에 messageSource빈 설정
	<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basenames">
			<list>
				<value>messages/guest</value>
				<value>messages/user</value>
				<value>messages/messages</value>
			</list>
		</property>
		<!-- 아래와 같은 방법으로도 가능함 
		<property name="basenames" value="messages/guest,messages/user,messages/messages"></property>
		 -->
	</bean>
</xmp>
<ol>
	<li><s:message code="page.title"/></li>
	<li><s:message code="button.login"/></li>
</ol>
</body>
</html>