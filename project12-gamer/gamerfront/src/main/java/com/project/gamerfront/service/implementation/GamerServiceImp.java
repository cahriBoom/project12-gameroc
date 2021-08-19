package com.project.gamerfront.service.implementation;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.config.BCryptManagerUtil;
import com.project.gamerfront.proxies.GamerProxy;
import com.project.gamerfront.service.GamerService;

@Service("gamerService")
public class GamerServiceImp implements GamerService {

	@Autowired
	private GamerProxy gamerProxy;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		GamerBean gamer = gamerProxy.getGamerByMail(username);
		if (gamer == null) {
			throw new UsernameNotFoundException(username + " not found");
		}
		return gamer;
	}

	@Override
	public String addGamer(GamerBean gamer) {
		String password = gamer.getPassword();
		gamer.setPassword(BCryptManagerUtil.passwordencoder().encode(password));
		return gamerProxy.addGamerSubscribe(gamer);
	}

	@Override
	public GamerBean getByMail(String mail) {
		return gamerProxy.getGamerByMail(mail);
	}

	@Override
	public void updateGamer(GamerBean gamer, String mail) {
		GamerBean updated_gamer = gamerProxy.getGamerByMail(mail);
		updated_gamer.setGamertag(gamer.getGamertag());
		updated_gamer.setEmail(gamer.getEmail());
		updated_gamer.setPassword(gamer.getPassword());
		updated_gamer.setServer(gamer.getServer());
		updated_gamer.setPlateform(gamer.getPlateform());
		gamerProxy.updateProfileGamer(updated_gamer);
	}
	
	
	@Override
	public List<GamerBean> getGamerMet(List<EventBean> events, GamerBean gamer) {
		List<GamerBean> gamer_met = new ArrayList<>();
		LinkedHashSet<GamerBean> gamerHashSet = new LinkedHashSet<>();
		
		for(EventBean e:events) {
			List<GamerBean> participants = e.getParticipants();
			for(GamerBean g:participants) {
				String mail = g.getEmail();
				if(!mail.equals(gamer.getEmail()) && gamerHashSet.add(g)) {
					gamer_met.add(g);					
				}	
			}
		}
		return gamer_met;
	}

	@Override
	public void voteForGamer(String email, GamerBean gamer) {
		gamerProxy.postVoteForGamer(email, gamer);
	}


}
