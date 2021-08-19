package com.project.gamerback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Gamer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gamer")
	private int id;

	private String email;

	private String password;

	private String gamertag;

	private String plateform;
	
	private int good_rating;
	
	private int bad_rating;

	private String server;

	private String note;
	
	@ManyToMany
	private List<Gamer> votedFor;
	
	public Gamer() {
		this("", "", "", "");
	}

	public Gamer(String email, String gamertag, String plateform, String server) {
		this.email = email;
		this.gamertag = gamertag;
		this.plateform = plateform;
		this.server = server;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGamertag() {
		return gamertag;
	}

	public void setGamertag(String gamertag) {
		this.gamertag = gamertag;
	}

	public String getPlateform() {
		return plateform;
	}

	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGood_rating() {
		return good_rating;
	}

	public void setGood_rating(int good_rating) {
		this.good_rating = good_rating;
	}

	public int getBad_rating() {
		return bad_rating;
	}

	public void setBad_rating(int bad_rating) {
		this.bad_rating = bad_rating;
	}

	public List<Gamer> getVotedFor() {
		return votedFor;
	}

	public void setVotedFor(List<Gamer> votedFor) {
		this.votedFor = votedFor;
	}


}
