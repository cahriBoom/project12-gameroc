package com.project.gamerfront.bean;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.project.gamerfront.beans.GamerBean;

import org.junit.Assert;

public class GamerBeanTest {

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
		GamerBean gamer = new GamerBean(email, gamertag, plateform, server, password);

		// Assert
		Assert.assertEquals(email, gamer.getEmail());
		Assert.assertEquals(gamertag, gamer.getGamertag());
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
		GamerBean gamer = new GamerBean();
		List<GamerBean> votedFor = new ArrayList<>();
		
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
