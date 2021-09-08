package com.project.gamerfront.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.beans.VideogameBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceImpIT {

	private List<GamerBean> participants = new ArrayList<>();

	private GamerBean host = new GamerBean();

	private VideogameBean videogame = new VideogameBean();

	private EventBean event = new EventBean();
	
	@Autowired
	private EventService eventService;

	@Autowired
	private VideogameService videogameService;

	@Autowired
	private GamerService gamerService;


	@Test
	public void testGetAllEvents() {
		// Arrange
		List<EventBean> events = eventService.getAllEvents();

		// Act
		int size = events.size();

		// Assert
		Assert.assertNotNull(size);

	}

	@Test
	public void testAllEventAvailable() {
		// Arrange
		List<EventBean> events = eventService.getAllEvents();

		// Act
		List<EventBean> events_available = eventService.allEventAvailable(events);

		// Assert
		Assert.assertNotNull(events_available);
	}

	@Test
	public void testGetEventById() {
		// Arrange
		EventBean event = eventService.getEventById(1);

		// Act
		String actual = event.getTitle();

		// Assert
		Assert.assertEquals("Raid", actual);
	}

	@Test
	public void testAddEvent() {
		// Arrange
		host = gamerService.getById(12);
		videogame = videogameService.getById(14);
		participants.add(host);
		event.setDescription("Minecraft");
		event.setHost(host);
		event.setMaximum_player(6);
		event.setTitle("Survie");
		event.setVgname(videogame.getNom());
		event.setVideogame(videogame);
		event.setSpots(5);
		event.setPlateform("PC");
		event.setParticipants(participants);

		// Act
		eventService.addEvent(event);

		// Assert
		Assert.assertNotNull(event);
		eventService.deleteEvent(event);
	}

	@Test
	public void testGetEventsBySearch() {
		// Arrange
		EventBean e = eventService.getEventById(1);
		VideogameBean videogame = e.getVideogame();

		// Act
		List<EventBean> actual = eventService.getEventsBySearch(videogame);

		// Assert
		Assert.assertNotNull(actual);
	}

	@Test
	public void testIsEligibleTrue() {
		// Arrange
		EventBean event = eventService.getEventById(4);
		GamerBean gamer = gamerService.getById(12);
		String mail = gamer.getEmail();

		// Act
		boolean isEligible = eventService.isEligible(event, mail);

		// Assert
		Assert.assertTrue(isEligible);
	}

	@Test
	public void testIsEligibleFalse() {
		// Arrange
		EventBean event = eventService.getEventById(1);
		GamerBean gamer = gamerService.getById(12);
		String mail = gamer.getEmail();

		// Act
		boolean isEligible = eventService.isEligible(event, mail);

		// Assert
		Assert.assertFalse(isEligible);
	}

	@Test
	public void testRemoveOwnEvents() {
		// Arrange
		List<EventBean> events = eventService.getAllEvents();
		GamerBean gamer = gamerService.getById(1);
		EventBean unexpected = events.get(0);
		String mail = gamer.getEmail();

		// Act
		List<EventBean> events_own_removed = eventService.RemoveOwnEvents(events, mail);
		EventBean actual = events_own_removed.get(0);

		// Assert
		Assert.assertNotEquals(unexpected, actual);

	}

	@Test
	public void testUpdateGroupEvent() {
		// Arrange
		EventBean event_before = eventService.getEventById(1);
		List<GamerBean> parti_before = event_before.getParticipants();
		GamerBean gamer = gamerService.getById(2);

		// Act
		eventService.updateGroupEvent(gamer, event_before);
		EventBean event_after = eventService.getEventById(1);
		List<GamerBean> parti_after = event_after.getParticipants();
		int size_before = parti_before.size();
		int size_after = parti_after.size();

		// Assert
		Assert.assertNotEquals(size_before, size_after);
	}

	@Test
	public void testIsAlreadyInTrue() {
		// Arrange
		EventBean event = eventService.getEventById(1);
		GamerBean gamer = gamerService.getById(1);
		String mail = gamer.getEmail();

		// Act
		boolean isAlreadyIn = eventService.isAlreadyIn(mail, event);

		// Assert
		Assert.assertTrue(isAlreadyIn);
	}

	@Test
	public void testIsAlreadyInFalse() {
		// Arrange
		EventBean event = eventService.getEventById(1);
		GamerBean gamer = gamerService.getById(13);
		String mail = gamer.getEmail();

		// Act
		boolean isAlreadyIn = eventService.isAlreadyIn(mail, event);

		// Assert
		Assert.assertFalse(isAlreadyIn);
	}

	@Test
	public void testFindEventsByGamer() {
		// Arrange
		GamerBean gamer = gamerService.getById(1);

		// Act
		List<EventBean> events = eventService.findEventsByGamer(gamer);

		// Assert
		Assert.assertNotNull(events);
	}
}
