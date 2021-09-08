package com.project.gamerfront.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.beans.VideogameBean;

import junit.framework.Assert;

public class EventBeanTest {
	
	/*
	 * Test the constructors without parameters
	 * 
	 */
	@Test
	public void testConstructorWithParameters() {
		// Arrange
		Date debut = Calendar.getInstance().getTime();
		String description = "Let's do some PVP Folks";
		String title = "PVP Chill";
		int spots = 5;
		int player_needed = 5;
		VideogameBean videogame = new VideogameBean();
		String vgname = "Destiny 2";
		GamerBean host = new GamerBean();

		// Act
		EventBean event = new EventBean(debut, description, title, spots, player_needed, videogame, vgname, host);

		// Assert
		Assert.assertEquals(description, event.getDescription());
		Assert.assertEquals(title, event.getTitle());
		Assert.assertEquals(spots, event.getSpots());
		Assert.assertEquals(player_needed, event.getPlayer_needed());
		Assert.assertEquals(videogame.getId(), event.getVideogame().getId());
		Assert.assertEquals(vgname, event.getVgname());
		Assert.assertEquals(host.getId(), event.getHost().getId());

	}

	/*
	 * Test the constructors without parameters
	 * 
	 */
	@Test
	public void testConstructorWithoutParameters() {
		// Arrange
		EventBean event = new EventBean();
		GamerBean gamer = new GamerBean();
		VideogameBean videogame = new VideogameBean();
		List<GamerBean> participants = new ArrayList<>();

		// Act
		event.setDescription("Let's do some PVP, Come with us");
		event.setHost(gamer);
		event.setMaximum_player(6);
		event.setPlateform("PC");
		event.setPlayer_needed(5);
		event.setSpots(5);
		event.setTitle("PVP");
		event.setVgname("Destiny 2");
		event.setVideogame(videogame);
		event.setParticipants(participants);

		// Assert
		Assert.assertEquals("Let's do some PVP, Come with us", event.getDescription());
		Assert.assertEquals(gamer.getId(), event.getHost().getId());
		Assert.assertEquals(6, event.getMaximum_player());
		Assert.assertEquals("PC", event.getPlateform());
		Assert.assertEquals(5, event.getPlayer_needed());
		Assert.assertEquals(5, event.getSpots());
		Assert.assertEquals("PVP", event.getTitle());
		Assert.assertEquals("Destiny 2", event.getVgname());
		Assert.assertEquals(videogame.getId(), event.getVideogame().getId());
		Assert.assertEquals(participants, event.getParticipants());

	}
}
