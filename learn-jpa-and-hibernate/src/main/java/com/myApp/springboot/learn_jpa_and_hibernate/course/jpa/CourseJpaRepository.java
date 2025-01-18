package com.myApp.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.myApp.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entitymgr;
	
	public void insert(Course course) {
		entitymgr.merge(course);
	}
	
	public Course searchById(long id) {
		
		return entitymgr.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = entitymgr.find(Course.class, id);
		entitymgr.remove(course);
	}
}
