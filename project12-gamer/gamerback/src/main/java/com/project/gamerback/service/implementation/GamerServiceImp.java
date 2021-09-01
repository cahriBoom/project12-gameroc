package com.project.gamerback.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerback.model.Gamer;
import com.project.gamerback.repository.GamerRepository;
import com.project.gamerback.service.GamerService;


/**
 * Implementation du service Gamer
 */
@Service
public class GamerServiceImp implements GamerService {

	@Autowired
	private GamerRepository gamerRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Gamer> getAll() {
		return gamerRepository.findAll();
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Gamer> getByMail(String email) {
		return gamerRepository.findByEmail(email);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Gamer> getById(int id) {
		return gamerRepository.findById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addGamer(Gamer gamer) {
		gamer.setNote("NEW");
		gamerRepository.save(gamer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteGamer(Gamer gamer) {
		gamerRepository.delete(gamer);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateProfile(Gamer gamer) {
		gamerRepository.save(gamer);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void calculateRankGamer(Gamer gamer) {
			int good_rate = gamer.getGood_rating();
			int bad_rate = gamer.getBad_rating();
			if (good_rate < bad_rate) {
				gamer.setNote("TOXIC");
			}
			if (good_rate > 0 && good_rate <= 5) {
				gamer.setNote("GOOD");
			}
			if (good_rate > 5 && good_rate <= 10) {
				gamer.setNote("VETERAN");
			}
			if (good_rate > 10) {
				gamer.setNote("MASTER");
			}
			if (good_rate == 0 && bad_rate == 0) {
				gamer.setNote("NEW");
			}
			gamerRepository.save(gamer);
	}




}
