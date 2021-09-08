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

/**
 * Contrôleur des objets du packages Event
 */
@RestController
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private VideogameService videogameService;
	
    /**
     * Renvoie la liste des Comptes Comptables
     * La méthode corrige les problèmes liées aux exclusivitées
     * 
     * @return {@link List}
     */
	@GetMapping(value="/events")
	public List<Event> getAllEvents(){
		videogameService.fixExclusivity();
		List<Event> events = eventService.getAll();
		return events;
	}
	
    /**
     * Renvoie l'Event suivant son numero
     * 
     * @param id : le numero de l'Event concerné
     * @return {@link Event}
     */
	@GetMapping(value="event/{id}")
	public Event getEventById(@PathVariable("id")int id) {
		return eventService.getById(id);
	}
	
    /**
     * Ajoute ou supprime le gamer de l'event
     * 
     * @param id : le numero de l'Event concerné
     * @param gamer : gamer concerné
     */
	@PostMapping(value="/event/{id}")
	public void postUpdateGroup(@PathVariable("id") int id, @RequestBody Gamer gamer) {
		Event event = eventService.getById(id);
		eventService.updateGroupEvent(event, gamer);
	}
	
    /**
     * Ajoute a la base un nouvel event
     * 
     * @param Event : Event concerné
     */
	@PostMapping(value="/post_event")
	public void addNewEvent(@RequestBody Event event) {
		String videogame_name = event.getVgname();
		String plateform = event.getPlateform();
		int maximum_players = event.getPlayer_needed();
		event.setMaximum_players(maximum_players);
		Gamer host = event.getParticipants().get(0);
		Videogame videogame = videogameService.findByNomAndPlateform(videogame_name, plateform);
		event.setVideogame(videogame);
		event.setHost(host);
		eventService.addNewEvent(event);
	}
	
    /**
     * Supprime un event
     *
     * @param event: Event concerné
     */
	@PostMapping(value = "/delete_event/{id}")
	public void deleteEvent(@PathVariable("id") int id) {
		Event event = eventService.getById(id);
		eventService.deleteEvent(event);
	}
	
    /**
     * Ajoute a la base un nouvel event
     * 
     * @param Event : Event concerné
     */
	@PostMapping(value="/search_event")
	public List<Event> getEventByVideoGame(@RequestBody Videogame videogame){
		String recherche = videogame.getNom();
		return eventService.searchEvent(recherche);
	}
	

	
}
