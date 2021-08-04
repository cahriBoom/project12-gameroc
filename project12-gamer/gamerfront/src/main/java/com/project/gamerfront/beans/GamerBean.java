package com.project.gamerfront.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.gamerfront.config.BCryptManagerUtil;


public class GamerBean implements Serializable, UserDetails{

	private int id;

	private String email;

	private String password;

	private String gamertag;

	private String plateform;

	private String server;

	private String note;

	private List<VideogameBean> list_games;

	public GamerBean() {
		this("", "", "", "", "");
	}

	public GamerBean(String email, String gamertag, String plateform, String server, String password) {
		this.email = email;
		this.gamertag = gamertag;
		this.plateform = plateform;
		this.server = server;
		this.password = BCryptManagerUtil.passwordencoder().encode(password);
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

	public List<VideogameBean> getList_games() {
		return list_games;
	}

	public void setList_games(List<VideogameBean> list_games) {
		this.list_games = list_games;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		String email = this.getEmail();
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
