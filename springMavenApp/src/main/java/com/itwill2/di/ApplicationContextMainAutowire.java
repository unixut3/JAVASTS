package com.itwill2.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class ApplicationContextMainAutowire {

	public static void main(String[] args) throws Exception{
			/*
			 * ApplicationContext[BeanFactory]객체생성
			 */
			System.out.println("------------Spring Container 초기화시작---------");
			ApplicationContext applicationContext=
					new ClassPathXmlApplicationContext("com/itwill2/di/2.bean_dependency_autowire.xml");
			System.out.println("------------Spring Container 초기화끝---------");
			System.out.println("###"+applicationContext);
			System.out.println("------------Autowire byName---------");
			UserService byNameUserService = 
					(UserService)applicationContext.getBean("byNameUserService");
			byNameUserService.create(null);
			byNameUserService.findUser("");
			
			System.out.println("------------Autowire byType---------");
			UserService byNameUserService1 = 
					(UserService)applicationContext.getBean("byTypeUserService");
			byNameUserService1.create(null);
			byNameUserService1.findUser("");
			System.out.println("------------Autowire constructor---------");
			UserService byNameUserService2 = 
					(UserService)applicationContext.getBean("constructorUserService");
			byNameUserService2.create(null);
			byNameUserService2.findUser("");
		}

	}

