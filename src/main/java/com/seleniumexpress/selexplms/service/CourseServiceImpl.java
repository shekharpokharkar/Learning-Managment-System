package com.seleniumexpress.selexplms.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.selexplms.dao.CourseDAO;
import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Lesson;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	@Transactional
	@Override
	public Course findCoureId(int id) {
		
		//dao call
		
		Course course = courseDAO.findCoureId(id);
		Hibernate.initialize(course.getLessons());
		
		
		return course;
	}

	@Transactional
	@Override
	public Lesson findLessonById(int id) {
		
		Lesson lesson = courseDAO.findLessonById(id);
		
		return lesson;
	}

	@Transactional
	@Override
	public int saveCourse(Course course) {
		
		int courseId = courseDAO.saveCourse(course);
		
		return courseId;
		
	}

	@Transactional
	@Override
	public void saveLesson(Lesson lesson) {
		courseDAO.saveLesson(lesson);
	}

}
