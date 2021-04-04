package com.mindtree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mindtree.entity.Employee;
import com.mindtree.exceptions.EmployeeServiceException;
import com.mindtree.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl {
	
	@Autowired
	public EmployeeRepository empRepo;

	public Employee getEmployeeByID(int id) throws EmployeeServiceException{
		Employee emp=null;
		emp=empRepo.findById(id);
		if(emp==null)
		{
			throw new EmployeeServiceException("No Such Id found");
		}
		
		return emp;
	}

	public Employee addEmployee(Employee employee) throws EmployeeServiceException {
		
		int id=employee.getId();
		Employee emp=null;
		emp=empRepo.findById(id);
		if(emp==null)
		{
			empRepo.save(employee);
		}
		else
		{
			throw new EmployeeServiceException("ID already exists");
		}
		return employee;
	}
	
	
	public List<Employee> getAllEmployeeDetails() throws EmployeeServiceException
	{
		List<Employee> list =new ArrayList<Employee>();
		empRepo.findAll().forEach(list::add);
		if(list==null)
		{
			throw new EmployeeServiceException("Empty Data in Databease");
		}
		return list;
	}
	public List<Employee> deleteEmployee(int id) throws EmployeeServiceException
	{
		List<Employee> list=new ArrayList<Employee>();
		Employee emp=null;
		emp=empRepo.findById(id);
		if(emp==null)
			throw new EmployeeServiceException("No Id found");
		empRepo.deleteById(id);
		empRepo.findAll().forEach(list::add);
		return list;
	}

}
