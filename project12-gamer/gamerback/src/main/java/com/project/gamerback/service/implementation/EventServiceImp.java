package com.project.gamerback.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Gamer;
import com.project.gamerback.repository.EventRepository;
import com.project.gamerback.service.EventService;

@Service
public class EventServiceImp implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getAll() {
		List<Event> events = eventRepository.findAll();
		for (Event e : events) {
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
		if (spots <= 0) {
			spots = 0;
		}
		event.setSpots(spots);
		eventRepository.save(event);
	}

	@Override
	public void addNewEvent(Event event) {
		eventRepository.save(event);
	}

	@Override
	public List<Event> searchEvent(String search) {
		List<Event> recherchePlateform = eventRepository.findByPlateformContaining(search);
		List<Event> rechercheName = eventRepository.findByVgnameContaining(search);
		List<Event> rechercheTitle = eventRepository.findByTitleContaining(search);
		List<Event> searched_events = new ArrayList<>();
		if (!recherchePlateform.isEmpty()) {
			return recherchePlateform;
		} else if (!rechercheName.isEmpty()) {
			return rechercheName;
		} else if (!rechercheTitle.isEmpty()) {
			return rechercheTitle;
		}
		return searched_events;
	}

	@Override
	public void participateToEvent(Event event, Gamer gamer) {
		List<Gamer> participants = event.getParticipants();
		int spots = event.getSpots();
		participants.add(gamer);
		event.setSpots(spots-1);
		eventRepository.save(event);
	}



}
