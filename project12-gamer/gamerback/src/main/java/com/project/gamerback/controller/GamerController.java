package com.project.gamerback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamerback.model.Gamer;
import com.project.gamerback.service.GamerService;

@RestController
public class GamerController {

	@Autowired
	private GamerService gamerService;

	@GetMapping(value = "/welcome/{mail}")
	public Gamer getGamerByMail(@PathVariable("mail") String mail) {
		return gamerService.getByMail(mail).get();
	}
	
	@PostMapping(value="/welcome/{mail}")
	public void postVoteForGamer(@PathVariable("mail") String mail, @RequestBody Gamer gamer) {
		
		
		
	}

	@PostMapping(value = "/subscribe")
	public String addClientSubscribe(@RequestBody Gamer gamer) {
		String mail = gamer.getEmail();
		if (gamerService.getByMail(mail).isEmpty()) {
			gamerService.addGamer(gamer);
			return "OK";
		}
		return "NOK";
	}
	
	@PostMapping(value="/edit_profile")
	public void updateProfileGamer(@RequestBody Gamer gamer) {
		gamerService.updateProfile(gamer);
		
	}
}