package com.project.gamerback.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Videogame;
import com.project.gamerback.repository.EventRepository;
import com.project.gamerback.service.EventService;

@Service
public class EventServiceImp implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> getAll() {
		List<Event> events = eventRepository.findAll();
		for(Event e:events) {
			this.calculateSpotsTaken(e);
		}
		List<Event> new_events = eventRepository.findAll();
		return new_events;
	}

	@Override
	public Event getById(int id) {
		return eventRepository.findById(id).get();
	}

	@Override
	public void calculateSpotsTaken(Event event) {
		int maximum = event.getMaximum_players();
		int participants = event.getParticipants().size();
		int spots = maximum - participants;
		if(spots<=0) {
			spots=0;
		}
		event.setSpots(spots);
		eventRepository.save(event);
	}

	@Override
	public void addNewEvent(Event event) {
		eventRepository.save(event);
	}

	@Override
	public List<Event> getEventByGame(Videogame videogame) {
		String name = videogame.getNom();
		List<Event> all_events = eventRepository.findAll();
		List<Event> events = new ArrayList<>();
		
		for(Event e:all_events) {
			if(e.getVideogame_name().equals(name)) {
				events.add(e);
			}
		}
		return events;
	}

}
