package com.project.gamerback.service;

import java.util.List;

import com.project.gamerback.model.Videogame;

public interface VideogameService {

	List<Videogame> getAllGames();
	
	Videogame findByNomAndPlateform(String nom, String plateform);
}
