package com.mybatis3.basic;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class MyBatisFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0.mybatis-config.xml -->InputStream
		 */
		InputStream myBatisConfigInputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		/*
		 * 1.SqlSesssionFactoryBuilder		
		 */
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		/*
		 * 2.SqlSesssionFactory
		 */
		SqlSessionFactory ssf =  ssfb.build(myBatisConfigInputStream);
		/*
		 * 3.SqlSession
		 */
		SqlSession sqlSession = ssf.openSession();
		/*
		 * 4.SqlSession사용
		 */
		Student student = sqlSession.selectOne(
				"com.mybatis3.mapper.StudentMapper.findStudentById",
				new Integer(3));
		System.out.println("####"+student);
		sqlSession.close();
	}
}









