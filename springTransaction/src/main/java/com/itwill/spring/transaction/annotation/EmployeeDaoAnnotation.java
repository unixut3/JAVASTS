package com.itwill.spring.transaction.annotation;

import java.util.*;

import com.itwill.spring.transaction.Employee;

public interface EmployeeDaoAnnotation {
	public abstract void insert(Employee person);
	public abstract void update(final Employee person);
	public abstract void delete(int idx);
	public abstract List<Employee> list();
	public abstract Employee getPerson(int idx);
	public abstract void increaseSalary(int idx, int amount);
}