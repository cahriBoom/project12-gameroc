package com.project.gamerback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamerback.model.Videogame;
import com.project.gamerback.service.VideogameService;

/**
 * Contrôleur des objets du packages Videogame
 */
@RestController
public class VideogameController {

	
	@Autowired
	private VideogameService videogameService;
	
    /**
     * Renvoie la liste des Jeux Video
     * @return {@link List}
     */
	@GetMapping(value = "/games")
	public List<Videogame> getAllGames(){
		return videogameService.getAllGames();
	}
	
    /**
     * Renvoie un jeu video suivant son numero
     *
     * @param id: numero du jeu video
     * @return {@link Videogame}
     */
	@GetMapping(value = "/games/{id}")
	public Videogame getVideogameById(@PathVariable("id") int id){
		return videogameService.getById(id);
	}
}
