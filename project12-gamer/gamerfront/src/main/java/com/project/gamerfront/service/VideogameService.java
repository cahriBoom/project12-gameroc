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
     * Renvoie un jeu video suivant son numero
     *
     * @param id: numero du jeu video
     * @return {@link VideogameBean}
     */
	VideogameBean getById(int id);
	
    /**
     * Renvoie la liste des jeux sans les doublons liées aux différentes plateforme
     *
     * @return {@link List}
     */
	List<String> getGamesWithoutDupplicate();
}
