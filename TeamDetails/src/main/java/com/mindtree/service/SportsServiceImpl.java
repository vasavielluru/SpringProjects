package com.mindtree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exceptions.SportsServiceException;
import com.mindtree.repository.PlayerRepository;
import com.mindtree.repository.TeamRepository;

@Service
public class SportsServiceImpl implements SportsService {

	@Autowired
	public TeamRepository teamRepo;

	@Autowired
	public PlayerRepository playerRepo;

	@Override
	public Player addPlayer(Player player, int teamId) throws SportsServiceException {

		Team team = teamRepo.findById(teamId);

		if (team == null) {
			throw new SportsServiceException("No Id Found");
		} else {
			player.setTeam(team);
			playerRepo.save(player);
			team.getPlayersList().add(player);

			teamRepo.save(team);

		}

		return player;
	}

	@Override
	public Team addTeam(Team team) throws SportsServiceException {

		int id = team.getId();
		Team object = null;
		object = teamRepo.findById(id);
		try {
			if (object == null) {
				teamRepo.save(team);

			} else {
				throw new SportsServiceException("Id already exist");
			}
		} catch (SportsServiceException e) {
			throw new SportsServiceException(e.getLocalizedMessage());
		}
		return team;
	}

	@Override
	public List<Player> displayPlayerDetails(String teamName) throws SportsServiceException {

		List<Player> playersList;
		try {
			Team team = teamRepo.getTeamByTeamName(teamName);
			playersList = team.getPlayersList();
			if(team==null)
			{
				throw new SportsServiceException("No team With the name");
			}
		} catch (SportsServiceException e) {
			throw new SportsServiceException("No team With the name");
		}
		return playersList;

	}

	@Override
	public void updateTeamLocation(String locationName, int teamId) throws SportsServiceException {

		Team team = teamRepo.findById(teamId);
		try {
			if (team == null) {
				throw new SportsServiceException("No such team Id found");
			} else {
				team.setLocation(locationName);
				teamRepo.save(team);
			}
		} catch (SportsServiceException e) {
			throw new SportsServiceException(e.getLocalizedMessage());
		}
	}

	@Override
	public void deletePlayer(int playerId) throws SportsServiceException {

		Player player = playerRepo.findById(playerId);
		try {
			if (player == null) {
				throw new SportsServiceException("No Such Id found");
			} else {
				playerRepo.delete(player);
			}
		} catch (SportsServiceException e) {
			throw new SportsServiceException(e.getLocalizedMessage());
		}

	}

}
