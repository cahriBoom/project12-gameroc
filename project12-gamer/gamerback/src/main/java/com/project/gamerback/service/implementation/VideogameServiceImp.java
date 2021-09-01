package com.project.gamerback.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Videogame;
import com.project.gamerback.repository.EventRepository;
import com.project.gamerback.repository.VideogameRepository;
import com.project.gamerback.service.VideogameService;

/**
 * Implementation du service Videogame
 */
@Service
public class VideogameServiceImp implements VideogameService{
	
	
	@Autowired
	private VideogameRepository videogameRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Videogame> getAllGames() {
		return videogameRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Videogame getById(int id) {
		return videogameRepository.findById(id).get();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Videogame findByNomAndPlateform(String nom, String plateform) {
		Videogame videogame = videogameRepository.findByNomAndPlateform(nom, plateform).get();
		return videogame;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isExclusive(Videogame videogame) {
		String exclu = videogame.getExclusive();
		if(exclu.equals("Xbox") || exclu.equals("Playstation") || exclu.equals("PC")) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fixExclusivity() {
		List<Event> events = eventRepository.findAll();
		for(Event e:events) {
			boolean isExclu = this.isExclusive(e.getVideogame());
			if(isExclu) {
				String plateform = e.getVideogame().getExclusive();
				if(plateform.equals("Xbox")) {
					e.setPlateform("Xbox");
				}
				if(plateform.equals("PC")) {
					e.setPlateform("PC");
				}
				if(plateform.equals("Playstation")) {
					e.setPlateform("Playstation");
				}
				eventRepository.save(e);
			}			
		}
	}



}
