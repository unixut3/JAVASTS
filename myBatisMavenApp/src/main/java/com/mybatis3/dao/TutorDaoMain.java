package com.mybatis3.dao;

public class TutorDaoMain {

	public static void main(String[] args) {
		TutorDao tutorDao=new TutorDao();
		System.out.println("----------findTutorById--------");
		System.out.println("###"+tutorDao.findTutorById(1));
		System.out.println("###"+tutorDao.findTutorById(3));
		System.out.println("----------findTutorByIdWithAddressAndCourses--------");
		System.out.println("###"+tutorDao.findTutorByIdWithAddressAndCourses(1));
		System.out.println("###"+tutorDao.findTutorByIdWithAddressAndCourses(2));
		System.out.println("###"+tutorDao.findTutorByIdWithAddressAndCourses(3));
		
		System.out.println("-------------nestedSelectTutorById----------------");

	}

}
