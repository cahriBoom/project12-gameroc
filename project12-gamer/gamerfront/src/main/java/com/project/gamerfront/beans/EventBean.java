package com.project.gamerfront.beans;

import java.util.Date;
import java.util.List;

public class EventBean {

	private int id;

	private Date debut;

	private String description;
	
	private int spots;
	
	private int player_needed;
	
	private String title;

	private String plateform;
	
	private VideogameBean videogame;
	
	private List<GamerBean> participants;

	public EventBean() {
		this(new Date(), "", "");
	}

	public EventBean(Date date, String desc, String title) {
		this.debut = date;
		this.description = desc;
		this.title = title;;
		
	}

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
	
	
}
