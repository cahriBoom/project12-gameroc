package com.project.gamerback.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class VideogameTest {

	/*
	 * Test the constructors without parameters
	 * 
	 */
	@Test
	public void testConstructorWithParameters() {
		//Arrange
		String nom = "Skyrim";
		String plateform ="PC";	
		
		//Act
		Videogame videogame = new Videogame(nom, plateform);
			
		//Assert
		Assert.assertEquals(nom, videogame.getNom());
		Assert.assertEquals(plateform, videogame.getPlateform());
		
	}
	
	/*
	 * Test the constructors without parameters
	 * 
	 */
	@Test
	public void testConstructorWithoutParameters() {
		//Arrange
		Videogame videogame = new Videogame();
		List<Event> list_event = new ArrayList<>();
		
		//Act
		videogame.setNom("Minecraft");
		videogame.setPlateform("Xbox");
		videogame.setExclusive("none");
		videogame.setList_events(list_event);		
		
		//Assert
		Assert.assertEquals("Minecraft", videogame.getNom());
		Assert.assertEquals("Xbox", videogame.getPlateform());
		Assert.assertEquals("none", videogame.getExclusive());
		Assert.assertEquals(list_event, videogame.getList_events());
		
	}
	
	
}
