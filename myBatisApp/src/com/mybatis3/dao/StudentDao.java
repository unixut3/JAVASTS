package com.mybatis3.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.mapper.StudentMapper.";
	public StudentDao() {
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
	/*
	 * selectOne(resultType): Student[DTO]
	 */
	public Student findStudentById(Integer studId) {
		/*
		 * true  : autocommit true
		 * 	   sqlSession.close();		
		 * false : autocommit false
		 *     sqlSession.commit();
		 *     sqlSession.close();
		 */
		SqlSession sqlSession=null;
		Student findStudent=null;
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			
			findStudent = 
					sqlSession.selectOne(NAMESPACE+"findStudentById", studId);
		}finally {
			sqlSession.close();
		}
		return  findStudent;
		
	}
	/*
	 * selectOne(resultType): String
	 */
	public String findStudentNameById(Integer studId) {
		SqlSession sqlSession=null;
		String findStudentName=null;
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			
			findStudentName = 
					sqlSession.selectOne(NAMESPACE+
							"findStudentNameById", studId);
		}finally {
			sqlSession.close();
		}
		return  findStudentName;
		
	}
	/*
	 * selectOne(resultType): HashMap
	 */
	public HashMap findStudentByIdMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		HashMap studentMap = sqlSession.selectOne(
				NAMESPACE+"findStudentByIdMap",studId);
		sqlSession.close();
		return studentMap;
	}
	
	/*
	 * selectOne(resultMap): Student(DTO)
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession=null;
		Student findStudent=null;
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			
			findStudent = 
					sqlSession.selectOne(NAMESPACE+
							"findStudentByIdResultMap", studId);
		}finally {
			sqlSession.close();
		}
		return  findStudent;
		
	}
	/*
	 * selectOne(resultMap): Student DTO[students + addresses 조인]
	 */
	public Student findStdentByIdWithAddressResultMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Student findStudent = sqlSession.selectOne(
				NAMESPACE+"findStudentByIdWithAddressResultMap",studId);
		sqlSession.close();
		return findStudent;
	}
	/*
	 * selectOne(resultMap): Student DTO[students + addresses 조인아님]
	 */
	public Student findStudentByIdWithAddressNestedSelectResultMap(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Student findStudent = sqlSession.selectOne(
				NAMESPACE+"findStudentByIdWithAddressNestedSelectResultMap",studId);
		sqlSession.close();
		return findStudent;
	}
	
	/*
	 * selectList(resultType): Student[DTO]
	 */
	public List<Student> findAllStudents(){
		SqlSession sqlSession = 
				sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudents");
		sqlSession.close();
		return studentList;
		
	}
	/*
	 * selectList(resultType): HashMap List
	 */
	public List<HashMap> findAllStudentsMap(){
		SqlSession sqlSession = 
				sqlSessionFactory.openSession();
		List<HashMap> studentMapList=
				sqlSession.selectList(NAMESPACE+"findAllStudentsMap");
		sqlSession.close();
		return studentMapList;
		
	}
	/*
	 * selectList(resultMap): Student[DTO]
	 */
	public List<Student> findAllStudentsResultMap(){
		SqlSession sqlSession = 
				sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudentsResultMap");
		sqlSession.close();
		
		return studentList;
		
	}
	/*
	 * selectList(resultMap): Student[DTO] List [students + addresses 조인]
	 */
	public List<Student> findAllStudentsWithAddressResultMap(){
		SqlSession sqlSession = 
				sqlSessionFactory.openSession();
		List<Student> studentList=
				sqlSession.selectList(NAMESPACE+"findAllStudentsWithAddressResultMap");
		sqlSession.close();
		
		return studentList;
		
	}
	
	/*
	 * insert(parameterType): Student
	 */
	public int insertStudent(Student student) {
		//auto commit false
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int insertRowCount=
				sqlSession.insert(NAMESPACE+"insertStudent",student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
		
	}
	public int insertStudentBySequence1(Student student) {
		//auto commit false
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int insertRowCount=
				sqlSession.insert(NAMESPACE+"insertStudentBySequence1",student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
		
	}
	public int insertStudentBySequence2(Student student) {
		//auto commit false
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int insertRowCount=
				sqlSession.insert(NAMESPACE+"insertStudentBySequence2",student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
		
	}
	/*
	 * delete(parameterType): int,String
	 */
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=
				sqlSession.delete(NAMESPACE+"deleteStudentById", studId);
		sqlSession.close();
		return deleteRowCount;
	}
	public int deleteStudentByName(String name) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=
				sqlSession.delete(NAMESPACE+"deleteStudentByName", name);
		sqlSession.close();
		return deleteRowCount;
	}
	/*
	 * update(parameterType): Student
	 */
	public int updateStudent(Student updateStudent) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int updateRowCount=
				sqlSession.update(NAMESPACE+"updateStudent", updateStudent);
		sqlSession.close();
		return updateRowCount;
	}
	
}












