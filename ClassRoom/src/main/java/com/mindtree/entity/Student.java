package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int id;
	private int age;
	private String name;
	@OneToOne
	private Class classroom;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, int age, String name, Class classroom) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.classroom = classroom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Class getClassroom() {
		return classroom;
	}
	public void setClassroom(Class classroom) {
		this.classroom = classroom;
	}
	

}
