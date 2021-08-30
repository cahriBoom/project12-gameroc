package com.project.gamerfront.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.service.EventService;
import com.project.gamerfront.service.GamerService;

/**
 * Contrôleur des objets du packages Gamer
 */
@Controller
public class GamerController {

	@Autowired
	private GamerService gamerService;

	@Autowired
	private EventService eventService;

    /**
     * Mapping pour la page de login
     * 
     */
	@GetMapping(value = "/login")
	public ModelAndView getLogin(Model model) {
		model.addAttribute("gamer", new GamerBean());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("/login");
	}

	/**
     * Mapping pour le formulaire de connexion
     * 
     */
	@PostMapping(value = "/login")
	public ModelAndView postLogin(Model model) {
		return new ModelAndView("redirect:/home");
	}

	/**
     * Mapping pour la page de logout
     * 
     */
	@GetMapping(value = "/logout")
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}

	/**
     * Mapping pour la page d'inscription
     * 
     * @param gamer: Gamer concerné
     */
	@GetMapping(value = "/subscribe")
	public String getSubscribe(@ModelAttribute("gamer") GamerBean gamer) {
		return "/subscribe";
	}

	/**
     * Mapping pour le formulaire d'inscription
     * 
     * @param gamer: Gamer concerné
     */
	@PostMapping(value = "/subscribe")
	public String postSubscribe(Model model, @ModelAttribute("gamer") GamerBean gamer) {
		String message = gamerService.addGamer(gamer);
		if (message.equals("NOK")) {
			String msg = "User Already Taken";
			model.addAttribute("msg", msg);
			return "/subscribe";
		} else {
			return "/home";
		}
	}

	/**
     * Mapping pour la page personel de l'utilisateur connecté
     * 
     * @param mail: mail de l'utilisateur connecté
     */
	@GetMapping(value = "/welcome/{mail}")
	public String getWelcome(@PathVariable("mail") String mail, Model model) {
		GamerBean gamer = gamerService.getByMail(mail);
		List<EventBean> events = eventService.findEventsByGamer(gamer);
		List<GamerBean> gamersMetRecently = gamerService.getGamerMet(events, gamer);
		model.addAttribute("recent_gamers", gamersMetRecently);
		model.addAttribute("gamer", gamer);
		model.addAttribute("voted", new GamerBean());
		return "/welcome";
	}
	
	/**
     * Mapping pour le formulaire lorsque l'utilisateur vote positif.
     * 
     * @param mail: mail de l'utilisateur qui vote
     * @param gamer: Gamer pour qui l'on vote
     */
	@PostMapping(value = "/welcome/{mail}", params = "good_rating")
	public String postWelcomeVoteForGoodRate(@PathVariable("mail") String mail, @ModelAttribute("voted") GamerBean gamer, Model model) {
		int id_voted = gamer.getId();
		GamerBean voter = gamerService.getByMail(mail);
		GamerBean voted = gamerService.getById(id_voted);
		gamerService.voteGoodForGamer(voter, voted);
		List<EventBean> events = eventService.findEventsByGamer(voter);
		List<GamerBean> gamersMetRecently = gamerService.getGamerMet(events, voter);
		model.addAttribute("recent_gamers", gamersMetRecently);
		model.addAttribute("gamer", voter);
		return "/welcome";
	}

	/**
     * Mapping pour le formulaire lorsque l'utilisateur vote négatif.
     * 
     * @param mail: mail de l'utilisateur qui vote
     * @param gamer: Gamer pour qui l'on vote
     */
	@PostMapping(value = "/welcome/{mail}", params = "bad_rating")
	public String postWelcomeVoteForBadRate(@PathVariable("mail") String mail, @ModelAttribute("voted") GamerBean gamer, Model model) {
		int id_voted = gamer.getId();
		GamerBean voter = gamerService.getByMail(mail);
		GamerBean voted = gamerService.getById(id_voted);
		gamerService.voteBadForGamer(voter, voted);
		List<EventBean> events = eventService.findEventsByGamer(voter);
		List<GamerBean> gamersMetRecently = gamerService.getGamerMet(events, voter);
		model.addAttribute("recent_gamers", gamersMetRecently);
		model.addAttribute("gamer", voter);
		return "/welcome";
	}

	/**
     * Mapping pour la page d'edition de profil utilisateur
     * 
     */
	@GetMapping(value = "/edit_profile")
	public String getEditProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		GamerBean gamer = gamerService.getByMail(mail);
		model.addAttribute("gamer", gamer);
		return "/edit_profile";
	}

	/**
     * Mapping pour le formulaire de modification du profil utilisateur
     * 
     */
	@PostMapping(value = "/edit_profile")
	public String postEditProfile(Model model, @ModelAttribute("gamer") GamerBean gamer) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		gamerService.updateGamer(gamer, mail);
		model.addAttribute("gamer", gamer);
		return "/edit_profile";
	}

}
