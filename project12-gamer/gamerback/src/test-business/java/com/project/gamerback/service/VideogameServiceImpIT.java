package com.project.gamerback.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.gamerback.model.Videogame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideogameServiceImpIT {

	@Autowired
	private VideogameService videogameService;

	@Test
	public void GetAllGames() {
		// Arrange
		List<Videogame> all = videogameService.getAllGames();

		// Act
		videogameService.fixExclusivity();

		// Assert
		Assert.assertNotNull(all);

	}

	@Test
	public void testGetById() {
		// Arrange
		String expected = "Overwatch";
		
		// Act
		Videogame game = videogameService.getById(2);
		String actual = game.getNom();

		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFindByNomAndPlateform() {
		// Arrange
		int expected = 2;
		
		// Act
		Videogame videogame = videogameService.findByNomAndPlateform("Overwatch", "PC");
		int actual = videogame.getId();
		
		// Assert
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIsExclusiveTrue() {
		// Arrange
		Videogame videogame = videogameService.getById(14);
		
		// Act
		boolean isExclu = videogameService.isExclusive(videogame);
		
		// Assert
		Assert.assertTrue(isExclu);
	}

	@Test
	public void testIsExclusiveFalse() {
		// Arrange
		Videogame videogame = videogameService.getById(2);
		
		// Act
		boolean isExclu = videogameService.isExclusive(videogame);
		
		// Assert
		Assert.assertFalse(isExclu);
	}
	
}
