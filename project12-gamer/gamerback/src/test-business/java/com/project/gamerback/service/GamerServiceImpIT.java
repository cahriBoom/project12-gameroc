package com.project.gamerback.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.gamerback.model.Gamer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamerServiceImpIT {

	@Autowired
	private GamerService gamerService;

	@Test
	public void getAll() {
		// Arrange
		List<Gamer> all = gamerService.getAll();

		// Act
		int size = all.size();

		// Assert
		Assert.assertNotNull(size);
	}
	
	@Test
	public void testGetById() {
		// Arrange
		String name_expected = "Magmablood";

		// Act
		Gamer gamer = gamerService.getById(1).get();
		String name_actual = gamer.getGamertag();

		// Assert
		Assert.assertEquals(name_expected, name_actual);
	}

	@Test
	public void testGetByMail() {
		// Arrange
		String name_expected = "Magmablood";

		// Act
		Gamer gamer = gamerService.getByMail("magma21@gmail.com").get();
		String name_actual = gamer.getGamertag();

		// Assert
		Assert.assertEquals(name_expected, name_actual);
	}

	@Test
	public void testUpdateProfile() {
		// Arrange
		Gamer gamer = gamerService.getById(1).get();
		String expected = "Xbox";
		gamer.setPlateform(expected);
		
		// Act
		gamerService.updateProfile(gamer);
		String actual = gamer.getPlateform();

		// Assert
		Assert.assertEquals(expected, actual);
		
		// Reset any changements
		gamer.setPlateform("PC");
		gamerService.updateProfile(gamer);
		
	}

	@Test
	public void testAddGamer() {
		// Arrange
		Gamer gamer = new Gamer("test@gmail.com", "Testor", "testor", "PC", "Europe");
		String expected = gamer.getEmail();		
		
		// Act	
		gamerService.addGamer(gamer);
		Gamer g = gamerService.getByMail("test@gmail.com").get();
		String actual = g.getEmail();

		// Assert
		Assert.assertEquals(expected, actual);
		gamerService.deleteGamer(g);
		
	}

	@Test
	public void testCalculateRankGamer() {
		// Arrange
		Gamer gamer = new Gamer("test@gmail.com", "Testor", "testor", "PC", "Europe");
		gamer.setGood_rating(7);
		gamer.setBad_rating(0);
		String expected_rank = "VETERAN";
				
		// Act
		gamerService.addGamer(gamer);
		gamerService.calculateRankGamer(gamer);
		Gamer g = gamerService.getByMail("test@gmail.com").get();
		String actual_rank = g.getNote();

		// Assert
		Assert.assertEquals(expected_rank, actual_rank);
		gamerService.deleteGamer(g);
	}
}
