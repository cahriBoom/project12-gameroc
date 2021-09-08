package com.project.gamerback.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.gamerback.model.Gamer;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GamerServiceImpTest {

	@Mock
	private GamerService mockService;
	
	private Gamer gamer = new Gamer("test@gmail.com", "Testor", "testor", "PC", "Europe");
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testGetByMail(){
		// Arrange
		Mockito.when(mockService.getByMail("test@gmail.com")).thenReturn(Optional.of(gamer));
		
		// Act
		Gamer actual = mockService.getByMail("test@gmail.com").get();
		
		// Assert
		Assert.assertEquals(gamer, actual);
		Mockito.verify(mockService).getByMail("test@gmail.com");
		
	}
	
	@Test
	public void testGetById(){
		// Arrange
		Mockito.when(mockService.getById(0)).thenReturn(Optional.of(gamer));
		
		// Act
		Gamer actual = mockService.getById(0).get();
		
		// Assert
		Assert.assertEquals(gamer, actual);
		Mockito.verify(mockService).getById(0);
	}
	
	@Test
	public void testUpdateProfile() {
		// Arrange
		Mockito.doNothing().when(mockService).updateProfile(gamer);
		
		// Act
		mockService.updateProfile(gamer);
		
		// Assert
		Mockito.verify(mockService).updateProfile(gamer);
	}
	
	@Test
	public void testAddGamer() {
		// Arrange
		Mockito.doNothing().when(mockService).addGamer(gamer);
		
		// Act
		mockService.addGamer(gamer);
		
		// Assert
		Mockito.verify(mockService).addGamer(gamer);
	}
	
	@Test
	public void testCalculateRankGamer() {
		// Arrange
		Mockito.doNothing().when(mockService).calculateRankGamer(gamer);
		
		// Act
		mockService.calculateRankGamer(gamer);
		
		// Assert
		Mockito.verify(mockService).calculateRankGamer(gamer);
	}
	
}
