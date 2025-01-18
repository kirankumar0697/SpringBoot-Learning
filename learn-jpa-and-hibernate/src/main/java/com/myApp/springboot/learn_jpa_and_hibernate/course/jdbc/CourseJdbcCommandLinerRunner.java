package com.myApp.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myApp.springboot.learn_jpa_and_hibernate.course.Course;

@Component
public class CourseJdbcCommandLinerRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;
	
	@Override
	public void run(String... args) throws Exception {
		courseJdbcRepository.insert(new Course(1, "Learn Java", "Zeus"));
		courseJdbcRepository.insert(new Course(2, "Learn JPA", "Gin"));
		courseJdbcRepository.insert(new Course(3, "Learn CSS", "Ceaser"));
		
		courseJdbcRepository.deleteById(2);
		
		System.out.println(courseJdbcRepository.searchById(1));
		System.out.println(courseJdbcRepository.searchById(3));
	}

	
}
