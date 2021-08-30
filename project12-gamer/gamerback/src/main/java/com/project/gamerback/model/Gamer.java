package com.project.gamerback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Bean that's represent a Gamer
 */
@Entity
public class Gamer {

	// ==================== Attributs ====================
	/**The numero */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gamer")
	private int id;

	/**The email */
	private String email;

	/**The password */
	private String password;

	/**The gamertag */
	private String gamertag;

	/**The plateform */
	private String plateform;
	
	/**The good rating receive by other players */
	private int good_rating;
	
	/**The bad rating receive by other players */
	private int bad_rating;

	/**The server played on */
	private String server;

	/**The difference between good and bad rates */
	private String note;
	
	/**The list of gamers already voted by */
	@ManyToMany
	private List<Gamer> votedFor;
	
	// ==================== Constructeurs ====================
    /**
     * Instantiates a new Gamer.
     */
	public Gamer() {
		this("", "", "", "", "");
	}

    /**
     * Instantiates a new Gamer.
     *
     * @param email : the email
     * @param gamertag : the gamertag
     * @param password : the password
     * @param plateform : the plateform
     * @param server : the server
     */
	public Gamer(String email, String gamertag, String password, String plateform, String server) {
		this.email = email;
		this.gamertag = gamertag;
		this.password = password;
		this.plateform = plateform;
		this.server = server;
	}

	// ==================== Getters/Setters ====================
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
