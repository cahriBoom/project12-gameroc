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

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_event")
	private int id;

	private Date debut;

	private Date fin;

	private int spots;

	private int maximum_players;

	private int player_needed;

	private String description;

	private String title;

	private String plateform;

	@ManyToOne
	private Gamer host;
	
	@ManyToMany
	private List<Gamer> participants;

	@ManyToOne
	private Videogame videogame;

	private String vgname;

	public Event() {
		this(new Date(), new Date(), "", "", "");
	}

	public Event(Date debut, Date fin, String description, String title, String vg_name) {
		this.debut = debut;
		this.fin = fin;
		this.description = description;
		this.title = title;
		this.vgname = vg_name;
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
