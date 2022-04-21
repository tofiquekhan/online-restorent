package com.webkorps.onlinerestorent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webkorps.onlinerestorent.entity.Restro;

@Repository
public interface RestroRepository extends JpaRepository<Restro, Long> {

}
