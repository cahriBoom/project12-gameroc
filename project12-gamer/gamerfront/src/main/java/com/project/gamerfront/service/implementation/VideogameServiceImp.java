package com.project.gamerfront.service.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerfront.beans.VideogameBean;
import com.project.gamerfront.proxies.GamerProxy;
import com.project.gamerfront.service.VideogameService;

@Service("videgameService")
public class VideogameServiceImp implements VideogameService{

	@Autowired
	private GamerProxy gamerProxy;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<VideogameBean> getAll() {
		return gamerProxy.getAllVideogames();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public VideogameBean getById(int id) {
		return gamerProxy.getVideogameById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getGamesWithoutDupplicate() {
		List<VideogameBean> videogames = gamerProxy.getAllVideogames();
		List<String> list_games = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for(VideogameBean v:videogames) {
			String name = v.getNom();
			set.add(name);
		}
		list_games.addAll(set);
		return list_games;
	}
}
