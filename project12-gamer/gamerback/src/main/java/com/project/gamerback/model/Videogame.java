package com.project.gamerback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Bean that's represent a Videogame
 */
@Entity
public class Videogame {

	// ==================== Attributs ====================
	/**The numero */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_videogame")
	private int id;

	/**The name */
	private String nom;

	/**The plateform */
	private String plateform;
	
	/**The exclusivity */
	private String exclusive;

	/**The list of event for this game */
	@JsonIgnore
	@OneToMany(mappedBy = "videogame")
	private List<Event> list_events;

	
	// ==================== Constructeurs ====================
    /**
     * Instantiates a new Videogame.
     */
	public Videogame() {
		this("","");
	}

    /**
     * Instantiates a new Videogame.
     *
     * @param name : the name
     * @param plateform : the plateform
     */
	public Videogame(String name, String plateform) {
		this.nom = name;
		this.plateform = plateform;
	}

	
	// ==================== Getters/Setters ====================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPlateform() {
		return plateform;
	}

	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}

	public List<Event> getList_events() {
		return list_events;
	}

	public void setList_events(List<Event> list_events) {
		this.list_events = list_events;
	}

	public String getExclusive() {
		return exclusive;
	}

	public void setExclusive(String exclusive) {
		this.exclusive = exclusive;
	}
	
}
