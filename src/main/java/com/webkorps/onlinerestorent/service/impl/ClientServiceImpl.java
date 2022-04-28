package com.webkorps.onlinerestorent.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.User;
import com.webkorps.onlinerestorent.repository.ClientRepository;
import com.webkorps.onlinerestorent.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	

	@Autowired
	private ClientRepository clientRepository;

	Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Override
	public Client addClient(Client client) {
		logger.info("addClient() method Started");
		Client savedClient = clientRepository.save(client);
		logger.info("addClient() method Ended");
		return savedClient;
	}

	@Override
	public Client getClientByUser(User user) {
		Client client = clientRepository.findByUser(user);
		return client;
	}
	
	@Override
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}

}
