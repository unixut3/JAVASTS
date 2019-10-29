package com.itwill4.aop.java;

public class MemberServiceSpringProxy implements MemberService {
	private MemberService memberService;
	private LoggingBeforeAdvice loggingBeforeAdvice;
	
	public MemberServiceSpringProxy(MemberService memberService, LoggingBeforeAdvice loggingBeforeAdvice) {
		this.memberService=memberService;
		this.loggingBeforeAdvice=loggingBeforeAdvice;
	}
	
	
	@Override
	public void create() {
		loggingBeforeAdvice.beforeLog();
		memberService.create();
	}
	@Override
	public void login() {
		loggingBeforeAdvice.beforeLog();
		memberService.login();
	}
	@Override
	public void list() {
		loggingBeforeAdvice.beforeLog();
		memberService.list();
	}
	@Override
	public void view() {
		loggingBeforeAdvice.beforeLog();
		memberService.view();
	}
}
