package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Class;
import com.mindtree.entity.Student;
import com.mindtree.repository.ClassRoomRepository;
import com.mindtree.repository.StudentRepository;

@Service
public class ClassRoomServiceImpl {
	
	@Autowired
	public ClassRoomRepository classRepo;
	
	@Autowired
	public StudentRepository studentRepo;

	public void addStudent(Student student, int id) {
		
		Class classroom=classRepo.findById(id);
		student.setClassroom(classroom);
		studentRepo.save(student);
		
		
	}

	public void addClass(Class classroom) {
		
		classRepo.save(classroom);
		
	}

	public Student getStudents(int id) {
		List<Student> student=new ArrayList<Student>();
		studentRepo.findAll().forEach(n->student.add(n));
		for(Student s:student)
		{
			if(s.getId()==id)
				return s;
		}
		
		return null;
	}

	public Student updateAge(int id,int age) {
		
		Student student=studentRepo.findById(id).get();
		student.setAge(age);
		studentRepo.save(student);
		return student;
	}

}
