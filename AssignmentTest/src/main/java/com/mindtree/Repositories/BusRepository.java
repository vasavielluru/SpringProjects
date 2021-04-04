package com.mindtree.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.entity.Bus;


public interface BusRepository extends JpaRepository<Bus, Integer> {

	 public Bus getBusBybusName(String busName);

	

}
