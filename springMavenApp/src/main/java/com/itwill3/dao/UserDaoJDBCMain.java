package com.itwill3.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.UserDao;

public class UserDaoJDBCMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/3-2.user_dao_jdbc.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserDao userDao = 
				(UserDao)applicationContext.getBean("userDao");
		System.out.println(userDao.findUserList());
	}

}
