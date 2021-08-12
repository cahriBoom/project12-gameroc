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

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private GamerService gamerService;
	
	@Autowired
	private VideogameService videogameService;
	
	@GetMapping(value="/post_event")
	public String getPostEvent(Model model) {
		List<String> videogames_without_dupplicate = videogameService.getGamesWithoutDupplicate();
		model.addAttribute("videogames", videogames_without_dupplicate);
		model.addAttribute("event", new EventBean());
		return "/post_event";
	}
	
	@PostMapping(value="/post_event")
	public String postPostEvent(Model model, @ModelAttribute("event") EventBean event) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		GamerBean host = gamerService.getByMail(username);
		VideogameBean game = videogameService.getByNameAndPlateform(event.getVideogame_name(), event.getPlateform());
		List<GamerBean> participants = new ArrayList<>();
		participants.add(host);
		event.setParticipants(participants);
		event.setVideogame(game);
		eventService.addEvent(event);
		model.addAttribute("event", event);
		return "/home";
	}
	
	@GetMapping(value="/event/{id}")
	public String getEventDescription(Model model, @PathVariable("id") int id) {
		EventBean event = eventService.getEventById(id);
		List<GamerBean> gamers = event.getParticipants();
		model.addAttribute("gamers", gamers);
		model.addAttribute("event", event);
		return "/event";
	}
	

	@GetMapping(value="/search_event")
	public String getSearchEvent(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String current = auth.getName();
		
		List<EventBean> events = eventService.getAllEvents();
		List<String> list_games = videogameService.getGamesWithoutDupplicate();
		
		model.addAttribute("videogame", new VideogameBean());
		model.addAttribute("events", events);
		model.addAttribute("games", list_games);
		model.addAttribute("current", current);
		return "/search_event";
	}
	
	@PostMapping(value="/search_event")
	public String postSearchEvent(Model model, @ModelAttribute("videogame") VideogameBean videogame) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String current = auth.getName();
		
		List<String> list_games = videogameService.getGamesWithoutDupplicate();
		List<EventBean> events = eventService.getEventsByGame(videogame);
		
		model.addAttribute("events", events);
		model.addAttribute("games", list_games);
		model.addAttribute("current", current);
		return "/search_event";
	}
}
