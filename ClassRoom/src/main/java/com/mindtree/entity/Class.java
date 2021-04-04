package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Class {
	
	@Id
	private int classId;
	private String name;
	private int noOfStudents;
	public Class() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Class(int classId, String name, int noOfStudents) {
		super();
		this.classId = classId;
		this.name = name;
		this.noOfStudents = noOfStudents;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	
}
