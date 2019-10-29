package com.itwill.user.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;

public class UserServiceClientMain {
	public static void main(String[] args) throws Exception{		
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("com/itwill/user/99.user.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserService userService = 
				(UserService)applicationContext.getBean("userService");
		System.out.println("---------------findUserList---------------");
		System.out.println(userService.findUserList());
		System.out.println("--------------create---------------");
		System.out.println(userService.create(new User("aa", "aa", "aa", "aa")));
		System.out.println("------------findUser-------------");
		System.out.println(userService.findUser("aa"));
		System.out.println("------------remove-------------");
		System.out.println(userService.remove("aa"));
	}
}
