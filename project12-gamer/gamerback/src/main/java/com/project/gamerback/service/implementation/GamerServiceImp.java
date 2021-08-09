package com.project.gamerback.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerback.model.Gamer;
import com.project.gamerback.repository.GamerRepository;
import com.project.gamerback.service.GamerService;

@Service
public class GamerServiceImp implements GamerService {

	@Autowired
	private GamerRepository gamerRepository;

	@Override
	public Optional<Gamer> getByMail(String email) {
		return gamerRepository.findByEmail(email);
	}

	@Override
	public Optional<Gamer> getById(int id) {
		return gamerRepository.findById(id);
	}
	
	@Override
	public void addGamer(Gamer gamer) {
		gamer.setNote("NEW");
		gamerRepository.save(gamer);
	}

	@Override
	public void updateProfile(Gamer gamer) {
		gamerRepository.save(gamer);
		
	}



}
