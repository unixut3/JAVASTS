package com.itwill4.aop.spring.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Component
@Aspect
public class ProfilingAroundAnnotationAdvice {
	/*
	<aop:aspect ref="profilingAroundAdvice">
			<aop:around method="aroundProfiling" 
						pointcut="execution(* *..UserDao.*(..))"/>
	</aop:aspect>
	 */
	@Around(value="excution(* *..UserDao.*(..))")
	public Object aroundProfiling(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("###[AoundAdvice]메소드 호출전에 필요한 작업기술");
		
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		Object returnObject = pjp.proceed();// target객체메쏘드호출
		stopWatch.stop();
		long duration = stopWatch.getTotalTimeMillis();
		/*****************************************/
		Object targetObject = pjp.getTarget();
		String className = targetObject.getClass().getName();
		String methodName = pjp.getSignature().getName();
		Object[] argsObjects = pjp.getArgs();
		int argCount = 0;
		if (argsObjects != null) {
			argCount = argsObjects.length;
		}
		String args = "";
		for (int i = 0; i < argCount; i++) {
			String argClassName = argsObjects[i].getClass().getName();
			args += argClassName;
			if (i != argCount - 1)
				args += ",";

		}
		String profilingMsg=className+"."+methodName+"("+args+")"+ duration+" ms took";
//		if(duration >100) {
		System.out.println("###[AroundAdvice]"+profilingMsg);
//		}
		/*****************************************/
		
		System.out.println("###[AoundAdvice](Annotation)메소드 호출후에 필요한 작업기술");
		
		return returnObject;
		
	}
}
