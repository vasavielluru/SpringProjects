package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Class;
@Repository
public interface ClassRoomRepository  extends JpaRepository<Class, Integer>{

	public Class findById(int id) ;

	

}
