package com.mindtree.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exceptions.SportsServiceException;
@Service
public interface SportsService {

	Player addPlayer(Player player,int teamId) throws SportsServiceException;

	Team addTeam(Team team) throws SportsServiceException;

	List<Player> displayPlayerDetails(String teamName) throws SportsServiceException;

	void updateTeamLocation(String locationName, int teamId) throws SportsServiceException;

	void deletePlayer(int playerId) throws SportsServiceException;

}
