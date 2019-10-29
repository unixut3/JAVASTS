package com.itwill4.aop.spring.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class EmailSendAfterThrowingAnnotationAdvice {
	/*
	<aop:aspect ref="emailSendAfterThrowingAdvice">
			<aop:after-throwing
				pointcut-ref="emailSendAfterThrowingPointcut"
				method="emailSend"
				throwing="exObj"/>
	</aop:aspect>
	 */
	
	@AfterThrowing(pointcut="emailSendAfterThrowingPoingcut" , throwing="exObj")
	public void emailSend(JoinPoint jp, Exception exObj) {
		
		System.out.println("###[AfterThrowing](Annotation)예외발생시 이메일 전송("+exObj+")");
		
	}
	@Pointcut(value="within(com.itwill.user.*)")
	public void emailSendAfterThrowingPoingcut() {
		
	}
	
}
