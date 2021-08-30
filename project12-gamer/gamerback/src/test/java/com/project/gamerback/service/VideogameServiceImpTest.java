package com.project.gamerback.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.gamerback.model.Videogame;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideogameServiceImpTest {

	Videogame videogame = new Videogame("", "");

	@Autowired
	private VideogameService videogameService;

	@Test
	public void testIsExclusiveTrue() {
		// Arrange
		videogame.setExclusive("Xbox");

		// Act
		boolean isExclusive = videogameService.isExclusive(videogame);

		// Assert
		Assert.assertEquals(true, isExclusive);

	}

	@Test
	public void testIsExclusiveFalse() {
		// Arrange
		videogame.setExclusive("none");

		// Act
		boolean isExclusive = videogameService.isExclusive(videogame);

		// Assert
		Assert.assertEquals(false, isExclusive);
	}

}
