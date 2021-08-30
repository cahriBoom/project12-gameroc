package com.project.gamerback.service;

import java.util.List;

import com.project.gamerback.model.Event;
import com.project.gamerback.model.Gamer;

/**
 * Interface du service des Events.
 */
public interface EventService {

    /**
     * Renvoie la liste des events
     *
     * @return {@link List}
     */
	List<Event> getAll();
	
    /**
     * Renvoie l'event suivant son numero
     *
     *@param id : numero de l'event rechercher
     * @return {@link Event}
     */
	Event getById(int id);
	
	 /**
     * Ajoute un Event dans la liste de tous les events
     *
     * @param event : the Event that will be added
     */
	void addNewEvent(Event event);
	
	 /**
     * Modifie les données de la base pour que le nombre de place
     * disponible correspondent au nombre de participants
     *
     * @param event : the Event
     */
	void calculateSpotsTaken(Event event);
	
    /**
     * Renvoie la liste des events correspondant
     * à la recherche faite par l'utilisateur
     *
     *@param search : la chaîne de caractère rentrée par l'utilisateur pour rechercher un event
     * @return {@link List}
     */
	List<Event> searchEvent(String search);
	
    /**
     * Renvoie true si le gamer est déja dans le groupe de joueurs
     * Renvoie false si le gamer n'est pas dans le groupe de joueurs
     *
     *@param event : Event concerné
     *@param gamer : Gamer concerné
     * @return {@link boolean}
     */
	boolean isAlreadyIn(Event event, Gamer gamer);
	
	 /**
     * Vérifie si le gamer doit s'inscrire ou quitter le groupe
     *
     *@param event : Event concerné
     *@param gamer : Gamer concerné
     */
	void updateGroupEvent(Event event, Gamer gamer);
	
	 /**
     * Ajoute le gamer à la liste des participants
     * Retire une place disponible dans le groupe
     *
     *@param event : Event concerné
     *@param gamer : Gamer concerné
     */
	void participateToEvent(Event event, Gamer gamer);
	
	 /**
     * Retire le gamer à la liste des participants
     * Ajoute une place disponible dans le groupe
     *
     *@param event : Event concerné
     *@param gamer : Gamer concerné
     */
	void quittingEvent(Event event, Gamer gamer);
}
