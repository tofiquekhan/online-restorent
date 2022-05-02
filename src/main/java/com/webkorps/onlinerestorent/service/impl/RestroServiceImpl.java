package com.webkorps.onlinerestorent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.Restro;
import com.webkorps.onlinerestorent.repository.RestroRepository;
import com.webkorps.onlinerestorent.service.RestroService;

@Service
public class RestroServiceImpl implements RestroService{

	@Autowired
	private RestroRepository restroRepository;
	
	
	@Override
	public Restro addRestro(Restro restro) {
		Restro savedRestro = restroRepository.save(restro);
		return savedRestro;
	}

	@Override
	public Restro getRestroByClient(Client client) {
		Restro restro = restroRepository.getById(client.getRestro().getId());
		return restro;
	}

	@Override
	public List<Restro> getRestrosByName(String restroName){
		return restroRepository.findByNameContains(restroName);
	}
	
	@Override
	public Restro getRestroById(Long id) {
		
		
		return restroRepository.findById(id).get();
	}
	
}
