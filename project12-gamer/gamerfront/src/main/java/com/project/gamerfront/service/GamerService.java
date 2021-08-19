package com.project.gamerfront.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;

public interface GamerService extends UserDetailsService{

	String addGamer(GamerBean gamer);
	
	GamerBean getByMail(String mail);
	
	void updateGamer(GamerBean gamer, String mail);
	
	List<GamerBean> getGamerMet(List<EventBean> events, GamerBean gamer);
	
	void voteForGamer(String email, GamerBean gamer);
}
