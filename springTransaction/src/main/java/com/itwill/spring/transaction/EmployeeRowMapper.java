package com.itwill.spring.transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("### EmployeeRowMapper.mapRow()");
		Employee emp=new Employee(rs.getInt(1),
								  rs.getString(2),
								  rs.getString(3),
								  rs.getString(4),
								  rs.getInt(5));
		
		return emp;
	}
	
}
