package com.project.gamerfront.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.gamerfront.config.BCryptManagerUtil;

/**
 * Bean that's represent a Gamer
 */
public class GamerBean implements Serializable, UserDetails{

	// ==================== Attributs ====================
	/**The numero */
	private int id;

	/**The email */
	private String email;

	/**The password */
	private String password;

	/**The gamertag */
	private String gamertag;

	/**The platform */
	private String plateform;

	/**The server */
	private String server;

	/**The difference between good and bad rates */
	private String note;
	
	/**The good rating receive by other players */
	private int good_rating;
	
	/**The bad rating receive by other players */
	private int bad_rating;
	
	/**The list of gamers already voted by */
	private List<GamerBean> votedFor;

	// ==================== Constructeurs ====================
    /**
     * Instantiates a new Gamer.
     */
	public GamerBean() {
		this("", "", "", "", "");
	}

    /**
     * Instantiates a new Gamer.
     *
     * @param email : the email
     * @param gamertag : the gamertag
     * @param plateform : the plateform
     * @param server : the server
     * @param password : the password
     */
	public GamerBean(String email, String gamertag, String plateform, String server, String password) {
		this.email = email;
		this.gamertag = gamertag;
		this.plateform = plateform;
		this.server = server;
		this.password = BCryptManagerUtil.passwordencoder().encode(password);
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
	
	public List<GamerBean> getVotedFor() {
		return votedFor;
	}

	public void setVotedFor(List<GamerBean> votedFor) {
		this.votedFor = votedFor;
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
