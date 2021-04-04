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

import com.mindtree.entity.Bus;
import com.mindtree.entity.Passenger;
import com.mindtree.exceptions.ServiceExcptions.TransportServiceException;
import com.mindtree.service.TransportService;

@RestController
@RequestMapping("/TransportClass")
public class TransportController {
	@Autowired
	public TransportService service;

	@PostMapping("/addPassenger/{busId}")
	public ResponseEntity<?> addPassenger(@RequestBody Passenger passenger, @PathVariable("busId") int busId) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {

			Passenger passengerObj = service.addPassenger(passenger, busId);
			map.put("Passenger added", passengerObj);
			map.put("Message", "Successfully added Passenger to Database");
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (TransportServiceException e) {

			map.put("Message", e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/addBus")
	public ResponseEntity<?> addBus(@RequestBody Bus bus) {

		Map<String, Object> map = new LinkedHashMap<>();
		try {

			Bus busObj = service.addBus(bus);
			map.put("Team added", busObj);
			map.put("Message", "Successfully added Team to Database");
			return new ResponseEntity<>(map, HttpStatus.CREATED);
		} catch (TransportServiceException e) {

			map.put("Message", e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getPassenger/{busName}")
	public ResponseEntity<?> displayPassengerDetails(@PathVariable String busName) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			List<Passenger> passengers = service.displayPassengerDetails(busName);
			map.put("Passenger", passengers);
			map.put("Message", "Successfully displayed all Passengers based on the bus name given");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (TransportServiceException e) {

			map.put("Message", e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updatePassengerAge/{passengerId}")
	public ResponseEntity<?> updateTeamLocation(@RequestBody int passengerAge,
			@PathVariable("passengerId") int passengerId) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			service.updatePassengerAge(passengerAge, passengerId);
			map.put("Message", "Successfully Updtaed age of Passenger based on their id");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (TransportServiceException e) {

			map.put("Message", e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deletePassenger/{passengerId}")
	public ResponseEntity<?> deletePassenger(@PathVariable int passengerId) {
		Map<String, Object> map = new LinkedHashMap<>();
		try {
			service.deletePassenger(passengerId);
			map.put("Message", "Successfully deleted Passenger based on their Id");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (TransportServiceException e) {

			map.put("Message", e.getLocalizedMessage());
		}
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

}
