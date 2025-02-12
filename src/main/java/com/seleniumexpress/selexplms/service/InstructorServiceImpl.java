package com.seleniumexpress.selexplms.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.selexplms.dao.InstructorDAO;
import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	private InstructorDAO instructorDAO;
	
	@Override
	@Transactional
	public List<Instructor> findAllInstructor() {
		
		List<Instructor> findAllInstructor = instructorDAO.findAllInstructor();
		
		for(Instructor instructor :findAllInstructor) {
			instructor.setName(instructor.getName().toUpperCase());
			Hibernate.initialize(instructor.getCourses());
		}
		
		return findAllInstructor;
	}

	@Transactional
	@Override
	public void saveInstructor(Instructor instructor) {
		instructorDAO.saveInstructor(instructor);
		
	}

	@Transactional
	@Override
	public Instructor searchInstructor(int id) {
		
		//dao call
		
		Instructor instructor = instructorDAO.searchInstructorWithId(id);
		Hibernate.initialize(instructor.getCourses());
		
		return instructor;
	}

	@Transactional
	@Override
	public void delteInstructor(int id) {
		
		instructorDAO.deleteInstructor(id);
		
	}

}
