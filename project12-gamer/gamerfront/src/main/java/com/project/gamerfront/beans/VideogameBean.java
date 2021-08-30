package com.project.gamerfront.beans;

import java.util.List;

/**
 * Bean that's represent a Videogame
 */
public class VideogameBean {
	
	// ==================== Attributs ====================
	/**The numero */
	private int id;

	/**The name */
	private String nom;

	/**The platform */
	private String plateform;
	
	/**The exclusivity */
	private String exclusive;
	
	/**The list of event for this game */
	private List<EventBean> list_events;

	// ==================== Constructeurs ====================
    /**
     * Instantiates a new Videogame.
     */
	public VideogameBean() {
		this("","");
	}

    /**
     * Instantiates a new Videogame.
     *
     * @param name : the name
     * @param plateform : the plateform
     */
	public VideogameBean(String name, String plateform) {
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

	public List<EventBean> getList_events() {
		return list_events;
	}

	public void setList_events(List<EventBean> list_events) {
		this.list_events = list_events;
	}

	public String getExclusive() {
		return exclusive;
	}

	public void setExclusive(String exclusive) {
		this.exclusive = exclusive;
	}
	
}
