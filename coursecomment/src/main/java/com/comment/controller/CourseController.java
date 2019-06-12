package com.comment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.comment.domain.StuCourse;
import com.comment.domain.Student;
import com.comment.repository.CourseRepository;

@Controller
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/course")
	public String course(HttpSession session,Model m) {	
		
		Student stu = (Student) session.getAttribute("student");
		
		if(stu!=null) {
			List<StuCourse> courses = courseRepository.findCourseByStuId(stu.getSid());
			
			m.addAttribute("courses",courses);
		}
		
		return "course";
	}
	@GetMapping("/allCourse")
	public String allCourse(Model m) {		
		return "allCourse";
	}
	@GetMapping("/learnedCourse")
	public String learnedCourse(Model m) {		
		return "learnedCourse";
	}
	
}
