package com.mindtree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bus {

	
	@Id
	private int busId;
	private String busName,busType;
	
	@OneToMany(mappedBy="bus")
	private List<Passenger> passengers;

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(int busId, String busName, String busType) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busType = busType;
		
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	
	
	
}
