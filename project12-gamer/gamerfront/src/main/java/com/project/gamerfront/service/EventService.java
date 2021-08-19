package com.project.gamerfront.service;

import java.util.List;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.beans.VideogameBean;

public interface EventService {

	List<EventBean> getAllEvents();
	
	List<EventBean> allEventAvailable(List<EventBean> events);
	
	EventBean getEventById(int id);
	
	void addEvent(EventBean event);
	
	List<EventBean> getEventsBySearch(VideogameBean videogame);
	
	boolean isEligible(EventBean event, String username);
	
	List<EventBean> RemoveOwnEvents(List<EventBean> events, String username);
	
	void participateToEvent(GamerBean gamer, EventBean event);
	
	boolean isAlreadyIn(String current, EventBean event);
		
	List<EventBean> findEventsByGamer(GamerBean gamer);
}
