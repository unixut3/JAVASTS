package com.itwill.spring.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository("empDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void insert(Employee emp) {
		StringBuilder sql = new StringBuilder(256);
		sql.append("INSERT INTO employee ");
		sql.append("(id,name, email, phone) ");
		sql.append("VALUES (employee_id_seq.nextval,?, ?, ?)");
		template.update(sql.toString(), emp.getName(), emp.getEmail(),
				emp.getPhone());

	}

	public void update(final Employee emp) {

		StringBuilder sql = new StringBuilder(256);
		sql.append("UPDATE employee ");
		sql.append("SET ");
		sql.append("	name = ?, ");
		sql.append("	phone = ?, ");
		sql.append("	email = ? ");
		sql.append("WHERE id = ? ");
		template.update(sql.toString(), emp.getName(), emp.getPhone(),
				emp.getEmail(), emp.getId());
	}

	public void delete(int id) {
		template.update("DELETE FROM employee WHERE id = ?", id);
	}

	public List<Employee> list() {
		/*
		return template
	.query("SELECT id, name, email, phone, salary FROM employee ORDER BY id DESC",
			new EmployeeRowMapper()
			);
		*/	
		return template
				.query(
						"SELECT id, name, email, phone, salary FROM employee ORDER BY id DESC",
						new BeanPropertyRowMapper<Employee>(Employee.class)
					);
	}

	public Employee getPerson(int id) {

		Employee emp = null;
		try {
			/*
			emp = template.queryForObject(
					"SELECT id, name, email, phone, salary "
							+ "FROM employee WHERE id = ?",
							new Object[] {id},new EmployeeRowMapper());
			*/
			emp = template.queryForObject(
					"SELECT id, name, email, phone, salary "
							+ "FROM employee WHERE id = ?",
							new Object[] {id},
							new BeanPropertyRowMapper<Employee>(Employee.class));
		} catch (Exception ex) {
			emp = null;
			ex.printStackTrace();
		}
		return emp;
	}

	public void increaseSalary(int id, int amount) {
		template.update(
				"UPDATE employee SET salary = (salary + ?) WHERE id = ?",
				amount, id);
	}
}
