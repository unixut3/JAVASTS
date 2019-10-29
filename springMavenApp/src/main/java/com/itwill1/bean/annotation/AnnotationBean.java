package com.itwill1.bean.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("annotationBean")
@Lazy
@Scope("singleton")
//@Scope("prototype")
//@DependsOn("beanid")
public class AnnotationBean {
	public AnnotationBean() {
		System.out.println("### AnnotationBean()생성자");
	}
	@PostConstruct
	public void myInit() {
		System.out.println("### AnnotationBean.myInit() 메소드");
	}
	@PreDestroy
	public void myDestroy() {
		System.out.println("### AnnotationBean.myDesroy() 메소드");
	}
}
