package com.itwill3.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserDao;

public class UserDaoMybatisMain {

	public static void main(String[] args) throws Exception{
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill3/dao/3-3.user_dao_mybatis.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserDao userDao = 
				(UserDao)applicationContext.getBean("userDao");
	System.out.println("-------------findUser-----------------");
	System.out.println(userDao.findUser("k"));
	System.out.println("-------------findUserList-----------------");
	System.out.println(userDao.findUserList());
		

	}

}
