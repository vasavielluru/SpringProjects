package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Track;
@Repository
public interface TrackRepository extends JpaRepository <Track,Integer>{
	public Track findById(int id);
}
