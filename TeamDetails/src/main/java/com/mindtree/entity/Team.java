package com.mindtree.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {

	
	@Id
	private int id;
	private String teamName,location;

	
	@OneToMany(mappedBy="team")
	private List<Player> playersList;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Team(int id, String teamName, String location) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.location = location;
	}



	public List<Player> getPlayersList() {
		return playersList;
	}



	public void setPlayersList(List<Player> playersList) {
		this.playersList = playersList;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	

	

	
	
	
}
