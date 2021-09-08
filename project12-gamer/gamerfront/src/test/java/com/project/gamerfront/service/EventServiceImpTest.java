package com.project.gamerfront.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.beans.VideogameBean;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EventServiceImpTest {

	@Mock
	private EventService mockService;

	private VideogameBean videogame = new VideogameBean();

	private GamerBean host = new GamerBean();

	private EventBean event = new EventBean(new Date(), "description", "title", 5, 6, videogame, "vg_name", host);

	private List<EventBean> events = new ArrayList<EventBean>();

	private List<EventBean> events_available = new ArrayList<>();

	@Test
	public void testGetAllEvents() {
		// Arrange
		Mockito.when(mockService.getAllEvents()).thenReturn(events);

		// Act
		List<EventBean> all_events = mockService.getAllEvents();

		// Assert
		Assert.assertEquals(events, all_events);
		Mockito.verify(mockService).getAllEvents();

	}

	@Test
	public void testAllEventAvailable() {
		// Arrange
		Mockito.when(mockService.allEventAvailable(events)).thenReturn(events_available);

		// Act
		List<EventBean> all_events = mockService.allEventAvailable(events);

		// Assert
		Assert.assertEquals(events_available, all_events);
		Mockito.verify(mockService).allEventAvailable(events);

	}

	@Test
	public void testGetEventById() {
		// Arrange
		Mockito.when(mockService.getEventById(1)).thenReturn(event);

		// Act
		EventBean actual = mockService.getEventById(1);

		// Assert
		Assert.assertEquals(event, actual);
		Mockito.verify(mockService).getEventById(1);

	}

	@Test
	public void testGetEventByIdNull() {
		// Arrange
		Mockito.when(mockService.getEventById(1)).thenReturn(null);

		// Act
		EventBean actual = mockService.getEventById(1);

		// Assert
		Assert.assertNull(actual);
		Mockito.verify(mockService).getEventById(1);

	}

	@Test
	public void testAddEvent() {
		// Arrange
		Mockito.doNothing().when(mockService).addEvent(event);

		// Act
		mockService.addEvent(event);

		// Assert
		Mockito.verify(mockService).addEvent(event);
	}

	@Test
	public void testGetEventsBySearch() {
		// Arrange
		Mockito.when(mockService.getEventsBySearch(videogame)).thenReturn(events);

		// Act
		List<EventBean> actual = mockService.getEventsBySearch(videogame);

		// Assert
		Assert.assertEquals(events, actual);
		Mockito.verify(mockService).getEventsBySearch(videogame);
	}

	@Test
	public void testIsEligibleTrue() {
		// Arrange
		Mockito.when(mockService.isEligible(event, "user@gmail.com")).thenReturn(true);
		
		// Act
		boolean isEligible = mockService.isEligible(event, "user@gmail.com");

		// Assert
		Assert.assertTrue(isEligible);
		Mockito.verify(mockService).isEligible(event, "user@gmail.com");
	}

	@Test
	public void testIsEligibleFalse() {
		// Arrange
		Mockito.when(mockService.isEligible(event, "user@gmail.com")).thenReturn(false);
		
		// Act
		boolean isEligible = mockService.isEligible(event, "user@gmail.com");

		// Assert
		Assert.assertFalse(isEligible);
		Mockito.verify(mockService).isEligible(event, "user@gmail.com");
	}
	
	@Test
	public void testRemoveOwnEvents() {
		// Arrange
		Mockito.when(mockService.RemoveOwnEvents(events, "user@gmail.com")).thenReturn(events_available);
		
		// Act
		List<EventBean> actual = mockService.RemoveOwnEvents(events, "user@gmail.com");
		
		// Assert
		Assert.assertEquals(events_available, actual);
		Mockito.verify(mockService).RemoveOwnEvents(actual, "user@gmail.com");
		
	}

	@Test
	public void testUpdateGroupEvent() {
		// Arrange
		Mockito.doNothing().when(mockService).updateGroupEvent(host, event);

		// Act
		mockService.updateGroupEvent(host, event);

		// Assert
		Mockito.verify(mockService).updateGroupEvent(host, event);
	}

	@Test
	public void testIsAlreadyInTrue() {
		// Arrange
		Mockito.when(mockService.isAlreadyIn("user@gmail.com", event)).thenReturn(true);
		
		// Act
		boolean isAlreadyIn = mockService.isAlreadyIn("user@gmail.com", event);

		// Assert
		Assert.assertTrue(isAlreadyIn);
		Mockito.verify(mockService).isAlreadyIn("user@gmail.com", event);
	}
	
	@Test
	public void testIsAlreadyInFalse() {
		// Arrange
		Mockito.when(mockService.isAlreadyIn("user@gmail.com", event)).thenReturn(false);
		
		// Act
		boolean isAlreadyIn = mockService.isAlreadyIn("user@gmail.com", event);

		// Assert
		Assert.assertFalse(isAlreadyIn);
		Mockito.verify(mockService).isAlreadyIn("user@gmail.com", event);
	}

	@Test
	public void testFindEventsByGamer() {
		// Arrange
		Mockito.when(mockService.findEventsByGamer(host)).thenReturn(events);
		
		// Act
		List<EventBean> actual = mockService.findEventsByGamer(host);

		// Assert
		Assert.assertEquals(events_available, actual);
		Mockito.verify(mockService).findEventsByGamer(host);
	}

}
