package com.itwill4.aop.spring;

import org.aspectj.lang.JoinPoint;

public class EmailSendAfterThrowingAdvice {

	public void emailSend(JoinPoint jp, Exception exObj) {
		System.out.println("###[AfterThrowing]예외발생시 이메일 전송("+exObj+")");
		
		
	}
	
}
