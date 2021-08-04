package com.project.gamerback.service;

import java.util.List;

import com.project.gamerback.model.Event;

public interface EventService {

	List<Event> getAll();
	
	Event getById(int id);
	
	void calculateSpotsTaken(Event event);
}
