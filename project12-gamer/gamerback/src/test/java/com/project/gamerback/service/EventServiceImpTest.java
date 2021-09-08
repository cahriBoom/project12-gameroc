package com.project.gamerback.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Gamer;
import com.project.gamerback.model.Videogame;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EventServiceImpTest {
	
	@Mock
	private EventService mockService;

	private List<Gamer> participants = new ArrayList<Gamer>();
	
	private Gamer host = new Gamer("test@gmail.com", "Testor", "testor", "PC", "Europe");
	
	private Videogame videogame = new Videogame("Minecraft", "PC");
	
	private Event event = new Event(new Date(), "description", "title", 6, 5, videogame, videogame.getNom(), host);
	
	private List<Event> events = new ArrayList<Event>();

	@Before
	public void setUp() {		
		for (int i = 0; i < 3; i++) {
			Event e = new Event(new Date(), "description", "title", 6, 5, videogame, videogame.getNom(), host);
			e.setParticipants(participants);
			events.add(e);
		}
	}

	@Test
	public void testGetAll() {
		// Arrange
		Mockito.when(mockService.getAll()).thenReturn(events);

		// Act
		List<Event> all_events = mockService.getAll();

		// Assert
		Assert.assertEquals(events, all_events);
		Mockito.verify(mockService).getAll();
	}

	@Test
	public void testGetById() {
		// Arrange
		this.setUp();
		Mockito.when(mockService.getById(1)).thenReturn(event);
		
		// Act
		Event actual = mockService.getById(1);

		// Assert
		Assert.assertEquals(event.getId(), actual.getId());
		Mockito.verify(mockService).getById(1);
		
	}
	
	@Test
	public void testGetByIdNull() {
		// Arrange
		Mockito.when(mockService.getById(1)).thenReturn(null);
		
		// Act
		Event actual = mockService.getById(1);
		
		// Assert
		Assert.assertNull(actual);
		Mockito.verify(mockService).getById(1);
	}

	@Test
	public void testAddNewEvent() {
		// Arrange
		Mockito.doNothing().when(mockService).addNewEvent(event);
		
		// Act
		mockService.addNewEvent(event);
		
		// Assert
		Mockito.verify(mockService).addNewEvent(event);
	}

	@Test
	public void testCalculateSpotsTaken() {
		// Arrange
		Mockito.doNothing().when(mockService).calculateSpotsTaken();
		
		// Act
		mockService.calculateSpotsTaken();
		
		// Assert
		Mockito.verify(mockService).calculateSpotsTaken();
	}

	@Test
	public void testSearchEvent() {
		// Arrange
		Mockito.when(mockService.searchEvent("Minecraft")).thenReturn(events);
		
		// Act
		List<Event> search = mockService.searchEvent("Minecraft");
		
		// Assert
		Assert.assertEquals(events, search);
		Mockito.verify(mockService).searchEvent("Minecraft");
	}

	@Test
	public void testUpdateGroupEvent() {
		// Arrange
		Mockito.doNothing().when(mockService).updateGroupEvent(event, host);
		
		// Act
		mockService.updateGroupEvent(event, host);
		
		// Assert
		Mockito.verify(mockService).updateGroupEvent(event, host);
	}

	@Test
	public void testIsAlreadyInTrue() {
		// Arrange
		Mockito.when(mockService.isAlreadyIn(event, host)).thenReturn(true);
		
		// Act
		boolean isAlreadyIn = mockService.isAlreadyIn(event, host);
		
		// Assert
		Assert.assertTrue(isAlreadyIn);
		Mockito.verify(mockService).isAlreadyIn(event, host);

	}
	
	@Test
	public void testIsAlreadyInFalse() {
		// Arrange
		Mockito.when(mockService.isAlreadyIn(event, host)).thenReturn(false);
		
		// Act
		boolean isAlreadyIn = mockService.isAlreadyIn(event, host);
		
		// Assert
		Assert.assertFalse(isAlreadyIn);
		Mockito.verify(mockService).isAlreadyIn(event, host);
	}

	@Test
	public void testParticipateToEvent() {
		// Arrange
		Mockito.doNothing().when(mockService).participateToEvent(event, host);
		
		// Act
		mockService.participateToEvent(event, host);
		
		// Assert
		Mockito.verify(mockService).participateToEvent(event, host);
	}

	@Test
	public void testQuittingEvent() {
		// Arrange
		Mockito.doNothing().when(mockService).quittingEvent(event, host);
		
		// Act
		mockService.quittingEvent(event, host);
		
		// Assert
		Mockito.verify(mockService).quittingEvent(event, host);
	}

}
