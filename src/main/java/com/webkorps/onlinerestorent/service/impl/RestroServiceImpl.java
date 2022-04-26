package com.webkorps.onlinerestorent.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.dto.RestroDto;
import com.webkorps.onlinerestorent.entity.Restro;
import com.webkorps.onlinerestorent.repository.RestroRepository;
import com.webkorps.onlinerestorent.service.RestroService;

@Service
public class RestroServiceImpl implements RestroService{

	@Autowired
	private RestroRepository restroRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public RestroDto addRestro(RestroDto restroDto) {
		Restro restro = modelMapper.map(restroDto, Restro.class);
		Restro savedRestro = restroRepository.save(restro);
		RestroDto savedRestroDto = modelMapper.map(savedRestro, RestroDto.class);
		return savedRestroDto;
		
		
	}

}
