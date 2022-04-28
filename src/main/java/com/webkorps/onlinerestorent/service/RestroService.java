package com.webkorps.onlinerestorent.service;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.Restro;

public interface RestroService {

	Restro addRestro(Restro restro);
	
	Restro getRestroByClient(Client client);
}
