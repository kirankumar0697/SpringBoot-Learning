package com.myApp.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myApp.springboot.learn_jpa_and_hibernate.course.Course;
import com.myApp.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.myApp.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJPACommandLinerRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpaRepository courseJpaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("USING JPA: ");
		courseJpaRepository.save(new Course(7, "Learn Java", "Zeus"));
		courseJpaRepository.save(new Course(8, "Learn JPA", "Gin"));
		courseJpaRepository.save(new Course(9, "Learn CSS", "Ceaser"));
		
		courseJpaRepository.deleteById(9L);
		
		System.out.println(courseJpaRepository.findById(7L));
		System.out.println(courseJpaRepository.findById(8L));
		
		System.out.println(courseJpaRepository.findAll());
		System.out.println(courseJpaRepository.count());
		
		System.out.println(courseJpaRepository.findByAuthor("Gin"));
		System.out.println(courseJpaRepository.findByName("Learn CSS"));
		
	}

	
}
