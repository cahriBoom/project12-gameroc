package com.project.gamerfront.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GamerServiceImpTest {

	@Mock
	private GamerService mockService;

	private GamerBean gamer = new GamerBean();

	private GamerBean gamer_voted = new GamerBean();

	private List<GamerBean> gamers = new ArrayList<GamerBean>();

	private List<EventBean> events = new ArrayList<EventBean>();

	@Test
	public void testGetByMail() {
		// Arrange
		Mockito.when(mockService.getByMail("testor@gmail.com")).thenReturn(gamer);

		// Act
		GamerBean actual = mockService.getByMail("testor@gmail.com");

		// Assert
		Assert.assertEquals(gamer, actual);
		Mockito.verify(mockService).getByMail("testor@gmail.com");
	}

	@Test
	public void testGetById() {
		// Arrange
		Mockito.when(mockService.getById(1)).thenReturn(gamer);

		// Act
		GamerBean actual = mockService.getById(1);

		// Assert
		Assert.assertEquals(gamer, actual);
		Mockito.verify(mockService).getById(1);

	}

	@Test
	public void testAddGamerOk() {
		// Arrange
		Mockito.when(mockService.addGamer(gamer)).thenReturn("OK");

		// Act
		String response = mockService.addGamer(gamer);

		// Assert
		Assert.assertEquals("OK", response);
		Mockito.verify(mockService).addGamer(gamer);
	}

	@Test
	public void testAddGamerNOK() {
		// Arrange
		Mockito.when(mockService.addGamer(gamer)).thenReturn("NOK");

		// Act
		String response = mockService.addGamer(gamer);

		// Assert
		Assert.assertEquals("NOK", response);
		Mockito.verify(mockService).addGamer(gamer);
	}

	@Test
	public void testUpdateGamer() {
		// Arrange
		Mockito.doNothing().when(mockService).updateGamer(gamer, "testor@gmail.com");

		// Act
		mockService.updateGamer(gamer, "testor@gmail.com");

		// Assert
		Mockito.verify(mockService).updateGamer(gamer, "testor@gmail.com");

	}

	@Test
	public void testGetGamerMet() {
		// Arrange
		Mockito.when(mockService.getGamerMet(events, gamer)).thenReturn(gamers);

		// Act
		List<GamerBean> actual = mockService.getGamerMet(events, gamer);

		// Assert
		Assert.assertEquals(gamers, actual);
		Mockito.verify(mockService).getGamerMet(events, gamer);
	}

	@Test
	public void testAsAlreadyVotedForTrue() {
		// Arrange
		Mockito.when(mockService.asAlreadyVotedFor(gamer, gamer_voted)).thenReturn(true);

		// Act
		boolean asAlreadyVotedFor = mockService.asAlreadyVotedFor(gamer, gamer_voted);

		// Assert
		Assert.assertTrue(asAlreadyVotedFor);
		Mockito.verify(mockService).asAlreadyVotedFor(gamer, gamer_voted);
	}

	@Test
	public void testAsAlreadyVotedForFalse() {
		// Arrange
		Mockito.when(mockService.asAlreadyVotedFor(gamer, gamer_voted)).thenReturn(false);

		// Act
		boolean asAlreadyVotedFor = mockService.asAlreadyVotedFor(gamer, gamer_voted);

		// Assert
		Assert.assertFalse(asAlreadyVotedFor);
		Mockito.verify(mockService).asAlreadyVotedFor(gamer, gamer_voted);
	}

	@Test
	public void testVoteGoodForGamer() {
		// Arrange
		Mockito.doNothing().when(mockService).voteGoodForGamer(gamer, gamer_voted);

		// Act
		mockService.voteGoodForGamer(gamer, gamer_voted);

		// Assert
		Mockito.verify(mockService).voteGoodForGamer(gamer, gamer_voted);

	}

	@Test
	public void testVoteBadForGamer() {
		// Arrange
		Mockito.doNothing().when(mockService).voteBadForGamer(gamer, gamer_voted);

		// Act
		mockService.voteBadForGamer(gamer, gamer_voted);

		// Assert
		Mockito.verify(mockService).voteBadForGamer(gamer, gamer_voted);
	}

	@Test
	public void testCalculateRankGamer() {
		// Arrange
		Mockito.doNothing().when(mockService).calculateRankGamer();

		// Act
		mockService.calculateRankGamer();

		// Assert
		Mockito.verify(mockService).calculateRankGamer();
	}
}
