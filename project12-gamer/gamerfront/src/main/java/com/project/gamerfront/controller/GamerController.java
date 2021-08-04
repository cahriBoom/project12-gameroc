package com.project.gamerfront.controller;

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

import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.service.GamerService;

@Controller
public class GamerController {

	@Autowired
	private GamerService gamerService;

	
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
	
	@GetMapping(value="/welcome/{mail}")
	public String getWelcome(@PathVariable("mail") String mail, Model model) {
		GamerBean gamer = gamerService.getByMail(mail);
		model.addAttribute("gamer", gamer);
		return "/welcome";
	}

}
