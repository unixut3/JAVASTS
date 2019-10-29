package com.itwill4.aop.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;
import com.itwill.user.exception.UserNotFoundException;

public class AopAnnotationMain {

	public static void main(String[] args) throws Exception {
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("/com/itwill4/aop/spring/4.aop.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserService userService = (UserService)applicationContext.getBean("userService");
		System.out.println("------------before advice---------");
		userService.findUserList();
		userService.findUser("userId");
		System.out.println("------------around advice---------");
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		userDao.create(new User());
		userDao.existedUser("userId");
		userDao.findUser("userId");
		
		
		
		
		System.out.println("------------after throwing advice---------");
	}

}
