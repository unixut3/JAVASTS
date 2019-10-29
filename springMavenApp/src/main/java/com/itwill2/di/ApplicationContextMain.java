package com.itwill2.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class ApplicationContextMain {

	public static void main(String[] args) throws Exception{
			/*
			 * ApplicationContext[BeanFactory]객체생성
			 */
			System.out.println("------------Spring Container 초기화시작---------");
			ApplicationContext applicationContext=
					new ClassPathXmlApplicationContext("com/itwill2/di/2.bean_dependency.xml");
			System.out.println("------------Spring Container 초기화끝---------");
			System.out.println("###"+applicationContext);
			
			System.out.println("--------------constructor injection-----------");
			System.out.println("1.기본형");
			User user0 = (User)applicationContext.getBean("contsructorUser0");
			User user1 = (User)applicationContext.getBean("contsructorUser1");
			User user2 = (User)applicationContext.getBean("contsructorUser2");
			System.out.println("### "+user0);
			System.out.println("### "+user1);
			System.out.println("### "+user2);
			System.out.println("2.참조형");
			UserService userService1 = 
					(UserService)applicationContext.getBean("userService1");
			userService1.create(null);
			userService1.findUser("");
			UserService userService2 = 
					(UserService)applicationContext.getBean("userService2");
			userService2.create(null);
			userService2.findUser("");
			
			System.out.println("--------------setter injection-----------");
			System.out.println("1.기본형");
			User setUser1 = (User)applicationContext.getBean("setUser1");
			User setUser2 = (User)applicationContext.getBean("setUser2");
			System.out.println(setUser1);
			System.out.println(setUser2);
			System.out.println("2.참조형");
			UserService userService3 = 
					(UserService)applicationContext.getBean("userService3");
			userService3.create(null);
			userService3.findUser("");
		}

	}

