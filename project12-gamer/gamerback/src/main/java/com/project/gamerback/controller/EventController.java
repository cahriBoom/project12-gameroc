package com.project.gamerback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Gamer;
import com.project.gamerback.model.Videogame;
import com.project.gamerback.service.EventService;
import com.project.gamerback.service.VideogameService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private VideogameService videogameService;
	
	@GetMapping(value="/events")
	public List<Event> getAllEvents(){
		return eventService.getAll();
	}
	
	@GetMapping(value="event/{id}")
	public Event getEventById(@PathVariable("id")int id) {
		return eventService.getById(id);
	}
	
	@PostMapping(value="/event/{id}")
	void postJoinGroup(@PathVariable("id") int id, @RequestBody Gamer gamer) {
		Event event = eventService.getById(id);
		eventService.participateToEvent(event, gamer);
	}
	
	@PostMapping(value="/post_event")
	void addNewEvent(@RequestBody Event event) {
		String videogame_name = event.getVgname();
		String plateform = event.getPlateform();
		int maximum_players = event.getPlayer_needed();
		if(videogame_name.equals("Halo")) {
			plateform = "Xbox";
		}
		event.setMaximum_players(maximum_players);
		Videogame videogame = videogameService.findByNomAndPlateform(videogame_name, plateform);
		
		event.setVideogame(videogame);
		eventService.addNewEvent(event);
	}
	
	@PostMapping(value="/search_event")
	List<Event> getEventByVideoGame(@RequestBody Videogame videogame){
		String recherche = videogame.getNom();
		return eventService.searchEvent(recherche);
	}
	

	
}
