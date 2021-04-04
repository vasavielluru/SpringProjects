package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mind {

	@Id
	private int id;
	private String name,trackName,role,phoneNum;
	
	

	public Mind() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mind(int id, String name, String trackName, String role, String phoneNum) {
		super();
		this.id = id;
		this.name = name;
		this.trackName = trackName;
		this.role = role;
		this.phoneNum = phoneNum;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
