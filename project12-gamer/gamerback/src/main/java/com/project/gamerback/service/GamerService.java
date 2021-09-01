package com.project.gamerback.service;

import java.util.List;
import java.util.Optional;

import com.project.gamerback.model.Gamer;

/**
 * Interface du service des Gamers.
 */
public interface GamerService {

	/**
     * Renvoie la liste de tous les Gamer
     *
     * @return {@link List}
     */
    List<Gamer> getAll();
	
	/**
     * Renvoie un gamer à l'aide du mail
     *
     * @param mail : mail du gamer recherché
     * @return {@link Optional}
     */
	Optional<Gamer> getByMail(String mail);
	
    /**
     * Renvoie un gamer à l'aide du numero
     *
     * @param id : numero du gamer recherché
     * @return {@link Optional}
     */
	Optional<Gamer> getById(int id);
	
    /**
     * Ajoute les modifications apportés par l'utilisateur
     *
     * @param gamer: Gamer concerné
     */
	void updateProfile(Gamer gamer);
	
    /**
     * Ajoute aux données de la base un nouveau Gamer
     *
     * @param gamer: Gamer concerné
     */
	void addGamer(Gamer gamer);
	
    /**
     * Supprime de la base le gamer donné
     *
     * @param gamer: Gamer concerné
     */
	void deleteGamer(Gamer gamer);
	
	/**
     * Calcul le Rank de chaque Gamer en fonction de ses notes
     *
     */
	void calculateRankGamer(Gamer gamer);
}
