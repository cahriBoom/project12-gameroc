package com.project.gamerfront.service.implementation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.beans.VideogameBean;
import com.project.gamerfront.proxies.GamerProxy;
import com.project.gamerfront.service.EventService;

@Service("eventService")
public class EventServiceImp implements EventService {

	@Autowired
	private GamerProxy gamerProxy;

	@Override
	public List<EventBean> allEventAvailable(List<EventBean> events) {
		List<EventBean> event_available = new ArrayList<>();
		for (EventBean e : events) {
			int spots = e.getSpots();
			if (spots >= 1) {
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
	public List<EventBean> getEventsBySearch(VideogameBean videogame) {
		List<EventBean> events = gamerProxy.getEventByGame(videogame);
		List<EventBean> available_events = this.allEventAvailable(events);
		return available_events;
	}

	@Override
	public boolean isEligible(EventBean event, String username) {
		Date today = Calendar.getInstance().getTime();
		boolean isLogged = false;
		boolean isAvailable = false;
		boolean isStillDated = false;
		boolean isHost = false;
		boolean isAlreadyIn = this.isAlreadyIn(username, event);

		if (!username.equals("anonymousUser")) {
			isLogged = true;
		}
		if (event.getSpots() > 0) {
			isAvailable = true;
		}
		if (event.getFin().after(today)) {
			isStillDated = true;
		}
		if (event.getHost().getEmail().equals(username)) {
			isHost = true;
		}

		if (isLogged && isAvailable && isStillDated && !isHost && !isAlreadyIn) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAlreadyIn(String current, EventBean event) {
		List<GamerBean> participants = event.getParticipants();
		for (GamerBean g : participants) {
			String mail = g.getEmail();
			if (mail.equals(current)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<EventBean> RemoveOwnEvents(List<EventBean> events, String username) {
		List<EventBean> host_event = new ArrayList<>();
		for (EventBean e : events) {
			String hostname = e.getHost().getEmail();
			if (!hostname.equals(username)) {
				host_event.add(e);
			}
		}
		return host_event;
	}

	@Override
	public void participateToEvent(GamerBean gamer, EventBean event) {
		int id = event.getId();
		gamerProxy.postJoinGroup(id, gamer);
	}

	@Override
	public List<EventBean> findEventsByGamer(GamerBean gamer) {
		List<EventBean> all_events = gamerProxy.getAllEvents();
		List<EventBean> events_participated = new ArrayList<>();
		for(EventBean e:all_events) {
			List<GamerBean> participants = e.getParticipants();
			for(GamerBean g:participants) {
				String mail = g.getEmail();
				if(mail.equals(gamer.getEmail())){
					events_participated.add(e);
				}
			}
		}
		return events_participated;
	}



}
