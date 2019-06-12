package com.comment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comment.domain.Student;
import com.comment.domain.Teacher;
import com.comment.repository.StuRepository;
import com.comment.repository.TeacherRepository;

@RestController
public class StuAjaxController {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	StuRepository stuRepository;
	
	@RequestMapping("/search")
	public List<Teacher> search(Model model,@RequestBody Teacher teacher) {
		String name=teacher.getName();
		System.err.println(teacher.getTeacher().getName());
		System.out.println(name);
		if(name==null)
			name="";
		return teacherRepository.findByName(name);
	}
	@RequestMapping("/updateStuInfo")
	public String updateStuInfo(HttpSession session,@RequestBody Student student) {	
		String id=student.getSid();
		System.out.println(student.toString());
		if(id==null)
			return "0";
		else {
			int res = stuRepository.updateStudent(student.getPhone(),student.getEmail(),student.getSclass(), id);
			if(res==1) {
				
				Student s = (Student) session.getAttribute("student");
				student.setPassword(s.getPassword());
				student.setHeadImg(s.getHeadImg());
				//更新session中的student
				session.setAttribute("student", student);
				
				return res+"";
			}else {
				return "0";
			}
		}
	}
	
	@RequestMapping("/validPassword")
	public String validPassword(String sid ,String password) {	
		
		Student stu = stuRepository.validStudent(sid, password);
		if(stu!=null) {
			return "ok";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/updatePassword")
	public String updatePassword(HttpSession session,@RequestBody Student student) {	
		String id=student.getSid();
		System.out.println(student.toString());
		if(id==null)
			return "0";
		else {
			int res = stuRepository.updatePwd(student.getPassword(), id);
			if(res==1) {
				
				Student s = (Student) session.getAttribute("student");
				s.setPassword(student.getPassword());
				//更新session中的student
				session.setAttribute("student", s);
				
				return res+"";
			}else {
				return "0";
			}
		}
	}
	
}
