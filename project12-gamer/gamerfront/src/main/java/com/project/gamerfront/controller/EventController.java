package com.project.gamerfront.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.beans.VideogameBean;
import com.project.gamerfront.service.EventService;
import com.project.gamerfront.service.GamerService;
import com.project.gamerfront.service.VideogameService;

/**
 * Contrôleur des objets du packages Event
 */
@Controller
public class EventController {

	@Autowired
	private EventService eventService;

	@Autowired
	private GamerService gamerService;

	@Autowired
	private VideogameService videogameService;

    /**
     * Mapping pour la page de création d'Event
     * 
     */
	@GetMapping(value = "/post_event")
	public String getPostEvent(Model model) {
		List<String> videogames_without_dupplicate = videogameService.getGamesWithoutDupplicate();
		model.addAttribute("videogames", videogames_without_dupplicate);
		model.addAttribute("event", new EventBean());
		return "/post_event";
	}

    /**
     * Mapping pour le formulaire de création d'Event
     * 
     * @param event: nouvel Event crée
     */
	@PostMapping(value = "/post_event")
	public String postPostEvent(Model model, @ModelAttribute("event") EventBean event) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		GamerBean host = gamerService.getByMail(username);
		List<GamerBean> participants = new ArrayList<>();
		participants.add(host);
		event.setParticipants(participants);
		eventService.addEvent(event);
		model.addAttribute("event", event);
		return "/home";
	}

    /**
     * Mapping pour la page de description d'un Event
     * 
     * @param id: numero de l'Event 
     */
	@GetMapping(value = "/event/{id}")
	public String getEventDescription(Model model, @PathVariable("id") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		EventBean event = eventService.getEventById(id);
		List<GamerBean> gamers = event.getParticipants();
		boolean isEligible = eventService.isEligible(event, username);
		boolean isAlreadyIn = eventService.isAlreadyIn(username, event);
		
		model.addAttribute("isEligible", isEligible);
		model.addAttribute("isAlreadyIn", isAlreadyIn);
		model.addAttribute("gamers", gamers);
		model.addAttribute("event", event);
		model.addAttribute("host", new GamerBean());
		return "/event";
	}
	
    /**
     * Mapping pour le formulaire d'entrée d'un joueur dans un groupe
     * 
     * @param id: numero de l'Event
     * @param gamer: gamer voulant etre ajouter au groupe
     */
	@PostMapping(value = "/event/{id}")
	public String postEventJoinGroup(Model model, @PathVariable("id") int id, @ModelAttribute("host") GamerBean gamer) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		EventBean event = eventService.getEventById(id);
		GamerBean current_gamer = gamerService.getByMail(username);
		eventService.updateGroupEvent(current_gamer, event);
		EventBean updatedEvent = eventService.getEventById(id);
		List<GamerBean> gamers = updatedEvent.getParticipants();
		boolean isEligible = eventService.isEligible(updatedEvent, username);
		boolean isAlreadyIn = eventService.isAlreadyIn(username, event);
		
		model.addAttribute("isEligible", isEligible);
		model.addAttribute("isAlreadyIn", isAlreadyIn);
		model.addAttribute("gamers", gamers);
		model.addAttribute("event", updatedEvent);
		model.addAttribute("host", new GamerBean());
		return "/event";
	}
	
    /**
     * Mapping pour la page de recherche d'Event
     * 
     */
	@GetMapping(value = "/search_event")
	public String getSearchEvent(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		List<EventBean> events = eventService.getAllEvents();
		List<String> list_games = videogameService.getGamesWithoutDupplicate();
		List<EventBean> not_host_event = eventService.RemoveOwnEvents(events, username);

		model.addAttribute("videogame", new VideogameBean());
		model.addAttribute("events", not_host_event);
		model.addAttribute("games", list_games);
		return "/search_event";
	}

    /**
     * Mapping pour le formulaire de recherche précise d'Event
     * 
     * @param videogame: Videogame lié à l'Event 
     */
	@PostMapping(value = "/search_event")
	public String postSearchEvent(Model model, @ModelAttribute("videogame") VideogameBean videogame) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String current = auth.getName();
		List<String> list_games = videogameService.getGamesWithoutDupplicate();
		List<EventBean> events = eventService.getEventsBySearch(videogame);

		model.addAttribute("events", events);
		model.addAttribute("games", list_games);
		model.addAttribute("current", current);
		return "/search_event";
	}

}
