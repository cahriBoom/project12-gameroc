package com.project.gamerback.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


/**
 * Bean that's represent an Event
 */
@Entity
public class Event {

	// ==================== Attributs ====================
	/**The numero */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_event")
	private int id;

	/**The begin */
	private Date debut;

	/**The end */
	private Date fin;

	/**The number of spots available */
	private int spots;

	/**The maximum number of player for this event */
	private int maximum_players;

	/**The number of player requested by the host */
	private int player_needed;

	/**The description */
	private String description;

	/**The Title */
	private String title;

	/**The plateform requested by the host */
	private String plateform;

	/**The gamer who created the event */
	@ManyToOne
	private Gamer host;
	
	/**The list of gamers participating at the event */
	@ManyToMany
	private List<Gamer> participants;

	/**The videogame linked to the event */
	@ManyToOne
	private Videogame videogame;

	/**The name of the videogame */
	private String vgname;

	
	// ==================== Constructeurs ====================
    /**
     * Instantiates a new Event.
     */
	public Event() {
		this(new Date(), "", "", 0, 0, new Videogame(), "", new Gamer());
	}

    /**
     * Instantiates a new Event.
     *
     * @param debut : the beginning
     * @param desc : the description
     * @param title : the title
     * @param spots : number of space available
     * @param player_needed : number of player needed
     * @param videogame : videogame associated
	 * @param host : creator 
     * @param vg_name : the name of the video_game linked to the event
     */
	public Event(Date debut, String desc, String title, int spots, int player_needed,Videogame videogame, String vg_name, Gamer host ) {
		this.debut = debut;
		this.description = desc;
		this.title = title;
		this.spots = spots;
		this.player_needed = player_needed;
		this.videogame = videogame;
		this.vgname=vg_name;
		this.host = host;		
	}

	
	// ==================== Getters/Setters ====================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Videogame getVideogame() {
		return videogame;
	}

	public void setVideogame(Videogame game) {
		this.videogame = game;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Gamer> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Gamer> participants) {
		this.participants = participants;
	}

	public String getPlateform() {
		return plateform;
	}

	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}

	public int getSpots() {
		return spots;
	}

	public void setSpots(int spots) {
		this.spots = spots;
	}

	public int getPlayer_needed() {
		return player_needed;
	}

	public void setPlayer_needed(int player_needed) {
		this.player_needed = player_needed;
	}

	public String getVgname() {
		return vgname;
	}

	public void setVgname(String videogame_name) {
		this.vgname = videogame_name;
	}

	public int getMaximum_players() {
		return maximum_players;
	}

	public void setMaximum_players(int maximum_players) {
		this.maximum_players = maximum_players;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Gamer getHost() {
		return host;
	}

	public void setHost(Gamer host) {
		this.host = host;
	}

	
}
