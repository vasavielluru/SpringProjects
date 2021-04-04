package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Passenger {

	@Id
	private int id;
	private String name;
	private int age;

	@ManyToOne
	@JsonIgnore
	private Bus bus;

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

}
