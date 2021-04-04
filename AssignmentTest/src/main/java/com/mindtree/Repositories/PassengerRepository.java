package com.mindtree.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

	
}
