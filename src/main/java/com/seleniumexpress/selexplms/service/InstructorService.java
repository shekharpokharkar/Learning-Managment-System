package com.seleniumexpress.selexplms.service;

import java.util.List;

import com.seleniumexpress.selexplms.entity.Instructor;

public interface InstructorService {

	public List<Instructor> findAllInstructor();

	public void saveInstructor(Instructor instructor);

	public Instructor searchInstructor(int id);

	public void delteInstructor(int id);

}
