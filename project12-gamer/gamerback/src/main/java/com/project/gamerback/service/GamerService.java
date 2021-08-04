package com.project.gamerback.service;

import java.util.Optional;

import com.project.gamerback.model.Gamer;

public interface GamerService {

	Optional<Gamer> getByMail(String mail);
	
	void addGamer(Gamer gamer);
}
