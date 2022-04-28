package com.webkorps.onlinerestorent.service;

import java.util.List;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.User;

public interface ClientService {

	Client addClient(Client client);
	
	Client getClientByUser(User user);
	List<Client> getAllClients();
}
