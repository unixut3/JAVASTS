package com.itwill.spring.transaction.annotation;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.spring.transaction.Employee;


@Component("empServiceAnnotation")
public class EmployeeServiceImplAnnotation implements EmployeeServiceAnnotation {
	@Autowired
	private EmployeeDaoAnnotation employeeDao;
	public void setEmployeeDao(EmployeeDaoAnnotation employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void registerEmployee(Employee person) {
		employeeDao.insert(person);
	}

	public void deleteEmployee(int idx) {
		employeeDao.delete(idx);
	}

	public void udpateEmployee(Employee emp) {
		employeeDao.update(emp);
	}

	public List<Employee> getEmps() {
		return employeeDao.list();
	}
	@Transactional( propagation=Propagation.REQUIRED, 
            	 	isolation=Isolation.READ_COMMITTED, 
            	 	timeout=10, 
            	 	readOnly=false, 
            	 	rollbackFor = Exception.class 
            	   )
	
	public void increaseSalaryForAllTx() {
		List<Employee> emps = getEmps();
		int index = 1;
		for (Employee emp : emps) {
			employeeDao.increaseSalary(						
				emp.getId(),  50);
			index++;
			if (index == 3) {
				throw new RuntimeException(">>>throw exception");
			}				
		}
		
		
	}
	
	public void increaseSalaryForAll() {
		List<Employee> emps = getEmps();
		int index = 1;
		for (Employee emp : emps) {
			employeeDao.increaseSalary(						
				emp.getId(), 50);
			index++;
			if (index == 3) {
				throw new RuntimeException("throw exception");
			}				
		}
	}

	public void increaseSalaryForAllProgrammaticTx() {
		// TODO Auto-generated method stub
		
	}

	
}
