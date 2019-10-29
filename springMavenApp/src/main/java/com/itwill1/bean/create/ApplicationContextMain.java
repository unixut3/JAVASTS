package com.itwill1.bean.create;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextMain {

	public static void main(String[] args) {
			/*
			 * ApplicationContext[BeanFactory]객체생성
			 */
			System.out.println("------------Spring Container 초기화시작---------");
			ApplicationContext applicationContext=
					new ClassPathXmlApplicationContext("com/itwill1/bean/create/1.bean_create.xml");
			System.out.println("------------Spring Container 초기화끝---------");
			CreateBean1 cb1 = 
					(CreateBean1)applicationContext.getBean("createBean1");	//id 이름 , 캐스팅필요
			cb1.method1();
		}

	}

