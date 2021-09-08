package com.project.gamerback.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Gamer;
import com.project.gamerback.repository.EventRepository;
import com.project.gamerback.service.EventService;

/**
 * Implementation du service Event
 */
@Service
public class EventServiceImp implements EventService {

	@Autowired
	private EventRepository eventRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Event> getAll() {
		List<Event> new_events = eventRepository.findAll();
		return new_events;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Event getById(int id) {
		return eventRepository.findById(id).get();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void calculateSpotsTaken() {
		List<Event> events = eventRepository.findAll();
		for (Event e : events) {
			int maximum = e.getMaximum_players();
			int participants = e.getParticipants().size();
			int spots = maximum - participants;
			if (spots <= 0) {
				spots = 0;
			}
			e.setSpots(spots);
			eventRepository.save(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addNewEvent(Event event) {
		int maximum = event.getMaximum_players();
		int participants = event.getParticipants().size();
		int spots = maximum - participants;
		if (spots <= 0) {
			spots = 0;
		}
		event.setSpots(spots);
		eventRepository.save(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteEvent(Event event) {
		Gamer host = event.getHost();
		this.quittingEvent(event, host);
		eventRepository.delete(event);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Event> searchEvent(String search) {
		List<Event> recherchePlateform = eventRepository.findByPlateformContaining(search);
		List<Event> rechercheName = eventRepository.findByVgnameContaining(search);
		List<Event> rechercheTitle = eventRepository.findByTitleContaining(search);
		List<Event> searched_events = new ArrayList<>();

		// Vérifie si l'utilisateur a rentré un nom, une plateforme ou un titre
		if (!recherchePlateform.isEmpty()) {
			return recherchePlateform;
		} else if (!rechercheName.isEmpty()) {
			return rechercheName;
		} else if (!rechercheTitle.isEmpty()) {
			return rechercheTitle;
		}
		return searched_events;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateGroupEvent(Event event, Gamer gamer) {
		if (this.isAlreadyIn(event, gamer)) {
			this.quittingEvent(event, gamer);
		} else {
			this.participateToEvent(event, gamer);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void participateToEvent(Event event, Gamer gamer) {
		List<Gamer> participants = event.getParticipants();
		int spots = event.getSpots();
		participants.add(gamer);
		event.setSpots(spots - 1);
		eventRepository.save(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void quittingEvent(Event event, Gamer gamer) {
		List<Gamer> participants = event.getParticipants();
		List<Gamer> new_participants = new ArrayList<>();
		String username = gamer.getEmail();
		int spots = event.getSpots();
		for (Gamer g : participants) {
			String g_mail = g.getEmail();
			if (!g_mail.equals(username)) {
				new_participants.add(g);
			}
		}
		event.setSpots(spots + 1);
		event.setParticipants(new_participants);
		eventRepository.save(event);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAlreadyIn(Event event, Gamer gamer) {
		List<Gamer> participants = event.getParticipants();
		String username = gamer.getEmail();
		for (Gamer g : participants) {
			String g_mail = g.getEmail();
			if (g_mail.equals(username)) {
				return true;
			}
		}
		return false;
	}



}
