package com.comment.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comment.domain.Student;
import com.comment.domain.Teacher;
import com.comment.repository.StuRepository;
import com.comment.repository.TeacherRepository;

@Controller
public class StuController {
	
	@Autowired
	StuRepository stuRepository;
	
	@GetMapping("/index")
	public String welcome(Model m) {
		
		return "index";
	}
	@RequestMapping("/login")
	public String login(HttpSession session,String account, String password, String position) {
		System.out.println(position);
		if("student".equals(position)) {
			Student t = stuRepository.validStudent(account, password);
			if (t!=null) {	
				
				session.setAttribute("student", t);
				return "home";
			}	
			else
				return "index";
		}else {
			//½ÌÖ°¹¤µÇÂ¼
			return "index";
		}
		
	}
	@GetMapping("/slide")
	public String slide(Model m) {		
		return "slide";
	}
	@GetMapping("/home")
	public String home(Model m) {		
		return "home";
	}
	@GetMapping("/personalInfo")
	public String personalInfo(Model m) {		
		return "personalInfo";
	}
	@RequestMapping("/updateStudent")
	public String updateStudent(HttpServletRequest request) {	
		
		Student stu = new Student();
		stu.setSid(request.getParameter("sid"));
		stu.setName(request.getParameter("name"));
		stu.setSclass(request.getParameter("sclass"));
		stu.setSchool(request.getParameter("school"));
		stu.setPhone(request.getParameter("phone"));
		stu.setEmail(request.getParameter("email"));
		int res = stuRepository.updateStudent(stu.getPhone(),stu.getEmail(),stu.getSclass(),stu.getSid());
		if(res==1) {
			request.getSession().setAttribute("student", stu);
		}
		System.out.println(res);
		
		return "personalInfo";
	}
	
	@GetMapping("/updatePwd")
	public String updatePwd(Model m) {		
		return "updatePwd";
	}
	
}
