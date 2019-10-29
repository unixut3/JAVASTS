package com.itwill.spring.transaction.annotation;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import com.itwill.spring.transaction.Employee;
@Repository
public class EmployeeDaoImplAnnotation implements EmployeeDaoAnnotation {
	@Autowired
	private JdbcTemplate template;	
	
	public void insert(Employee emp) {
		StringBuilder sql = new StringBuilder(256);
		sql.append("INSERT INTO employee ");
		sql.append("(id,name, email, phone) ");
		sql.append("VALUES (employee_id_seq.nextval,?, ?, ?)");
		
		template.update(
			sql.toString(),
			emp.getName(), 
			emp.getEmail(), emp.getPhone());		
		
	}
	
	public void update(final Employee emp) {
				
		StringBuilder sql = new StringBuilder(256);
		sql.append("UPDATE employee ");
		sql.append("SET ");
		sql.append("	name = ?, ");
		sql.append("	phone = ?, ");
		sql.append("	email = ? ");
		sql.append("WHERE id = ? ");
		template.update(sql.toString(), 
				emp.getName(), emp.getPhone(),
				emp.getEmail(), emp.getId());
	}	
	
	
	public void delete(int id) {
		template.update(
			"DELETE FROM employee WHERE id = ?", id);
	}
	
	
	public List<Employee> list() {		

		return template.query(
			"SELECT id, name, email, phone, salary FROM employee ORDER BY id DESC",
			new RowMapper<Employee>() {
				public Employee mapRow(ResultSet rs, int arg1)
						throws SQLException {
					Employee emp = new Employee(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),rs.getInt(5));
					
					return emp;
				}
			});
	}
	
	
	public Employee getPerson(int id) {
		 
		Employee result = null;
		try {
		result = template.queryForObject(
			"SELECT id, name, email, phone, salary " + 
			"FROM employee WHERE id = ?",
			new Object[] { id },
			new RowMapper<Employee>() {

				public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
					Employee emp = new Employee(
						rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getInt(5));
					
					return emp;
				}
			});
		} catch (Exception ex) {
			result = null;
		}
		return result;
	}
	
	public void increaseSalary(int id, int amount) {
		template.update(
			"UPDATE employee SET salary = (salary + ?) WHERE id = ?",
			amount, id);
	}

}
