package com.webkorps.onlinerestorent.service;

import java.util.List;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.Restro;

public interface RestroService {

	Restro addRestro(Restro restro);
	
	Restro getRestroByClient(Client client);
	
	Restro getRestroById(Long id);
	
	List<Restro> getRestrosByName(String restroName);
}
