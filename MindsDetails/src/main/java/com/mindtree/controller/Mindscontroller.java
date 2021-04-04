package com.mindtree.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Exception.MindserviceException;
import com.mindtree.entity.Mind;
import com.mindtree.entity.Track;
import com.mindtree.service.MindtreeServiceImpl;

@RestController
@RequestMapping("/MindsTracks")
public class Mindscontroller {

	@Autowired
	public MindtreeServiceImpl service;

	@PostMapping("/addMind")
	public ResponseEntity<?> addMind(@RequestBody Mind mindEmployee) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			Mind mind = service.addMind(mindEmployee);
			map.put("Mind added", mind);
			map.put("Message", "Successfully added to Mindtree Database");
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (MindserviceException e) {
			System.out.println(e.getLocalizedMessage());
			map.put("Message", "Id already exists");
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/addTrack/{name}")
	public ResponseEntity<?> addTrack(@RequestBody Track tracks, @PathVariable("name") String name) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			Track track = service.addTrack(tracks, name);
			map.put("Track added", track);
			map.put("Message", "Successfully added to Mindtree Database");
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (MindserviceException e) {
			System.out.println(e.getLocalizedMessage());
			map.put("Message", "No Such name found");
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}



	@GetMapping("/getAll/{name}")
	public ResponseEntity<?> getAllMindDetails(@PathVariable("name") String name) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			List<Mind> minds = service.getMindsOfTrack(name);
			map.put("Mind", minds);
			map.put("Message", "Successfully displayed all employees");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} 
		catch (MindserviceException e) {

			map.put("Message", e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
}
