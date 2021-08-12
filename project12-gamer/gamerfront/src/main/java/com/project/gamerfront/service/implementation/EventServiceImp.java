package com.project.gamerfront.service.implementation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.VideogameBean;
import com.project.gamerfront.proxies.GamerProxy;
import com.project.gamerfront.service.EventService;

@Service("eventService")
public class EventServiceImp implements EventService{

	@Autowired
	private GamerProxy gamerProxy;
	
	@Override
	public List<EventBean> allEventAvailable(List<EventBean> events) {
		List<EventBean> event_available = new ArrayList<>();
		for(EventBean e:events) {
			int spots = e.getSpots();
			if(spots>=1) {
				event_available.add(e);
			}
		}
		return event_available;
	}
	
	@Override
	public List<EventBean> getAllEvents() {
		List<EventBean> all_events = gamerProxy.getAllEvents();
		return this.allEventAvailable(all_events);
	}

	@Override
	public EventBean getEventById(int id) {
		return gamerProxy.getEventById(id);
	}

	@Override
	public void addEvent(EventBean event) {
		Calendar cal = Calendar.getInstance();
		Date debut = Calendar.getInstance().getTime();
		int spots = event.getPlayer_needed();
		cal.add(Calendar.HOUR, 24);
		Date fin = cal.getTime();
		
		event.setDebut(debut);
		event.setFin(fin);
		event.setSpots(spots);
		gamerProxy.addNewEvent(event);		
	}

	@Override
	public List<EventBean> getEventsByGame(VideogameBean videogame) {	
		List<EventBean> events = gamerProxy.getEventByGame(videogame);
		return events;
	}



}
