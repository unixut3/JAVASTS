package com.itwill1.bean.attr;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextMain {

	public static void main(String[] args) throws Exception {
			/*
			 * ApplicationContext[BeanFactory]객체생성
			 */
			System.out.println("------------Spring Container 초기화시작---------");
			ApplicationContext applicationContext=
					new ClassPathXmlApplicationContext("com/itwill1/bean/attr/1.bean_attr.xml");
			System.out.println("------------Spring Container 초기화끝---------");
			
			System.out.println("------------1. lazyInit---------");
			LazyInitBean lazyInitBean = 
					(LazyInitBean)applicationContext.getBean("lazyInitBean");
			System.out.println("###"+lazyInitBean);
			
			System.out.println("------------2.scope(singleton)---------");
			SingletonScopeBean singletonBean1 = 
					(SingletonScopeBean)applicationContext.getBean("singletonBean");
			SingletonScopeBean singletonBean2 = 
					(SingletonScopeBean)applicationContext.getBean("singletonBean");
			SingletonScopeBean singletonBean3 = 
					(SingletonScopeBean)applicationContext.getBean("singletonBean");
			System.out.println("### "+singletonBean1);
			System.out.println("### "+singletonBean2);
			System.out.println("### "+singletonBean3);
			
			System.out.println("------------3.scope(prototype)---------");
			PrototypeScopeBean prototypeScopeBean1 = 
					(PrototypeScopeBean)applicationContext.getBean("prototypeBean");
			PrototypeScopeBean prototypeScopeBean2 = 
					(PrototypeScopeBean)applicationContext.getBean("prototypeBean");
			PrototypeScopeBean prototypeScopeBean3 = 
					(PrototypeScopeBean)applicationContext.getBean("prototypeBean");
			System.out.println("### "+prototypeScopeBean1);
			System.out.println("### "+prototypeScopeBean2);
			System.out.println("### "+prototypeScopeBean3);
			
			DisposableBean context = (DisposableBean)applicationContext;
			context.destroy();
			
			
		}

	}

