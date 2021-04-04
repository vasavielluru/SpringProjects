package com.mindtree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	Team findById(int id);

	

	List<Team> findAll();



	Team findById(Team teamId);



	Team getTeamByTeamName(String teamName);

}
