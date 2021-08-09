package com.project.gamerfront.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.gamerfront.beans.GamerBean;

public interface GamerService extends UserDetailsService{

	String addGamer(GamerBean gamer);
	
	GamerBean getByMail(String mail);
	
	void updateGamer(GamerBean gamer, String mail);
}
