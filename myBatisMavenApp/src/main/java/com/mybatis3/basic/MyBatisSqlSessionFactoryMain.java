package com.mybatis3.basic;

import org.apache.ibatis.session.SqlSession;

import com.mybatis3.domain.Student;

public class MyBatisSqlSessionFactoryMain {

	public static void main(String[] args) throws Exception{
		/*********MyBatisSqlSessionFactory 의사용*****************/
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
		Student student=sqlSession.selectOne(
				"com.mybatis3.mapper.StudentMapper.findStudentById",2);
		System.out.println("### "+student);
		/***************************************/
		
	}

}
