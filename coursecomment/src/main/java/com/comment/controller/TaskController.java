package com.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comment.domain.Teacher;
import com.comment.repository.TeacherRepository;

@RestController
public class TaskController {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@RequestMapping("/search")
	public List<Teacher> search(Model model,@RequestBody Teacher teacher) {
		String name=teacher.getName();
		System.err.println(teacher.getTeacher().getName());
		System.out.println(name);
		if(name==null)
			name="";
		return teacherRepository.findByName(name);
	}
	
}
