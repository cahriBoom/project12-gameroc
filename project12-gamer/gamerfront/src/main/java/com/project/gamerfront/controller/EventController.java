package com.project.gamerfront.controller;

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
import com.project.gamerfront.service.VideogameService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private VideogameService videogameService;
	
	@GetMapping(value="/post_event")
	public String getPostEvent(Model model) {
		List<VideogameBean> videogames = videogameService.getAll();
		model.addAttribute("videogames", videogames);
		model.addAttribute("event", new EventBean());
		return "/post_event";
	}
	
	@PostMapping(value="/post_event")
	public String postPostEvent(Model model, @ModelAttribute("event") EventBean event) {

		return "/post_event";
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
		model.addAttribute("events", events);
		model.addAttribute("current", current);
		return "/search_event";
	}
}
