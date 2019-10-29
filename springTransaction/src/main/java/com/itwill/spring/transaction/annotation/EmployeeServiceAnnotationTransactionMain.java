package com.itwill.spring.transaction.annotation;

import java.util.List;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.itwill.spring.transaction.Employee;

public class EmployeeServiceAnnotationTransactionMain {

	public static void main(String[] args) {

		GenericApplicationContext context = 
			new GenericXmlApplicationContext("spring-transaction-by-annotation.xml");

		EmployeeServiceAnnotation service = 
			(EmployeeServiceAnnotation)context.getBean("empServiceAnnotation");
		
		List<Employee> emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
		try {
			//service.increaseSalaryForAllTx();
			service.increaseSalaryForAll();
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







