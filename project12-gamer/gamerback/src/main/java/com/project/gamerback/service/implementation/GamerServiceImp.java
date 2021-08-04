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
	public Optional<Gamer> getByMail(String mail) {
		return gamerRepository.findByEmail(mail);
	}

	@Override
	public void addGamer(Gamer gamer) {
		gamer.setNote("NEW");
		gamerRepository.save(gamer);
	}

}
