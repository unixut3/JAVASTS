package com.itwill4.aop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.UserNotFoundException;

public class AopMain {

	public static void main(String[] args) throws Exception {
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("/com/itwill4/aop/spring/4.aop.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserService userService = (UserService)applicationContext.getBean("userService");
		System.out.println("------------before advice---------");
		System.out.println("------------around advice---------");
		userService.findUser("userId");
		userService.findUserList();
		userService.login("id", "pass");
		userService.remove("userId");
		userService.create(new User());
		
		System.out.println("------------after throwing advice---------");
		userService.update(new User());
	}

}
