package com.itwill.spring.transaction;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDaoJdbcTemplateTestMain {

	public static void main(String[] args) {
		System.out.println("--------------conext 초기화시작------------");
		ApplicationContext context=
				new ClassPathXmlApplicationContext("spring_jdbctemplate_test.xml");
		System.out.println("--------------conext 초기화끝------------");
		
		EmployeeDao empDao=
				(EmployeeDao)context.getBean(EmployeeDao.class);
		System.out.println("--------insert---------");
		empDao.insert(new Employee(
						0, "김미숙", "mi@google.com", "111-2222", 0));
		System.out.println("--------update---------");
		empDao.update(new Employee(6, "육변경", "change@korea.com","666-6666", 6000));
		System.out.println("-------queryForObject[Employee]------");
		System.out.println(empDao.getPerson(1));
		System.out.println(empDao.getPerson(6));
		System.out.println("-------query[Employee List]------");
		System.out.println(empDao.list());
	}

}
