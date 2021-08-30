package com.project.gamerfront.service;

import java.util.List;

import com.project.gamerfront.beans.VideogameBean;

/**
 * Interface du service des Videogames.
 */
public interface VideogameService {

    /**
     * Renvoie la liste des Jeux vidéos
     *
     * @return {@link List}
     */
	List<VideogameBean> getAll();
	
    /**
     * Renvoie la liste des jeux sans les doublons liées aux différentes plateforme
     *
     * @return {@link List}
     */
	List<String> getGamesWithoutDupplicate();
}
