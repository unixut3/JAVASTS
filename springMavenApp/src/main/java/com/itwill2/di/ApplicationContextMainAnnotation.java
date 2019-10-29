package com.itwill2.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class ApplicationContextMainAnnotation {

	public static void main(String[] args) throws Exception{
			/*
			 * ApplicationContext[BeanFactory]객체생성
			 */
			System.out.println("------------Spring Container 초기화시작---------");
			ApplicationContext applicationContext=
					new ClassPathXmlApplicationContext("com/itwill2/di/2.bean_dependency_annotation.xml");
			System.out.println("------------Spring Container 초기화끝---------");
			UserService userService = 
					(UserService)applicationContext.getBean("userService");
			userService.create(null);
			userService.findUser("");
		}

	}

