package com.project.gamerfront.beans;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Bean that's represent an Event
 */
public class EventBean {

	// ==================== Attributs ====================
	/**The numero */
	private int id;

	/**The beginning */
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date debut;

	/**The ending */
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fin;
	
	/**The description */
	private String description;
	
	/**The number of spots available */
	private int spots;
	
	/**The maximum number of player for this event */
	private int maximum_player;
	
	/**The number of player requested by the host */
	private int player_needed;
	
	/**The title */
	private String title;

	/**The plateform requested by the host */
	private String plateform;
	
	/**The videogame linked to the event */
	private VideogameBean videogame;
	
	/**The name of the videogame */
	private String vgname;
	
	/**The gamer who created the event */
	private GamerBean host;
	
	/**The list of gamers participating at the event */
	private List<GamerBean> participants;

	// ==================== Constructeurs ====================
    /**
     * Instantiates a new Event.
     */
	public EventBean() {
		this(new Date(), "", "", 0, 0, new VideogameBean(), "", new GamerBean());
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
	public EventBean(Date debut, String desc, String title, int spots, int player_needed,VideogameBean videogame, String vg_name, GamerBean host ) {
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

	public VideogameBean getVideogame() {
		return videogame;
	}

	public void setVideogame(VideogameBean game) {
		this.videogame = game;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<GamerBean> getParticipants() {
		return participants;
	}

	public void setParticipants(List<GamerBean> participants) {
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

	public int getMaximum_player() {
		return maximum_player;
	}

	public void setMaximum_player(int maximum_player) {
		this.maximum_player = maximum_player;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public GamerBean getHost() {
		return host;
	}

	public void setHost(GamerBean host) {
		this.host = host;
	}
	
	
	
}
