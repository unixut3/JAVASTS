package com.mybatis3.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Tutor;

public class TutorDao 
{
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.mapper.TutorMapper.";
	public TutorDao() {
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = 
					new SqlSessionFactoryBuilder()
					.build(in);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Tutor findTutorById(Integer turorId) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Tutor findTutor=
				sqlSession.selectOne(NAMESPACE+"findTutorById",turorId);
		sqlSession.close();
		return findTutor;
	}
	public Tutor findTutorByIdWithAddressAndCourses(Integer turorId) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Tutor findTutor=
				sqlSession.selectOne(
					NAMESPACE+"findTutorByIdWithAddressAndCourses",turorId);
		sqlSession.close();
		return findTutor;
	}
	
	
}













