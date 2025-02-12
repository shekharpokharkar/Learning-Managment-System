package com.seleniumexpress.selexplms.service;

import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Lesson;

public interface CourseService {

	public Course findCoureId(int id);
	public Lesson findLessonById(int id);
	public int saveCourse(Course course);
	public void saveLesson(Lesson lesson);
}
