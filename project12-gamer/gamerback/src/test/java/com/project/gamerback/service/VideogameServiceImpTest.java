package com.project.gamerback.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.gamerback.model.Videogame;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VideogameServiceImpTest {

	@Mock
	private VideogameService mockService;

	private List<Videogame> videogames = new ArrayList<Videogame>();
	
	private Videogame videogame = new Videogame("Minecraft", "PC");
	
	@Before
	public void setUp() {
		for (int i = 0; i < 3; i++) {
			Videogame vg = new Videogame();
			videogames.add(vg);
		}
	}
	
	@Test
	public void testGetAllGames(){
		// Arrange
		this.setUp();
		Mockito.when(mockService.getAllGames()).thenReturn(videogames);
		
		// Act
		List<Videogame> all_games = mockService.getAllGames();
		
		// Assert
		Assert.assertEquals(videogames.size(), all_games.size());
		Mockito.verify(mockService).getAllGames();
	}
	
	@Test
	public void testFindByNomAndPlateform() {
		// Arrange
		Mockito.when(mockService.findByNomAndPlateform("nom", "platform")).thenReturn(videogame);
		
		// Act
		Videogame actual = mockService.findByNomAndPlateform("nom", "platform");

		// Assert
		Assert.assertEquals(videogame, actual);
		Mockito.verify(mockService).findByNomAndPlateform("nom", "platform");
	}
	
	@Test
	public void testIsExclusiveTrue() {
		// Arrange
		Mockito.when(mockService.isExclusive(videogame)).thenReturn(true);
		
		// Act
		boolean isExclu = mockService.isExclusive(videogame);

		// Assert
		Assert.assertTrue(isExclu);
		Mockito.verify(mockService).isExclusive(videogame);

	}

	@Test
	public void testIsExclusiveFalse() {
		// Arrange
		Mockito.when(mockService.isExclusive(videogame)).thenReturn(false);
		
		// Act
		boolean isExclu = mockService.isExclusive(videogame);

		// Assert
		Assert.assertFalse(isExclu);
		Mockito.verify(mockService).isExclusive(videogame);
	}

	@Test
	public void testFixExclusivity() {
		// Arrange
		Mockito.doNothing().when(mockService).fixExclusivity();
		
		// Act
		mockService.fixExclusivity();
		
		// Assert
		Mockito.verify(mockService).fixExclusivity();
		
	}

}
