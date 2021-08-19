package com.project.gamerback.service;

import java.util.List;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Gamer;

public interface EventService {

	List<Event> getAll();
	
	Event getById(int id);
	
	void addNewEvent(Event event);
	
	void calculateSpotsTaken(Event event);
		
	List<Event> searchEvent(String search);
	
	void participateToEvent(Event event, Gamer gamer);
}
