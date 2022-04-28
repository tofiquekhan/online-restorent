package com.webkorps.onlinerestorent.service;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.User;

public interface ClientService {

	Client addClient(Client client);
	
	Client getClientByUser(User user);
}
