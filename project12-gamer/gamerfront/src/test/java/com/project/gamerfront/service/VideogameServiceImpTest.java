package com.project.gamerfront.service;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.gamerfront.beans.VideogameBean;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VideogameServiceImpTest {

	@Mock
	private VideogameService mockService;

	private List<VideogameBean> videogames = new ArrayList<VideogameBean>();

	private List<String> vg_dupp = new ArrayList<String>();

	@Test
	public void testGetAll() {
		// Arrange
		Mockito.when(mockService.getAll()).thenReturn(videogames);

		// Act
		List<VideogameBean> all = mockService.getAll();

		// Assert
		Assert.assertEquals(videogames, all);
		Mockito.verify(mockService).getAll();

	}

	@Test
	public void testGetGamesWithoutDupplicate() {
		// Arrange
		Mockito.when(mockService.getGamesWithoutDupplicate()).thenReturn(vg_dupp);

		// Act
		List<String> all_games = mockService.getGamesWithoutDupplicate();

		// Assert
		Assert.assertEquals(vg_dupp, all_games);
		Mockito.verify(mockService).getGamesWithoutDupplicate();
	}
}
