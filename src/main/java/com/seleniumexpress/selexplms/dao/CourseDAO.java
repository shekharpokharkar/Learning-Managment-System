package com.seleniumexpress.selexplms.dao;

import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Lesson;

public interface CourseDAO {

	public Course findCoureId(int id);
	public Lesson findLessonById(int lessonId);
	public int saveCourse(Course course);
	public void saveLesson(Lesson lesson);
}
