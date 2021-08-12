package com.project.gamerfront.service;

import java.util.List;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.VideogameBean;

public interface EventService {

	List<EventBean> getAllEvents();
	
	List<EventBean> allEventAvailable(List<EventBean> events);
	
	EventBean getEventById(int id);
	
	void addEvent(EventBean event);
	
	List<EventBean> getEventsByGame(VideogameBean videogame);
	
}
