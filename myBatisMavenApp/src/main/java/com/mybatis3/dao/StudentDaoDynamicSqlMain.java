package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoDynamicSqlMain {

	public static void main(String[] args) {
		StudentDaoDynamicSql studentDaoDynamicSql=
				new StudentDaoDynamicSql();
		System.out.println("---------findAllStudentsOrder----------");
		System.out.println("###"+
				studentDaoDynamicSql.findAllStudentsOrder("studid"));
		System.out.println("###"+
				studentDaoDynamicSql.findAllStudentsOrder("name"));
		System.out.println("###"+
				studentDaoDynamicSql.findAllStudentsOrder(null));
		System.out.println("---------findStudents----------");
		Student findStudent=new Student();
		findStudent.setStudId(null);
		findStudent.setName(null);
		findStudent.setDob(null);
		findStudent.setEmail(null);
		System.out.println("###"+studentDaoDynamicSql.findStudents(findStudent));
		findStudent.setStudId(1);
		findStudent.setName("김");
		findStudent.setEmail("guard@gmail.com");
		findStudent.setDob(new Date());
		System.out.println("###"+studentDaoDynamicSql.findStudents(findStudent));
		findStudent.setStudId(null);
		findStudent.setName("김");
		findStudent.setEmail("guard@gmail.com");
		findStudent.setDob(null);
		System.out.println("###"+studentDaoDynamicSql.findStudents(findStudent));
		System.out.println("---------updateStudentById----------");
		Student updateStudent=
				new Student(1,"변경","change@email.com",new Date());
		System.out.println("###"+
				studentDaoDynamicSql.updateStudentById(updateStudent));
		updateStudent=
				new Student(3,"변경3","change3@email.com",null);
		System.out.println("###"+
				studentDaoDynamicSql.updateStudentById(updateStudent));
		System.out.println("---------findStudentsByNameLike----------");
		System.out.println("###"+
		studentDaoDynamicSql.findStudentsByNameLike("변"));
		
	}

}
