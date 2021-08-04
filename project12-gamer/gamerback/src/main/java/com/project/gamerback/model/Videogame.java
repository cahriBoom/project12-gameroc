package com.project.gamerback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Videogame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_videogame")
	private int id;

	private String nom;

	private String plateform;

	@JsonIgnore
	@OneToMany(mappedBy = "videogame")
	private List<Event> list_events;

	public Videogame() {
		this("","");
	}

	public Videogame(String string, String string2) {
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

	public List<Event> getList_events() {
		return list_events;
	}

	public void setList_events(List<Event> list_events) {
		this.list_events = list_events;
	}
}
