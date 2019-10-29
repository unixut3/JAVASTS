package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentById-------");
		System.out.println("###"+studentDao.findStudentById(3));
		System.out.println("-------findStudentNameById-------");
		System.out.println("###"+studentDao.findStudentNameById(3));
		System.out.println("-------findStudentByIdResultMap-------");
		System.out.println("###"+studentDao.findStudentByIdResultMap(3));
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("---------findStudentByIdWithAddressResultMap----------");
		System.out.println("###"+studentDao.findStdentByIdWithAddressResultMap(1));
		System.out.println("---------findStudentByIdWithAddressNestedSelectResultMap-----------");
		System.out.println("###"+studentDao.findStudentByIdWithAddressNestedSelectResultMap(1));
		
		System.out.println("---------findAllStudents---------");
		System.out.println("###"+studentDao.findAllStudents());
		System.out.println("---------findAllStudentsResultMap---------");
		System.out.println("###"+studentDao.findAllStudentsResultMap());
		System.out.println("---------findAllStudentsWithAddressResultMap-----------");
		System.out.println("###"+studentDao.findAllStudentsWithAddressResultMap());

		
		//Student insertStudent=
		//		new Student(888, "팔팔팔", "pal@mail.com", new Date());
		//System.out.println("###"+studentDao.insertStudent(insertStudent));
		System.out.println("---------insertStudentBySequence1---------");
		Student student1=new Student(0, "김", "kim@mail.com", new Date());
		//System.out.println("###"+studentDao.insertStudentBySequence1(student1));
		System.out.println("###"+student1);
		System.out.println("---------insertStudentBySequence2---------");
		Student student2=new Student(0, "이", "lee@mail.com", new Date());
		//System.out.println("###"+studentDao.insertStudentBySequence2(student2));
		System.out.println("###"+student2);
		System.out.println("---------updateStudent-------------------");
		student2.setName("이변경");
		student2.setEmail("이메일변경");
		student2.setDob(new Date(2000-1900, 0, 23));
		System.out.println("###"+studentDao.updateStudent(student2));
		System.out.println("---------updateStudentDynamicSql---------");
		System.out.println("---------delete Student------------------");
		//System.out.println("### delete rowcount:"+studentDao.deleteStudentById(1));
		//System.out.println("### delete rowcount:"+studentDao.deleteStudentByName("이"));
		System.out.println("---------findStudentCount----------------");

	}
}
