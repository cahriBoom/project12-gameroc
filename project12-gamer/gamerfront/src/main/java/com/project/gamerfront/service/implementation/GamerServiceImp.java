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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		GamerBean gamer = gamerProxy.getGamerByMail(username);
		if (gamer == null) {
			throw new UsernameNotFoundException(username + " not found");
		}
		return gamer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String addGamer(GamerBean gamer) {
		String password = gamer.getPassword();
		gamer.setPassword(BCryptManagerUtil.passwordencoder().encode(password));
		return gamerProxy.addGamerSubscribe(gamer);
	}
	
	public void deleteGamer(GamerBean gamer) {
		gamerProxy.deleteGamer(gamer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GamerBean getByMail(String mail) {
		return gamerProxy.getGamerByMail(mail);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public GamerBean getById(int id) {
		return gamerProxy.getGamerById(id);
	}

	/**
	 * {@inheritDoc}
	 */
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<GamerBean> getGamerMet(List<EventBean> events, GamerBean gamer) {
		List<GamerBean> gamer_met = new ArrayList<>();
		LinkedHashSet<GamerBean> gamerHashSet = new LinkedHashSet<>();
		
		for(EventBean e:events) {
			List<GamerBean> participants = e.getParticipants();
			for(GamerBean g:participants) {
				boolean asAlreadyVoted = this.asAlreadyVotedFor(gamer, g);
				String mail = g.getEmail();
				if(!mail.equals(gamer.getEmail()) && gamerHashSet.add(g) && !asAlreadyVoted) {
					gamer_met.add(g);					
				}	
			}
		}
		return gamer_met;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean asAlreadyVotedFor(GamerBean voter, GamerBean voted) {
		List<GamerBean> asVotedFor = voter.getVotedFor();
		for(GamerBean g:asVotedFor) {
			String mail = g.getEmail();
			if(mail.equals(voted.getEmail())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void voteGoodForGamer(GamerBean voter, GamerBean voted) {
		String mail_voter = voter.getEmail();
		voter.getVotedFor().add(voted);
		gamerProxy.updateProfileGamer(voter);
		int good_rate = voted.getGood_rating()+1;
		voted.setGood_rating(good_rate);
		gamerProxy.postVoteForGamer(mail_voter, voted);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void voteBadForGamer(GamerBean voter, GamerBean voted) {
		String mail_voter = voter.getEmail();
		voter.getVotedFor().add(voted);
		gamerProxy.updateProfileGamer(voter);
		int bad_rate = voted.getBad_rating()+1;
		voted.setBad_rating(bad_rate);
		gamerProxy.postVoteForGamer(mail_voter, voted);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void unvoteGoodGamer(GamerBean voter, GamerBean voted) {
		String mail = voter.getEmail();
		gamerProxy.unvoteGoodGamer(mail, voted);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void unvoteBadGamer(GamerBean voter, GamerBean voted) {
		String mail = voter.getEmail();
		gamerProxy.unvoteBadGamer(mail, voted);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void calculateRankGamer() {
		gamerProxy.initiateStatus();
	}

}
