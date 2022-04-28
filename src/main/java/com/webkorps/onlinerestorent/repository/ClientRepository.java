package com.webkorps.onlinerestorent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.User;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	Client findByUser(User user);

}
