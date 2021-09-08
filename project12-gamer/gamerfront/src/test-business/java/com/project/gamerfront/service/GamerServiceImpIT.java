package com.project.gamerfront.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamerServiceImpIT {

	@Autowired
	private GamerService gamerService;

	@Autowired
	private EventService eventService;
	
	@Test
	public void testGetByMail() {
		// Arrange
		String mail = "weiss@gmail.com";
		
		// Act
		GamerBean gamer = gamerService.getByMail(mail);
		
		// Assert
		Assert.assertNotNull(gamer);
		
	}

	@Test
	public void testGetById() {
		// Arrange
		int id = 12;
		
		// Act
		GamerBean gamer = gamerService.getById(id);

		// Assert
		Assert.assertNotNull(gamer);
		
	}

	@Test
	public void testAddGamer() {
		// Arrange
		GamerBean new_gamer = new GamerBean("test@gmail.com", "Testor", "testor", "PC", "Europe");
		String expected = "OK";
		
		// Act
		String actual = gamerService.addGamer(new_gamer);

		// Assert
		Assert.assertEquals(expected, actual);
		gamerService.deleteGamer(new_gamer);
	}

	@Test
	public void testUpdateGamer() {
		// Arrange
		GamerBean gamer = gamerService.getById(1);
		String expected = "Magma";
		gamer.setGamertag(expected);
		
		
		// Act
		gamerService.updateGamer(gamer, gamer.getEmail());
		gamer = gamerService.getById(1);
		String actual = gamer.getGamertag();

		// Assert
		Assert.assertEquals(expected, actual);
		gamer.setGamertag("Magmablood");
		gamerService.updateGamer(gamer, gamer.getEmail());
	}

	@Test
	public void testGetGamerMet() {
		// Arrange
		List<EventBean> events = eventService.getAllEvents();
		GamerBean gamer = gamerService.getById(12);
		
		// Act
		List<GamerBean> gamer_met = gamerService.getGamerMet(events, gamer);

		// Assert
		Assert.assertNotNull(gamer_met);
	}

	@Test
	public void testAsAlreadyVotedForTrue() {
		// Arrange
		GamerBean voter = gamerService.getById(12);
		GamerBean voted = gamerService.getById(3);
		
		// Act
		boolean asAlreadyVoted = gamerService.asAlreadyVotedFor(voter, voted);

		// Assert
		Assert.assertTrue(asAlreadyVoted);
	}
	
	@Test
	public void testAsAlreadyVotedForFalse() {
		// Arrange
		GamerBean voter = gamerService.getById(12);
		GamerBean voted = gamerService.getById(13);
		
		// Act
		boolean asAlreadyVoted = gamerService.asAlreadyVotedFor(voter, voted);

		// Assert
		Assert.assertFalse(asAlreadyVoted);
	}

	@Test
	public void testVoteGoodForGamer() {
		// Arrange
		GamerBean voter = gamerService.getById(12);
		GamerBean voted = gamerService.getById(13);
		
		// Act
		gamerService.voteGoodForGamer(voter, voted);
		boolean after = gamerService.asAlreadyVotedFor(voter, voted);
		
		// Assert
		Assert.assertTrue(after);
		gamerService.unvoteGoodGamer(voter, voted);
		
	}

	@Test
	public void testVoteBadForGamer() {
		// Arrange
		GamerBean voter = gamerService.getById(12);
		GamerBean voted = gamerService.getById(13);
		
		// Act
		gamerService.voteBadForGamer(voter, voted);
		boolean after = gamerService.asAlreadyVotedFor(voter, voted);
		
		// Assert
		Assert.assertTrue(after);
		gamerService.unvoteBadGamer(voter, voted);
	}

	@Test
	public void testCalculateRankGamer() {
		// Arrange
		GamerBean gamer = gamerService.getById(12);		
		String expected = "GOOD";
		
		// Act
		gamerService.calculateRankGamer();
		gamer = gamerService.getById(12);
		String actual = gamer.getNote();

		// Assert
		Assert.assertEquals(expected, actual);
	}
}
