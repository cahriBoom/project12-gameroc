package com.project.gamerfront.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.gamerfront.beans.VideogameBean;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VideogameServiceImpIT {

	@Autowired
	private VideogameService videogameService;
	
	@Test
	public void testGetAll(){
		// Arrange
		List<VideogameBean> all = videogameService.getAll();
		
		// Act
		int size = all.size();
		
		// Assert
		Assert.assertNotNull(size);

	}
	
	@Test
	public void testGetById() {
		// Arrange
		int id = 1;
		
		// Act
		VideogameBean videogame = videogameService.getById(id);
		
		// Assert
		Assert.assertNotNull(videogame);
	}
	
	@Test
	public void testGetGamesWithoutDupplicate(){
		// Arrange
		List<String> vid = videogameService.getGamesWithoutDupplicate();
		
		// Act
		int size = vid.size();
		
		// Assert
		Assert.assertNotNull(size);
	}
}
