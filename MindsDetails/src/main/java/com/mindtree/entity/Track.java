package com.mindtree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Track {

	
	@Id
	private int trackId;
	private String name;
	private int noOfMinds;
	
	@OneToMany(targetEntity=Mind.class)
	private List<Mind> MindsOfTrack;

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public Track(int trackId, String name, int noOfMinds, List<Mind> mindsOfTrack) {
		super();
		this.trackId = trackId;
		this.name = name;
		this.noOfMinds = noOfMinds;
		MindsOfTrack = mindsOfTrack;
	}







	public List<Mind> getMindsOfTrack() {
		return MindsOfTrack;
	}







	public void setMindsOfTrack(List<Mind> mindsOfTrack) {
		MindsOfTrack = mindsOfTrack;
	}







	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfMinds() {
		return noOfMinds;
	}

	public void setNoOfMinds(int noOfMinds) {
		this.noOfMinds = noOfMinds;
	}

	
	
}
