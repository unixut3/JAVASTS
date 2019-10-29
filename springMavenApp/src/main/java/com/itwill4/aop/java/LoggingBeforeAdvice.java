package com.itwill4.aop.java;
/*
 * 메소드 실행전 로그출력
 */
public class LoggingBeforeAdvice {
	
	public void beforeLog() {
		System.out.println("###[사전충고]메소드가 호출되기전에 필요한 작업처리(log)");
	}

}
