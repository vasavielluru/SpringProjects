package com.mindtree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

	Player findById(int id);

	

	List<Player> findAll();

	



	

}
