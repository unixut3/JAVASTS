package com.itwill.user.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;

@Component
public class UserServiceAnnotationClientMain {
	public static void main(String[] args) throws Exception{		
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("com/itwill/user/99.user_annotation.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserService userService2 = 
				(UserService)applicationContext.getBean("userService2");
		System.out.println(userService2);
		System.out.println("---------------findUserList---------------");
		System.out.println(userService2.findUserList());
		System.out.println("--------------create---------------");
		System.out.println(userService2.create(new User("aa", "aa", "aa", "aa")));
		System.out.println("------------findUser-------------");
		System.out.println(userService2.findUser("aa"));
		System.out.println("------------remove-------------");
		System.out.println(userService2.remove("aa"));
		
		UserService userService = 
				(UserService)applicationContext.getBean("userService");
		System.out.println(userService.create(null));
	}
}
