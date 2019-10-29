package com.mybatis3.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;
import com.mybatis3.mapper.StudentMapper;

public class MapperInterfaceStudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public MapperInterfaceStudentDao() {
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			this.sqlSessionFactory = 
					new SqlSessionFactoryBuilder()
					.build(in);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		StudentMapper studentMapper=
				sqlSession.getMapper(StudentMapper.class);
		System.out.println(studentMapper);
		Student findStudent =studentMapper.findStudentById(studId);
		sqlSession.close();
		return findStudent;
	}
	public List<Student> findAllStudents(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		StudentMapper studentMapper=
				sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = studentMapper.findAllStudents();
		sqlSession.close();
		return studentList;
		
	}
	
	
	
}
