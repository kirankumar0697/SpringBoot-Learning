package com.myApp.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myApp.springboot.learn_jpa_and_hibernate.course.Course;
import com.myApp.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLinerRunner implements CommandLineRunner {

	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Using EntityManager: ");
		courseJpaRepository.insert(new Course(4, "Learn Java", "Zeus"));
		courseJpaRepository.insert(new Course(5, "Learn JPA", "Gin"));
		courseJpaRepository.insert(new Course(6, "Learn CSS", "Ceaser"));
		
		courseJpaRepository.deleteById(4);
		
		System.out.println(courseJpaRepository.searchById(5));
		System.out.println(courseJpaRepository.searchById(6));
	}

	
}
