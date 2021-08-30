package com.project.gamerfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.service.GamerService;

/**
 * Contrôleur Main
 */
@Controller
public class MainController {

	@Autowired
	private GamerService gamerService;
	
    /**
     * Mapping pour la page d'acceuil
     * 
     */
	@GetMapping(value = "/home")
	public String getHomePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String current = auth.getName();
		gamerService.calculateRankGamer();
		if(current!="anonymousUser") {
			GamerBean gamer = gamerService.getByMail(current);
			model.addAttribute("gamer", gamer);
		}
		model.addAttribute("current", current);
		return "/home";
	}

}
