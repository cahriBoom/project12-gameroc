package com.project.gamerback.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerback.model.Event;
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
		int participants = event.getParticipants().size();
		int spots_available = event.getPlayer_needed() - participants;
		if (spots_available<=0) {
			spots_available=0;
		}
		event.setSpots(spots_available);
		eventRepository.save(event);
	}

}
