package com.project.gamerfront.service;

import java.util.List;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.beans.GamerBean;
import com.project.gamerfront.beans.VideogameBean;

/**
 * Interface du service des Events.
 */
public interface EventService {

    /**
     * Renvoie la liste des events
     *
     * @return {@link List}
     */
	List<EventBean> getAllEvents();
	
    /**
     * Renvoie la liste des events disponible.
     * 
     *@param events: liste des evenements que l'on souhaite trier
     * @return {@link List}
     */
	List<EventBean> allEventAvailable(List<EventBean> events);
	
    /**
     * Renvoie l'event suivant son numero
     *
     *@param id : numero de l'event rechercher
     * @return {@link Event}
     */
	EventBean getEventById(int id);
	
	 /**
     * Ajoute un Event dans la liste de tous les events
     *
     * @param event : the Event that will be added
     */
	void addEvent(EventBean event);
	
	 /**
     * Supprime un Event de la liste de tous les events
     *
     * @param event : the Event that will be removed
     */
	void deleteEvent(EventBean event);
	
    /**
     * Renvoie la liste des events correspondant
     * à la recherche faite par l'utilisateur
     *
     *@param search : la chaîne de caractère rentrée par l'utilisateur pour rechercher un event
     * @return {@link List}
     */
	List<EventBean> getEventsBySearch(VideogameBean videogame);
	
    /**
	 * Renvoie true si le gamer est conecté.
	 * Si l'event est toujours d'actualité, disponible, qu'il reste des places
	 * Si le joueur n'es pas le createur du post et ou si il n'es pas déja dans le groupe
     * Renvoie false si toutes ces conditions ne sont pas respectées
     *
     *@param event : Event concerné
     *@param username : mail du Gamer concerné
     * @return {@link boolean}
     */
	boolean isEligible(EventBean event, String username);
	
    /**
     * Supprime les events dont username est l'host
     *
     *@param events : liste des events
     *@param username : host des events 
     * @return {@link List}
     */
	List<EventBean> RemoveOwnEvents(List<EventBean> events, String username);
	
    /**
	 * Effectue les modification lorsqu'un joueur rejoins ou quitte le groupe
     *
     *@param event : Event concerné
     *@param username : mail du Gamer concerné
     */
	void updateGroupEvent(GamerBean gamer, EventBean event);
	
    /**
     * Renvoie true si le gamer est déja dans le groupe de joueurs
     * Renvoie false si le gamer n'est pas dans le groupe de joueurs
     *
     *@param event : Event concerné
     *@param gamer : Gamer concerné
     * @return {@link boolean}
     */
	boolean isAlreadyIn(String current, EventBean event);
	
    /**
     * Renvoie la liste des events dont le gamer est host
     *
     *@param gamer : gamer qui est host
     * @return {@link List}
     */
	List<EventBean> findEventsByGamer(GamerBean gamer);
	
}
