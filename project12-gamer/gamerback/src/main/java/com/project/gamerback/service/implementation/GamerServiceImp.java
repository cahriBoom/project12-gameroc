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

	@Override
	public void addGamer(Gamer gamer) {
		gamer.setNote("NEW");
		gamerRepository.save(gamer);
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
	public void calculateRankGamer() {
		List<Gamer> all = gamerRepository.findAll();
		for (Gamer g : all) {
			int good_rate = g.getGood_rating();
			int bad_rate = g.getBad_rating();
			if (good_rate < bad_rate) {
				g.setNote("TOXIC");
			}
			if (good_rate > 0 && good_rate <= 5) {
				g.setNote("GOOD");
			}
			if (good_rate > 5 && good_rate <= 10) {
				g.setNote("VETERAN");
			}
			if (good_rate > 10) {
				g.setNote("MASTER");
			}
			if (good_rate == 0 && bad_rate == 0) {
				g.setNote("NEW");
			}
			gamerRepository.save(g);
		}
	}
}
