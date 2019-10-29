package com.itwill.spring.transaction;

import java.util.*;

import org.springframework.context.support.*;


public class EmployeeServiceTransactionXMLFileTxMain {

	public static void main(String[] args) {

		GenericApplicationContext context = 
			new GenericXmlApplicationContext("spring-transaction-by-xml-file-tx.xml");

		EmployeeService service = 
			(EmployeeService)context.getBean("empService");
		
		List<Employee> emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
		
		
		try {
			service.increaseSalaryForAllTx();
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







