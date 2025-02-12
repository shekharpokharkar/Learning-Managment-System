package com.seleniumexpress.selexplms.lmscontrollers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.selexplms.dto.LessonCountDTO;
import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Instructor;
import com.seleniumexpress.selexplms.entity.Lesson;
import com.seleniumexpress.selexplms.service.CourseService;
import com.seleniumexpress.selexplms.service.InstructorService;

@SessionAttributes("lessonCount")
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@Autowired
	private InstructorService instructorService;
	
//	@ResponseBody
//	@GetMapping("/test")
//	public String test(@RequestParam("pageNum") int page, HttpServletRequest request) {
//		
//		ArrayList<String> names = new ArrayList<String>();
//		names.add("supriya");
//		names.add("gopi");
//		names.add("justin");
//		names.add("lavanya");
//		
//		PagedListHolder<String> pagedListHolder =  new PagedListHolder<>();
//		
//		System.out.println("printing the page numb : " + page);
//		
//		if(page==0)
//		{
//		Course msCourse = courseService.findCoureId(20);
//		
//		List<Lesson> lessons = msCourse.getLessons(); // 20
//		
//		
//		//setting the source (all data)
//		pagedListHolder.setSource(names);
//		
//		//setting how many records will be available in one shot
//		pagedListHolder.setPageSize(2);
//		
//		//setting the page number
//		pagedListHolder.setPage(page);  //1
//		
//		
//		List<Lesson> lessonList = pagedListHolder.getPageList(); // get us the list of lesson
//	     
//		HttpSession session = request.getSession();
//		session.setAttribute("lessonList", pagedListHolder);
//	   
//		
//		
//		for(Lesson  lesson : lessonList) {
//			
//			System.out.println(lesson);
//		}
//		
//		}
//		else {
//			
//			pagedListHolder = (PagedListHolder<Lesson>)request.getSession().getAttribute("lessonList");
//			pagedListHolder.setPage(page);
//			
//			List<Lesson> lessonListNew = pagedListHolder.getPageList();
//			for(Lesson  lesson : lessonListNew) {
//				
//				System.out.println(lesson);
//			}
//			
//		}
//		
//		
//		printPageDetails(pagedListHolder);
//		
//		
//		return "testing";
//	}
	
	
	
	

	
	
	
	
	
	
	
	
	






	@GetMapping("/add-course")
	public String showAddCoursePage(Model model) {
		
		model.addAttribute("course", new Course());
		
		List<Instructor> allInstructor = instructorService.findAllInstructor();
		
		model.addAttribute("allInstructor", allInstructor);
		
		return "add-course";
	}
	
	
	
	

	@GetMapping("/viewCourse")
	public String showCoursePage(@RequestParam("courseId") int courseId,@RequestParam(name = "pageNum",required = false) String pageNum,Model model,HttpServletRequest request) {
		
		PagedListHolder<Lesson> pagedLessonListHolder = new PagedListHolder<>();
		Course course = null;
		//do some  service call to fetch the course lessons and details
	
		if(pageNum==null) {
		
		course = courseService.findCoureId(courseId);
		
		List<Lesson> lessons = course.getLessons();
		
		pagedLessonListHolder.setSource(lessons);
		
		pagedLessonListHolder.setPageSize(10);
		
		pagedLessonListHolder.setPage(0);
		
		request.getSession().setAttribute("course", course);
		request.getSession().setAttribute("lessonList", pagedLessonListHolder);
		
		printPageDetails(pagedLessonListHolder);

		}
		else if("prev".equals(pageNum)) {
			pagedLessonListHolder = (PagedListHolder<Lesson>)request.getSession().getAttribute("lessonList");
			pagedLessonListHolder.previousPage();
		}
		else if ("next".equals(pageNum)) {
			
			pagedLessonListHolder = (PagedListHolder<Lesson>)request.getSession().getAttribute("lessonList");
			pagedLessonListHolder.nextPage();
		}
		
		else {
			
		  pagedLessonListHolder = (PagedListHolder<Lesson>)request.getSession().getAttribute("lessonList");
		  pagedLessonListHolder.setPage(Integer.parseInt(pageNum));
		  printPageDetails(pagedLessonListHolder);
		
		}
		
		
		
		
		
		
		
		
		model.addAttribute("courseId", courseId);
		model.addAttribute("course", course);
		
		LessonCountDTO lessonCountDTO = new LessonCountDTO();
		
		course = (Course)request.getSession().getAttribute("course");
		
		if(!course.getLessons().isEmpty())
		{
		int firstLessonNumber = course.getLessons().get(0).getLessonId();
		int lastLessonNumber = (firstLessonNumber + course.getLessons().size())-1 ;
		
		lessonCountDTO.setFirstLessonNumber(firstLessonNumber);
		lessonCountDTO.setLastLessonNumber(lastLessonNumber);
		}
		
		model.addAttribute("lessonCount", lessonCountDTO);
		
		return "course-page";
	}


	@GetMapping("/openLesson")
	public String openLessonPage(@RequestParam("id") int lessonId, Model model) {
		
		
		Lesson lesson = courseService.findLessonById(lessonId);
		model.addAttribute("lesson", lesson);
		return "lesson-page";
	}
	
	
	
	@PostMapping("/save-course")
	public String saveCourse(Course course) {
		
		System.out.println(course);
		
		//save the course to the database
		int newCourseId = courseService.saveCourse(course);
		
	
		return "redirect:/viewCourse?courseId="+newCourseId;
	}
	
	
	
	@GetMapping("/show-add-lesson")
	public String showAddLessonPage(@RequestParam("courseId") Integer courseId,@RequestParam(value = "lessonId",required = false) Integer lessonId,Model model) {
		
		Lesson lesson = new Lesson();
		
		
		if(lessonId == null) {
		//make a service call to find the course with the given id
		Course course = courseService.findCoureId(courseId);
		
		lesson.setCourse(course);
		}
		else {
			
			
		 lesson = courseService.findLessonById(lessonId);
			
		}
		
		model.addAttribute("lesson", lesson);
		
		return "add-lesson";
	}
	

	
	@PostMapping("/save-lesson")
	public String saveLesson(Lesson lesson) {
		
		System.out.println(lesson);
		
		courseService.saveLesson(lesson);
		
		
	
		return "redirect:/viewCourse?courseId="+lesson.getCourse().getId();
	}
	
	
	
	
	
	private void printPageDetails(PagedListHolder<Lesson> pagedListHolder) {
		System.out.println("printing the current page : " + pagedListHolder.getPage()); //page no
		System.out.println("printing the page size : " + pagedListHolder.getPageSize()); // current page size
		System.out.println("is it the first page : " + pagedListHolder.isFirstPage()); // is it the firstPage
		System.out.println("is it the last page : " + pagedListHolder.isLastPage()); 
	}
	
	

}
