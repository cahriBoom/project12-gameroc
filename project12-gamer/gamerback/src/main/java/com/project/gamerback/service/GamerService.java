package com.project.gamerback.service;

import java.util.Optional;

import com.project.gamerback.model.Gamer;

public interface GamerService {

	Optional<Gamer> getByMail(String mail);
	
	Optional<Gamer> getById(int id);
	
	void updateProfile(Gamer gamer);
	
	void addGamer(Gamer gamer);
}
