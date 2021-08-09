package com.project.gamerback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamerback.model.Videogame;
import com.project.gamerback.service.VideogameService;

@RestController
public class VideogameController {

	
	@Autowired
	private VideogameService videogameService;
	
	
	@GetMapping(value = "/games")
	public List<Videogame> getAllGames(){
		return videogameService.getAllGames();
	}
}
