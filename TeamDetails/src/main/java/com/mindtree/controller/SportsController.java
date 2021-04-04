package com.mindtree.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Player;
import com.mindtree.entity.Team;
import com.mindtree.exceptions.SportsServiceException;
import com.mindtree.service.SportsService;

@RestController
@RequestMapping("/SportsPath")
public class SportsController {
	
	
	@Autowired
	public SportsService service;

	@PostMapping("/addPlayer/{teamId}")
	public ResponseEntity<?> addPlayer(@RequestBody Player player,@PathVariable("teamId") int teamId)
	{
		Map<String, Object> map =new LinkedHashMap<>();
		try {
			
			Player playerObj=service.addPlayer(player,teamId);
			map.put("Player added", playerObj);
			map.put("Message", "Successfully added Player to Database");
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		}
		catch(SportsServiceException e)
		{
			
			map.put("Message", e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/addTeam")
	public ResponseEntity<?> addTeam(@RequestBody Team team)
	{

		Map<String, Object> map =new LinkedHashMap<>();
		try {
			
			Team teamObj=service.addTeam(team);
			map.put("Team added",teamObj);
			map.put("Message", "Successfully added Team to Database");
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		}
		catch(SportsServiceException e)
		{
			
			map.put("Message",e.getLocalizedMessage() );
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/getPlayer/{teamName}")
	public ResponseEntity<?> displayPlayerDetails(@PathVariable String teamName)
	{
		Map<String, Object> map=new LinkedHashMap<>();
		try
		{
			List<Player> players=service.displayPlayerDetails(teamName);
			map.put("Player", players);
			map.put("Message", "Successfully displayed all Players based on the team name given");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		catch(SportsServiceException e)
		{
			
			map.put("Message",e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updateTeamLocation/{teamId}")
	public ResponseEntity<?> updateTeamLocation(@RequestBody String locationName,@PathVariable int teamId)
	{
		Map<String, Object> map=new LinkedHashMap<>();
		try
		{
			service.updateTeamLocation(locationName,teamId);
			map.put("Message", "Successfully Updtaed Location Of team based on team id");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		catch(SportsServiceException e)
		{
			
			map.put("Message", e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/deletePlayer/{playerId}")
	public ResponseEntity<?> deletePlayer(@PathVariable int playerId)
	{
		Map<String, Object> map=new LinkedHashMap<>();
		try
		{
			service.deletePlayer(playerId);
			map.put("Message", "Successfully deleted Player based on their Id");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		catch(SportsServiceException e)
		{
			
			map.put("Message",e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	
}
