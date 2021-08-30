package com.project.gamerback.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Gamer;

public class EventServiceImpIT {

	private List<Gamer> participants = new ArrayList<>();

	@Autowired
	private EventService eventService;

	@Before
	public void setUps() {

	}

	@Test
	public void testGetAll() {
		// Arrange

		
		
		// Act

		
		
		// Assert
		
		
	}

	@Test
	public void testGetById(int id) {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testAddNewEvent(Event event) {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testCalculateSpotsTaken(Event event) {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testSearchEvent(String search) {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testUdateGroupEvent(Event event, Gamer gamer) {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testParticipateToEvent(Event event, Gamer gamer) {
		// Arrange

		// Act

		// Assert
	}

	@Test
	public void testQuittingEvent(Event event, Gamer gamer) {
		// Arrange

		// Act

		// Assert
	}

}
