package com.itwill.spring.transaction;

import java.util.List;

public interface EmployeeService {
	public abstract void registerEmployee(Employee emp);
	public abstract void deleteEmployee(int id);
	public abstract void udpateEmployee(Employee emp);
	public abstract List<Employee> getEmps();
	public abstract void increaseSalaryForAllTx();
	public abstract void increaseSalaryForAll();
	public abstract void increaseSalaryForAllProgrammaticTx();

}