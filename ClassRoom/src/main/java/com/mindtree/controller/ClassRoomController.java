package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Student;
import com.mindtree.entity.Class;
import com.mindtree.service.ClassRoomServiceImpl;

@RestController
@RequestMapping("/MindTrack")
public class ClassRoomController {

	@Autowired
	public ClassRoomServiceImpl service;
	
	@PostMapping("/addStudent/{id}")
	public Student addStudent(@RequestBody Student student, @PathVariable("id") int id)
	{
		service.addStudent(student,id);
		return student;
	}
	
	@PostMapping("/addClassroom")
	public Class addClass(@RequestBody Class classroom)
	{
		service.addClass(classroom);
		return classroom;
	}
	
	@GetMapping("/get/{id}")
	public Student getStudents(@PathVariable("id") int id)
	{
		return service.getStudents(id);
	}
	
	@PutMapping("/get/{id}")
	public Student updateAge(@RequestBody int age,@PathVariable("id") int id)
	{
		return service.updateAge(id,age);
	}
}
