package com.project.gamerfront.beans;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class EventBean {

	private int id;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date debut;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fin;
	
	private String description;
	
	private int spots;
	
	private int maximum_player;
	
	private int player_needed;
	
	private String title;

	private String plateform;
	
	private VideogameBean videogame;
	
	private String vgname;
	
	private GamerBean host;
	
	private List<GamerBean> participants;

	public EventBean() {
		this(new Date(), new Date(), "", "", "");
	}

	public EventBean(Date debut, Date fin, String desc, String title, String vg_name) {
		this.debut = debut;
		this.fin = fin;
		this.description = desc;
		this.title = title;
		this.vgname=vg_name;
		
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
