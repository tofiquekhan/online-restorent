package com.webkorps.onlinerestorent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webkorps.onlinerestorent.entity.Restro;

@Repository
public interface RestroRepository extends JpaRepository<Restro, Long> {

	List<Restro> findByNameContains(String name);
	
	
}
