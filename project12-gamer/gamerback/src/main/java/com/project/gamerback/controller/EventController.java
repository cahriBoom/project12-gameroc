package com.project.gamerback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamerback.model.Event;
import com.project.gamerback.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping(value="/events")
	public List<Event> getAllEvents(){
		return eventService.getAll();
	}
	
	@GetMapping(value="event/{id}")
	public Event getEventById(@PathVariable("id")int id) {
		return eventService.getById(id);
	}
	
}
