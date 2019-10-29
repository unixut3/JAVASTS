package com.mybatis3.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDaoDynamicSql {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.mapper.StudentMapperDynamicSql.";
	public StudentDaoDynamicSql() {
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
	public List<Student> findAllStudentsOrder(String columnName){
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.selectList(
						NAMESPACE+"findAllStudentsOrder",columnName);
		sqlSession.close();
		return studentList;
	}
	public List<Student> findStudents(Student student){
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.selectList(
						NAMESPACE+"findStudents",student);
		sqlSession.close();
		return studentList;
	}
	public List<Student> findStudentsByNameLike(String name){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.selectList(
						NAMESPACE+"findStudentsByNameLike",name);
		sqlSession.close();
		return studentList;
	}
	
	
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int updateRowCount=
				sqlSession.update(NAMESPACE+"updateStudentById", updateStudent);
		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}
	
}












