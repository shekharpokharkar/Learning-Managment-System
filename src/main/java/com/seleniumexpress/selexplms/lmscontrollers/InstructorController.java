package com.seleniumexpress.selexplms.lmscontrollers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seleniumexpress.selexplms.dao.InstructorDAO;
import com.seleniumexpress.selexplms.dto.SearchDTO;
import com.seleniumexpress.selexplms.entity.Instructor;
import com.seleniumexpress.selexplms.service.InstructorService;

@Controller
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;
	


	@GetMapping("/instructor-info")
	public String showInstructorHomePage(Model model) throws SQLException {
		
		//service call
		List<Instructor> instructorList = instructorService.findAllInstructor();
		
		System.out.println(instructorList);
		model.addAttribute("instructorList", instructorList);
		model.addAttribute("searchDTO", new SearchDTO());
		
		return "instructor-home";
	}
	
	@GetMapping("/add-instructor")
	public String showInsertInstructorPage(Model model) {
		
		model.addAttribute("instructor", new Instructor());
		
		return "add-Instructor";
	}
	
	
	
	@PostMapping("/submit-instructor")
	public String saveInstructor(Instructor instructor) {
		
		System.out.println(instructor);
		
		//saving
		instructorService.saveInstructor(instructor);
		
		return "redirect:/instructor-info";
	}
	

	
	@RequestMapping("/process-search")
	public String showInstructorHomePage(@RequestParam("id") int id,Model model) {
		ArrayList<Instructor> instructors = new ArrayList<Instructor>();
		
		Instructor instructor = instructorService.searchInstructor(id);
		instructors.add(instructor);
		
		model.addAttribute("instructorList", instructors);
		model.addAttribute("searchDTO", new SearchDTO());
		
		return "instructor-home";
	}
	
	
	
	@RequestMapping("/deleteInsturctor")
	public String deleteInstructor(@RequestParam("id") int id) {
		
		System.out.println("deleting the instructor with id : " + id);
		//deleting -> by making a service call
		instructorService.delteInstructor(id);
		
		return "redirect:/instructor-info";
	}
	
	
}








