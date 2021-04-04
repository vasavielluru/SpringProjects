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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Employee;
import com.mindtree.exceptions.EmployeeServiceException;
import com.mindtree.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	public EmployeeServiceImpl service;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getEmployeeByID(@PathVariable("id") int id)
	{
		Map<String, Object> map=new LinkedHashMap<>();
		try
		{
			Employee emp= service.getEmployeeByID(id);
			map.put("Employee found", emp);
			map.put("Message","Succesfully fetched from Employee");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		catch(EmployeeServiceException e)
		{
			System.out.println(e.getLocalizedMessage());
			map.put("Message", "Failed to fetch the message");
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		Map<String, Object> map=new LinkedHashMap<>();
		try {
			Employee emp=service.addEmployee(employee);
			map.put("Employee added", emp);
			map.put("Message", "Successfully added to Employee Database");
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		}
		catch(EmployeeServiceException e)
		{
			System.out.println(e.getLocalizedMessage());
			map.put("Message", "Id already exists");
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAllEmployeeDetails()
	{
		Map<String, Object> map=new LinkedHashMap<>();
		try
		{
			List<Employee> employee=service.getAllEmployeeDetails();
			map.put("Employee", employee);
			map.put("Message", "Successfully displayed all employees");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		catch(EmployeeServiceException e)
		{
			System.out.println(e.getLocalizedMessage());
			map.put("Message", "Failed to fetch Employees");
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id)
	{
		Map<String, Object> map=new LinkedHashMap<>();
		try
		{
			List<Employee> employee=service.deleteEmployee(id);
			map.put("Employee after deleting", employee);
			map.put("Message", "Successfully deleted employee through ID");
			return new ResponseEntity<>(map,HttpStatus.NO_CONTENT);
		}
		catch(EmployeeServiceException e)
		{
			System.out.println(e.getLocalizedMessage());
			map.put("Message", "Failed to delete Employee");
		}
		return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
	}
	@GetMapping("/msg")
	public String getMessage() {
		return "HELLO";
	}
	
}
