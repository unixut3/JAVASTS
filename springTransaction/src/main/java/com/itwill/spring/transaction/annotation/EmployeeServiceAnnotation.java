package com.itwill.spring.transaction.annotation;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.spring.transaction.Employee;
@Transactional(propagation=Propagation.REQUIRED,
				isolation=Isolation.READ_COMMITTED)
public interface EmployeeServiceAnnotation {

	public abstract void registerEmployee(Employee emp);

	public abstract void deleteEmployee(int id);

	public abstract void udpateEmployee(Employee emp);

	public abstract List<Employee> getEmps();
	
	@Transactional(propagation = Propagation.REQUIRED)
	public abstract void increaseSalaryForAllTx();
	
	@Transactional(propagation = Propagation.REQUIRED)
	public abstract void increaseSalaryForAll();
	
	

}