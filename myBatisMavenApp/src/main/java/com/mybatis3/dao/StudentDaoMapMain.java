package com.mybatis3.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StudentDaoMapMain {

	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("###"+studentDao.findStudentByIdMap(3));
		HashMap studentMap=studentDao.findStudentByIdMap(3);
		BigDecimal studIdBigDecimal=(BigDecimal)studentMap.get("STUDID");
		int studId = studIdBigDecimal.intValue();
		String name=(String)studentMap.get("NAME");
		String email=(String)studentMap.get("EMAIL");
		Date dob=(Date)studentMap.get("DOB");
		System.out.println(studId+","+name+","+email+","+dob);
		System.out.println("###"+studentDao.findAllStudentsMap());
		List<HashMap> studentMapList=studentDao.findAllStudentsMap();
		for (HashMap studentRowMap : studentMapList) {
			BigDecimal studIdBigDecimal2=(BigDecimal)studentRowMap.get("STUDID");
			int studId2 = studIdBigDecimal2.intValue();
			String name2=(String)studentRowMap.get("NAME");
			String email2=(String)studentRowMap.get("EMAIL");
			Date dob2=(Date)studentRowMap.get("DOB");
			System.out.println(studId2+","+name2+","+email2+","+dob2);
		}
		
	}
}











