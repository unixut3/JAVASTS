package com.itwill.spring.transaction;

import java.util.*;

import org.springframework.context.support.*;

public class EmployeeServiceNoTransactionMain {

	public static void main(String[] args) {

		GenericApplicationContext context = 
			new GenericXmlApplicationContext(
					"spring-transaction-no.xml");
		
		EmployeeService service = 
			(EmployeeService)context.getBean("empService");
		
		List<Employee> emps = service.getEmps();
		
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
		try {
			service.increaseSalaryForAll();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("===================================");
		emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
	}

}







