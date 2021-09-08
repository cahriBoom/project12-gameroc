package com.project.gamerback.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class GamerTest {

	/*
	 * Test the constructors without parameters
	 * 
	 */
	@Test
	public void testConstructorWithParameters() {
		// Arrange
		String email = "testor@gmail.com";
		String gamertag = "Testor";
		String password = "testor";
		String plateform = "Playstation";
		String server = "Europe";

		// Act
		Gamer gamer = new Gamer(email, gamertag, password, plateform, server);

		// Assert
		Assert.assertEquals(email, gamer.getEmail());
		Assert.assertEquals(gamertag, gamer.getGamertag());
		Assert.assertEquals(password, gamer.getPassword());
		Assert.assertEquals(plateform, gamer.getPlateform());
		Assert.assertEquals(server, gamer.getServer());

	}

	/*
	 * Test the constructors without parameters
	 * 
	 */
	@Test
	public void testConstructorWithoutParameters() {
		// Arrange
		Gamer gamer = new Gamer();
		List<Gamer> votedFor = new ArrayList<>();
		
		// Act
		gamer.setEmail("testor@gmail.com");
		gamer.setGamertag("Testor");
		gamer.setGood_rating(0);
		gamer.setBad_rating(0);
		gamer.setNote("NEW");
		gamer.setPassword("testor");
		gamer.setPlateform("Playstation");
		gamer.setServer("America");
		gamer.setVotedFor(votedFor);

		// Assert
		Assert.assertEquals("testor@gmail.com", gamer.getEmail());
		Assert.assertEquals("Testor", gamer.getGamertag());
		Assert.assertEquals(0, gamer.getGood_rating());
		Assert.assertEquals(0, gamer.getBad_rating());
		Assert.assertEquals("NEW", gamer.getNote());
		Assert.assertEquals("Playstation", gamer.getPlateform());
		Assert.assertEquals("testor", gamer.getPassword());
		Assert.assertEquals("America", gamer.getServer());
		Assert.assertEquals(votedFor, gamer.getVotedFor());
	}
}
