package com.project.gamerfront.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;

/**
 * Interface du service des Gamers.
 */
public interface GamerService extends UserDetailsService{

    /**
     * Renvoie un gamer à l'aide du mail
     *
     * @param mail : mail du gamer recherché
     * @return {@link Optional}
     */
	GamerBean getByMail(String mail);
	
    /**
     * Renvoie un gamer à l'aide du numero
     *
     * @param id : numero du gamer recherché
     * @return {@link Optional}
     */
	GamerBean getById(int id);
	
    /**
     * Ajoute aux données de la base un nouveau Gamer
     *
     * @param gamer: Gamer concerné
     * @return {@link String}
     */
	String addGamer(GamerBean gamer);
	
    /**
     * Ajoute les modifications apportés par l'utilisateur
     *
     * @param gamer: Gamer concerné
     */
	void updateGamer(GamerBean gamer, String mail);
	
    /**
     * Renvoie la liste des joueurs que le gamer a rencontrés
     *
     * @param events: liste des Events
     * @param gamer: Gamer concerné
     * @return {@link List}
     */
	List<GamerBean> getGamerMet(List<EventBean> events, GamerBean gamer);
	
    /**
     * Renvoie true si le voter a deja voté pour le voted
     * Sinon renvoie false
     *
     * @param voter: Gamer qui vote
     * @param voted: Gamer pour qui on vote
     * @return {@link boolean}
     */
	boolean asAlreadyVotedFor(GamerBean voter, GamerBean voted);
	
    /**
     * Applique un vote positif pour le gamer voted
     *
     * @param voter: Gamer qui vote
     * @param voted: Gamer pour qui on vote
     */
	void voteGoodForGamer(GamerBean voter, GamerBean voted);
	
    /**
     * Applique un vote négatif pour le gamer voted
     *
     * @param voter: Gamer qui vote
     * @param voted: Gamer pour qui on vote
     */
	void voteBadForGamer(GamerBean voter, GamerBean voted);
	
	/**
     * Calcul le Rank de chaque Gamer en fonction de ses notes
     *
     */
	void calculateRankGamer();
}
