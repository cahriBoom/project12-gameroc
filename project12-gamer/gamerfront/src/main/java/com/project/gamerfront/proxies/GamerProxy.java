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

/**
 * Interface du Proxy d'accès à la couche DAO
 */
@FeignClient(name = "gamerback", url = "localhost:8080/Gamer")
public interface GamerProxy {

	// ==================== Proxy Main ====================
	/**
	 * Permet l'initialisation de plusieurs variables et données
	 *
	 */
	@GetMapping(value = "/home")
	void initiateStatus();

	// ==================== Proxy Event ====================
	/**
	 * Renvoie la liste de tout les events
	 *
	 * @return {@link List}
	 */
	@GetMapping(value = "/events")
	List<EventBean> getAllEvents();

	/**
	 * Ajoute un nouvel event
	 *
	 * @param event: Event concerné
	 */
	@PostMapping(value = "/post_event")
	void addNewEvent(@RequestBody EventBean event);

	/**
	 * Supprime un event
	 *
	 * @param event: Event concerné
	 */
	@PostMapping(value = "/delete_event/{id}")
	void deleteEvent(@PathVariable("id") int id);

	/**
	 * Renvoie un Event suivant son numero
	 *
	 * @param id: numero de l'Event concerné
	 * @return {@link EventBean}
	 */
	@GetMapping(value = "/event/{id}")
	EventBean getEventById(@PathVariable("id") int id);

	/**
	 * Modifie un groupe d'un event
	 *
	 * @param id:    numero du Gamer a modifier
	 * @param gamer: modification faites pour le Gamer concerné
	 */
	@PostMapping(value = "/event/{id}")
	void postUpdateGroup(@PathVariable("id") int id, @RequestBody GamerBean gamer);

	/**
	 * Renvoie la liste des Events pour un jeux donné
	 *
	 * @param videogame: jeux donné
	 * @return {@link List}
	 */
	@PostMapping(value = "/search_event")
	List<EventBean> getEventByGame(@RequestBody VideogameBean videogame);

	// ==================== Proxy Gamer ====================
	/**
	 * Renvoie un Gamer suivant son mail
	 *
	 * @param mail: mail du Gamer concerné
	 * @return {@link GamerBean}
	 */
	@GetMapping(value = "/welcome/{mail}")
	GamerBean getGamerByMail(@PathVariable("mail") String mail);

	/**
	 * Renvoie un Gamer suivant son id
	 *
	 * @param id: id du Gamer concerné
	 * @return {@link GamerBean}
	 */
	@GetMapping(value = "/welcome_id/{id}")
	GamerBean getGamerById(@PathVariable("id") int id);

	/**
	 * Permet de vote pour un joueur
	 *
	 * @param mail:  mail du joueur qui vote
	 * @param gamer: Gamer pour qui l'on vote
	 */
	@PostMapping(value = "/welcome/{mail}")
	void postVoteForGamer(@PathVariable("mail") String mail, @RequestBody GamerBean gamer);

	/**
	 * Permet de retirer un bon vote pour un joueur
	 *
	 * @param mail:  mail du joueur qui vote
	 * @param gamer: Gamer pour qui l'on vote
	 */
	@PostMapping(value = "/unvote/good/{mail}")
	void unvoteGoodGamer(@PathVariable("mail") String mail, @RequestBody GamerBean gamer);
	
	/**
	 * Permet de retirer un mauvais vote pour un joueur
	 *
	 * @param mail:  mail du joueur qui vote
	 * @param gamer: Gamer pour qui l'on vote
	 */
	@PostMapping(value = "/unvote/bad/{mail}")
	void unvoteBadGamer(@PathVariable("mail") String mail, @RequestBody GamerBean gamer);
	
	/**
	 * Renvoie un mot de validation si l'inscription c'est faite sans problème
	 *
	 * @param gamer: Nouvel utilisateur enregistré
	 * @return {@link String}
	 */
	@PostMapping(value = "/subscribe")
	String addGamerSubscribe(@RequestBody GamerBean gamer);
	
	/**
	 * Supprime un gamer
	 *
	 * @param gamer: Gamer concerné
	 */
	@PostMapping(value = "/delete_gamer")
	void deleteGamer(@RequestBody GamerBean gamer);

	/**
	 * Update le profil du joueur gamer
	 *
	 * @param gamer: Gamer concerné
	 */
	@PostMapping(value = "/edit_profile")
	void updateProfileGamer(@RequestBody GamerBean gamer);

	// ==================== Proxy Videogame ====================
	/**
	 * Renvoie la liste de tous les jeux
	 *
	 * @return {@link List}
	 */
	@GetMapping(value = "/games")
	List<VideogameBean> getAllVideogames();

	/**
	 * Renvoie un jeu video suivant son numero
	 *
	 * @param id: numero du jeu video
	 * @return {@link VideogameBean}
	 */
	@GetMapping(value = "/games/{id}")
	VideogameBean getVideogameById(@PathVariable("id") int id);

}
