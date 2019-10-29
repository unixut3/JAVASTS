package com.itwill4.aop.java;

public class MemberServiceMain {

	public static void main(String[] args) {
		System.out.println("-------no weaving---------");
		MemberService memberService = new MemberServiceImpl();
		memberService.create();
		memberService.login();
		memberService.list();
		memberService.view();
		System.out.println("-------no weaving---------");

		MemberService memberServiceProxy = new MemberServiceSpringProxy(new MemberServiceImpl(), new LoggingBeforeAdvice());
		memberServiceProxy.create();
		memberServiceProxy.login();
		memberServiceProxy.list();
		memberServiceProxy.view();
		
	}

}
