package com.webkorps.onlinerestorent.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.dto.ClientDto;
import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.repository.ClientRepository;
import com.webkorps.onlinerestorent.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ClientRepository clientRepository;

	Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Override
	public ClientDto addClient(ClientDto clientDto) {
		logger.info("addClient() method Started");

		Client client = modelMapper.map(clientDto, Client.class);
		Client savedClient = clientRepository.save(client);
		ClientDto savedClientDto = modelMapper.map(savedClient, ClientDto.class);

		logger.info("addClient() method Ended");
		return savedClientDto;
	}

}
