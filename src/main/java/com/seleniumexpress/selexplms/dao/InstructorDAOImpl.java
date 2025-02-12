package com.seleniumexpress.selexplms.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.selexplms.entity.Instructor;
@Repository
public class InstructorDAOImpl implements InstructorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;//null


	@Override
	public List<Instructor> findAllInstructor() {
		
		//open a session
		
		Session session = sessionFactory.getCurrentSession();
		
		
		//do some query to fetch all the instructor
		Query<Instructor> qury = session.createQuery("from Instructor",Instructor.class);
		List<Instructor> instructorList = qury.list();
		
		
		
		return instructorList;
	}

	@Override
	public void saveInstructor(Instructor instructor) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Serializable savedObject = session.save(instructor);
		
		System.out.println("saved instructor details : " + savedObject);
		
	}

	@Override
	public Instructor searchInstructorWithId(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Instructor instructor = session.get(Instructor.class, id);
		
		return instructor;
	}

	@Override
	public void deleteInstructor(int id) {
	
	    Session session = sessionFactory.getCurrentSession();
		
		Instructor instructor = session.get(Instructor.class, id);
		
		session.delete(instructor);
		
		System.out.println("instructor deleted..");
		
		
	}

}





