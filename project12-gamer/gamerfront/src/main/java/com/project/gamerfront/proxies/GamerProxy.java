package com.project.gamerfront.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.beans.VideogameBean;

@FeignClient(name = "gamerback", url = "localhost:8080/Gamer")
public interface GamerProxy {

	// Proxy Event
	@GetMapping(value = "/events")
	List<EventBean> getAllEvents();

	@PostMapping(value = "/post_event")
	void addNewEvent(@RequestBody EventBean event);

	@GetMapping(value = "/event/{id}")
	EventBean getEventById(@PathVariable("id") int id);

	// Proxy Gamer
	@GetMapping(value = "/welcome/{mail}")
	GamerBean getGamerByMail(@PathVariable("mail") String mail);

	@PostMapping(value = "/subscribe")
	String addGamerSubscribe(@RequestBody GamerBean gamer);

	@PostMapping(value = "/edit_profile")
	void updateProfileGamer(@RequestBody GamerBean gamer);

	// Proxy Videogame
	@GetMapping(value = "/games")
	List<VideogameBean> getAllVideogames();
}
