package com.itwill3.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataSourseMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext[BeanFactory]객체생성
		 */
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill3/dao/3-1.spring_datasourse.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		DataSource apacheDataSource = 
				(DataSource)applicationContext.getBean("apacheDataSourse");
		System.out.println("### ApacheDataSourse Connection: "+ apacheDataSource.getConnection());
		DataSource springDataSource = 
				(DataSource)applicationContext.getBean("springDataSource");
		System.out.println("### SpringDataSource Connection: "+ springDataSource.getConnection());
	}

}
