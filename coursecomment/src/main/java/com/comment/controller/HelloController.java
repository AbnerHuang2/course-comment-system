package com.comment.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comment.domain.Teacher;
import com.comment.repository.TeacherRepository;

@Controller
public class HelloController {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@GetMapping("/index")
	public String welcome(Model m) {
		
		return "index";
	}
	@RequestMapping("/login")
	public String login(HttpSession session,String account, String password) {
		
		Teacher t = teacherRepository.validTeacher(account, password);
		if (t!=null) {		
			session.setAttribute("teacher", t);
			return "home";
		}	
		else
			return "index";
	}
	@GetMapping("/home")
	public String home(Model m) {		
		return "home";
	}
	@GetMapping("/personalInfo")
	public String personalInfo(Model m) {		
		return "personalInfo";
	}
	@GetMapping("/course")
	public String course(Model m) {		
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
