package com.project.gamerfront.service;

import java.util.List;

import com.project.gamerfront.beans.VideogameBean;

public interface VideogameService {

	List<VideogameBean> getAll();
	
	VideogameBean getByNameAndPlateform(String name, String plateform);
	
	List<String> getGamesWithoutDupplicate();
}
