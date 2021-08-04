package com.project.gamerfront.beans;

import java.util.List;

public class VideogameBean {
	
	private int id;

	private String nom;

	private String plateform;

	
	private List<EventBean> list_events;

	public VideogameBean() {
		this("","");
	}

	public VideogameBean(String string, String string2) {
		this.nom = string;
		this.plateform = string2;
	}

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
}
