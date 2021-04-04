package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.entity.Mind;
@Repository
public interface MindRepository extends JpaRepository<Mind,Integer>{
public Mind findById(int id);
}
