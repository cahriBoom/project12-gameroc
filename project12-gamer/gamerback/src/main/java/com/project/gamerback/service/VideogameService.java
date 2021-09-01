package com.project.gamerback.service;

import java.util.List;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Videogame;

/**
 * Interface du service des Videogames.
 */
public interface VideogameService {

    /**
     * Renvoie la liste des Jeux vidéos
     *
     * @return {@link List}
     */
	List<Videogame> getAllGames();
	
    /**
     * Renvoie un Jeux en fonction de son numero
     *
     * @param id : numero of the videogame
     * @return {@link List}
     */
	Videogame getById(int id);
	
    /**
     * Renvoie un jeu suivant sa plateforme et son nom
     *
     *@param nom : nom du jeu recherché
     *@param plateform : plateform du jeu recherché
     * @return {@link Event}
     */
	Videogame findByNomAndPlateform(String nom, String plateform);
	
    /**
     * Test si le Jeux associé à l'Event est une exclusivitée
     *
     *@param videogame : Videogame concerné
     * @return {@link Boolean}
     */
	boolean isExclusive(Videogame videogame);
	
    /**
     * Traite et, si besoin, modifie la plateforme des events
     * Si le jeu est une exclusivitée
     *
     */
	void fixExclusivity();
}
