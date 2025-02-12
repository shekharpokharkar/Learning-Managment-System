package com.seleniumexpress.selexplms.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Lesson;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Course findCoureId(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Course course = session.get(Course.class, id);
		
		return course;
	}

	@Override
	public Lesson findLessonById(int lessonId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Lesson lesson = session.get(Lesson.class, lessonId);//1
		
		return lesson;
	}

	@Override
	public int saveCourse(Course course) {
		
		Session session = sessionFactory.getCurrentSession();
		Serializable id = session.save(course);
		
		return (Integer)id;
	}

	@Override
	public void saveLesson(Lesson lesson) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(lesson); // 0, > 0
		
	}

}
