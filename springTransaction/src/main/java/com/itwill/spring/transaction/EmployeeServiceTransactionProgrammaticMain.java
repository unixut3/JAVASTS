package com.itwill.spring.transaction;

import java.util.*;

import org.springframework.context.support.*;

public class EmployeeServiceTransactionProgrammaticMain {

	public static void main(String[] args) {

		GenericApplicationContext context = 
			new GenericXmlApplicationContext("spring-transaction-by-programmatic.xml");

		EmployeeService service = 
			(EmployeeService)context.getBean("empService");
		
		List<Employee> emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
		try {
			service.increaseSalaryForAllProgrammaticTx();
			//service.increaseSalaryForAll();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		System.out.println("===================================");
		
		emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
		
	}

}







