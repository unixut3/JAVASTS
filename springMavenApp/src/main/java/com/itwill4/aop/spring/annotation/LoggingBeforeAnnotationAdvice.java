package com.itwill4.aop.spring.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 메소드 실행전 로그출력
 */
@Component
@Aspect
public class LoggingBeforeAnnotationAdvice {
	
	@Before(value="execution(* com.itwill.user.UserService.find*(..))")
	public void beforeLog(JoinPoint jp) {
		/*
		<aop:aspect ref="loggingBeforeAdvice">
				<aop:before method="beforeLog" 
							pointcut="execution(* com.itwill.user.UserService.find*(..))"/>
		</aop:aspect>
		*/
		System.out.println("###[사전충고](Annotation)메소드가 호출되기전에 필요한 작업처리(log)");
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
		System.out.println("###[사전충고](Annotation)"+className+". "+methodName+"("+args+")");
		
	}

}
