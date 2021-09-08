package com.project.gamerback.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<Gamer> all = gamerService.getAll();
		for(Gamer gamer:all) {
			gamerService.calculateRankGamer(gamer);
		}
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
	 * Permet de retirer un bon vote pour un joueur
	 *
	 * @param mail:  mail du joueur qui vote
	 * @param gamer: Gamer pour qui l'on vote
	 */
	@PostMapping(value = "/unvote/good/{mail}")
	public void unvoteGoodGamer(@PathVariable("mail") String mail, @RequestBody Gamer gamer) {
		Gamer voter = gamerService.getByMail(mail).get();
		Gamer voted = gamerService.getByMail(gamer.getEmail()).get();
		List<Gamer> votedFor = voter.getVotedFor();
		List<Gamer> gamers = new ArrayList<Gamer>();
		int good = voted.getGood_rating();
		for(Gamer g:votedFor) {
			String gmail = g.getEmail();
			if(!gmail.equals(gamer.getEmail())) {
				gamers.add(g);
			}
		}
		voted.setGood_rating(good-1);
		voter.setVotedFor(gamers);
		gamerService.updateProfile(voter);
	}
	
	/**
	 * Permet de retirer un mauvais vote pour un joueur
	 *
	 * @param mail:  mail du joueur qui vote
	 * @param gamer: Gamer pour qui l'on vote
	 */
	@PostMapping(value = "/unvote/bad/{mail}")
	public void unvoteBadGamer(@PathVariable("mail") String mail, @RequestBody Gamer gamer) {
		Gamer voter = gamerService.getByMail(mail).get();
		Gamer voted = gamerService.getByMail(gamer.getEmail()).get();
		List<Gamer> votedFor = voter.getVotedFor();
		List<Gamer> gamers = new ArrayList<Gamer>();
		int bad = voted.getBad_rating();
		for(Gamer g:votedFor) {
			String gmail = g.getEmail();
			if(!gmail.equals(gamer.getEmail())) {
				gamers.add(g);
			}
		}
		voted.setBad_rating(bad-1);
		voter.setVotedFor(gamers);
		gamerService.updateProfile(voter);
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
	 * Supprime un gamer
	 *
	 * @param gamer: Gamer concerné
	 */
	@PostMapping(value = "/delete_gamer")
	public void deleteGamer(@RequestBody Gamer gamer) {
		Gamer g = gamerService.getByMail(gamer.getEmail()).get();
		gamerService.deleteGamer(g);
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
