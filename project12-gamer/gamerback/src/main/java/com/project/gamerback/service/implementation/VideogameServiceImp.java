package com.project.gamerback.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerback.model.Videogame;
import com.project.gamerback.repository.VideogameRepository;
import com.project.gamerback.service.VideogameService;

@Service
public class VideogameServiceImp implements VideogameService{

	@Autowired
	private VideogameRepository videogameRepository;
	
	@Override
	public List<Videogame> getAllGames() {
		return videogameRepository.findAll();
	}

	@Override
	public Videogame findByNomAndPlateform(String nom, String plateform) {
		Videogame videogame = videogameRepository.findByNomAndPlateform(nom, plateform).get();
		return videogame;
	}

	
	
}
