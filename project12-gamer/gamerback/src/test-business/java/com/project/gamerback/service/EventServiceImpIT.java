package com.project.gamerback.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Gamer;
import com.project.gamerback.model.Videogame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceImpIT {

	private List<Gamer> participants = new ArrayList<>();

	private Gamer host = new Gamer();

	private Videogame videogame = new Videogame();

	@Autowired
	private EventService eventService;

	@Autowired
	private GamerService gamerService;

	@Autowired
	private VideogameService videogameService;

	@Before
	public void setUpEvent() {
		host = gamerService.getById(12).get();
		videogame = videogameService.getById(14);
		Event event = new Event(new Date(), "Minecraft survie in hardcore", "Survie", 6, 5, videogame,
				videogame.getNom(), host);
		participants.add(host);
		event.setPlateform("PC");
		event.setParticipants(participants);
		eventService.addNewEvent(event);
	}

	@After
	public void deleteEvent(Event event) {
		eventService.deleteEvent(event);

	}

	@Test
	public void testGetAll() {
		// Arrange
		List<Event> all = eventService.getAll();

		// Act
		int size = all.size();

		// Assert
		Assert.assertNotNull(size);

	}

	@Test
	public void testGetById() {
		// Arrange
		String title_expected = "Raid";

		// Act
		Event event = eventService.getById(1);
		String title_actual = event.getTitle();

		// Assert
		Assert.assertEquals(title_expected, title_actual);
	}

	@Test
	public void testCalculateSpotsTaken() {
		// Arrange
		int spots_expected = 2;

		// Act
		eventService.calculateSpotsTaken();
		Event actual = eventService.getById(1);

		// Assert
		Assert.assertEquals(spots_expected, actual.getSpots());

	}

	@Test
	public void testAddNewEvent() {
		// Arrange
		host = gamerService.getById(12).get();
		videogame = videogameService.getById(14);
		Event event = new Event();
		participants.add(host);
		event.setDescription("Minecraft");
		event.setHost(host);
		event.setMaximum_players(6);
		event.setTitle("Minecraft");
		event.setVgname(videogame.getNom());
		event.setVideogame(videogame);
		event.setSpots(5);
		event.setPlateform("PC");
		event.setParticipants(participants);

		// Act
		eventService.addNewEvent(event);
		Event actual = eventService.searchEvent("Minecraft").get(0);

		// Assert
		Assert.assertNotNull(actual);
		this.deleteEvent(event);
	}

	@Test
	public void testSearchEvent() {
		// Arrange
		Event expected = eventService.getById(2);
		String search = "Overwatch";

		// Act
		List<Event> events = eventService.searchEvent(search);
		Event actual = events.get(0);

		// Assert
		Assert.assertEquals(expected.getId(), actual.getId());

	}

	@Test
	public void testIsAlreadyInTrue() {
		// Arrange
		Event event = eventService.getById(2);
		Gamer gamer = gamerService.getById(12).get();
		
		// Act
		boolean isAlreadyIn = eventService.isAlreadyIn(event, gamer);

		// Assert
		Assert.assertTrue(isAlreadyIn);
	}

	@Test
	public void testIsAlreadyInFalse() {
		// Arrange
		Event event = eventService.getById(3);
		Gamer gamer = gamerService.getById(13).get();
		
		// Act
		boolean isAlreadyIn = eventService.isAlreadyIn(event, gamer);

		// Assert
		Assert.assertFalse(isAlreadyIn);
	}
	
	@Test
	public void testParticipateToEvent() {
		// Arrange
		Event event = eventService.getById(5);
		Gamer gamer = gamerService.getById(12).get();
		
		
		// Act
		eventService.participateToEvent(event, gamer);
		boolean isIn = eventService.isAlreadyIn(event, gamer);
		eventService.quittingEvent(event, gamer);

		// Assert
		Assert.assertTrue(isIn);
		
	}

	@Test
	public void testQuittingEvent() {
		// Arrange
		Event event = eventService.getById(5);
		Gamer gamer = gamerService.getById(12).get();
		
		// Act
		eventService.participateToEvent(event, gamer);
		eventService.quittingEvent(event, gamer);
		boolean isIn = eventService.isAlreadyIn(event, gamer);

		// Assert
		Assert.assertFalse(isIn);
		
		
		
	}

}
