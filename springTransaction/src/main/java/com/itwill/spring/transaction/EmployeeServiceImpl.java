package com.itwill.spring.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("empService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	@Qualifier("empDao")
	private EmployeeDao employeeDao;
	@Autowired
	private PlatformTransactionManager txManager;
	
	public void setTxManager(PlatformTransactionManager txManager) {
		System.out.println("### EmployeeServiceImpl.setTxManager()");
		this.txManager = txManager;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
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

	public void increaseSalaryForAllProgrammaticTx() {

		DefaultTransactionDefinition def = 
				new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		def.setTimeout(10);
		def.setReadOnly(false);
		
		TransactionStatus status = txManager.getTransaction(def);
		
		List<Employee> emps = getEmps();
		try {
			int index = 1;
			for (Employee emp : emps) {
				employeeDao.increaseSalary(emp.getId(), 50);
				index++;
				if (index == 3) {
					throw new RuntimeException(">>>throw exception");
				}
			}
			txManager.commit(status);
			System.out.println("commit[programmatic]");
		} catch (RuntimeException e) {
			
			txManager.rollback(status);
			System.out.println("rollback[programmatic]");
			throw e;
		}
		
	}
	public void increaseSalaryForAllTx() {
		
		List<Employee> emps = this.getEmps();
		int index = 1;
		for (Employee emp : emps) {
			employeeDao.increaseSalary(emp.getId(), 50);
			index++;
			if (index == 3) {
				throw new RuntimeException(">>>throw exception");
			}
		}
	}
	
	public void increaseSalaryForAll() {
		List<Employee> emps = getEmps();
		for (int i=0;i<emps.size();i++) {
			Employee emp = emps.get(i);
			employeeDao.increaseSalary(emp.getId(), 50);
			if (i == 2) {
				throw new RuntimeException("throw exception");
			}
		}
	}

}
