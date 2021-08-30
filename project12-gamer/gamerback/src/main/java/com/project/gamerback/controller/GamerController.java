package com.project.gamerback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.gamerback.model.Gamer;
import com.project.gamerback.service.GamerService;


/**
 * Contrôleur des objets du packages Gamer
 */
@RestController
public class GamerController {

	@Autowired
	private GamerService gamerService;

    /**
     * Initialise différents paramètres à l'arrivé sur l'application
     * 
     */
	@GetMapping(value = "/home")
	public void initiateStatus() {
		gamerService.calculateRankGamer();
	}
	
    /**
     * Renvoie un Gamer suivant son mail
     * 
     * @param mail : mail pour le gamer concerné
     * @return {@link Gamer}
     */
	@GetMapping(value = "/welcome/{mail}")
	public Gamer getGamerByMail(@PathVariable("mail") String mail) {
		return gamerService.getByMail(mail).get();
	}
	
    /**
     * Renvoie un Gamer suivant son numero
     * 
     * @param id : identifiant pour le gamer concerné
     * @return {@link Gamer}
     */
	@GetMapping(value="/welcome_id/{id}")
	public Gamer getGamerById(@PathVariable("id") int id) {
		return gamerService.getById(id).get();
	}
	
    /**
     * Méthode utilisée pour le vote d'un gamer
     * 
     * @param mail : mail pour le gamer votant
     * @param gamer : gamer voté
     */
	@PostMapping(value="/welcome/{mail}")
	public void postVoteForGamer(@PathVariable("mail") String mail, @RequestBody Gamer gamer) {
		gamerService.updateProfile(gamer);		
	}

    /**
     * Ajoute un nouveau gamer a la base de données
     * 
     * @param gamer : nouveau gamer enregistré dans la base
     * @return {@link String}
     */
	@PostMapping(value = "/subscribe")
	public String addClientSubscribe(@RequestBody Gamer gamer) {
		String mail = gamer.getEmail();
		if (gamerService.getByMail(mail).isEmpty()) {
			gamerService.addGamer(gamer);
			return "OK";
		}
		return "NOK";
	}
	
    /**
     * Méthode permettant à l'utilisateur de modifier son profil
     * 
     * @param gamer : gamer avec mofidications effectuée
     */
	@PostMapping(value="/edit_profile")
	public void updateProfileGamer(@RequestBody Gamer gamer) {
		gamerService.updateProfile(gamer);
		
	}
}
