package com.itwill4.aop.spring;

import org.aspectj.lang.JoinPoint;

/*
 * 메소드 실행전 로그출력
 */
public class LoggingBeforeAdvice {
	
	public void beforeLog(JoinPoint jp) {
		System.out.println("###[사전충고]메소드가 호출되기전에 필요한 작업처리(log)");
		Object targetObject = jp.getTarget();
		String className = targetObject.getClass().getName();
		String methodName = jp.getSignature().getName();
		Object[] argsObjects =  jp.getArgs();
		int argCount = 0;
		if(argsObjects !=null) {
			argCount = argsObjects.length;
		}
		String args="";
		for (int i = 0; i < argCount; i++) {
			String argClassName = argsObjects[i].getClass().getName();
			args += argClassName;
			if(i!=argCount-1) 
				args += ",";
		}
		System.out.println("###[사전충고]"+className+". "+methodName+"("+args+")");
		
	}

}
