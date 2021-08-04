package com.project.gamerfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.service.EventService;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping(value="/post_event")
	public String getPostEvent(Model model) {

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
	
	@PostMapping(value="/post_event")
	public String postPostEvent(Model model) {
		
		return "/post_event";
	}
	
	@GetMapping(value="/search_event")
	public String getSearchEvent(Model model) {
		List<EventBean> events = eventService.getAllEvents();
		model.addAttribute("events", events);
		return "/search_event";
	}
}
