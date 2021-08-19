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

@Controller
public class GamerController {

	@Autowired
	private GamerService gamerService;

	@Autowired
	private EventService eventService;

	@GetMapping(value = "/login")
	public ModelAndView getLogin(Model model) {
		model.addAttribute("gamer", new GamerBean());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return new ModelAndView("redirect:/");
		}
		return new ModelAndView("/login");
	}

	@PostMapping(value = "/login")
	public ModelAndView postLogin(Model model) {
		return new ModelAndView("redirect:/home");
	}

	@GetMapping(value = "/logout")
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}

	@GetMapping(value = "/subscribe")
	public String getSubscribe(@ModelAttribute("gamer") GamerBean gamer) {
		return "/subscribe";
	}

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

	// PERMETTRE AU JOUEUR UN FOIS CONNECTER DE NOTER LES JOUEURS APPARAISSANT SUR
	// LA LISTE
	// UN GAMER NE PEUX VOTER QU'UNE SEULE FOIS POUR UN AUTRE GAMER
	// UNE FOIS VOTE L'OPTION DE VOTE EST RETIRER POUR CE GAMER EN QUESTION.
	// AJOUTER A LA LISTE VOTEDFOR LA LISTE DE JOUEUR DONT LEQUEL LE GAMER A DEJA
	// VOTE
	// UNE FOIS LE VOTE EFFECTUER LE JOUEUR EST RETIRER DE LA LISTE DES JOUEURS RENCONTRER

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

	@PostMapping(value = "/welcome/{mail}", params = "good_rating")
	public String postWelcomeVoteForGoodRate(@PathVariable("mail") String mail, @ModelAttribute("voted") GamerBean voted, Model model) {
		GamerBean user = gamerService.getByMail(mail);
		
		
		return "/welcome";
	}

	@PostMapping(value = "/welcome/{mail}", params = "bad_rating")
	public String postWelcomeVoteForBadRate(@PathVariable("mail") String mail, @ModelAttribute("voted") GamerBean voted, Model model) {
		GamerBean user = gamerService.getByMail(mail);
		
		return "/welcome";
	}

	@GetMapping(value = "/edit_profile")
	public String getEditProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		GamerBean gamer = gamerService.getByMail(mail);
		model.addAttribute("gamer", gamer);
		return "/edit_profile";
	}

	@PostMapping(value = "/edit_profile")
	public String postEditProfile(Model model, @ModelAttribute("gamer") GamerBean gamer) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		gamerService.updateGamer(gamer, mail);
		model.addAttribute("gamer", gamer);
		return "/edit_profile";
	}

}
