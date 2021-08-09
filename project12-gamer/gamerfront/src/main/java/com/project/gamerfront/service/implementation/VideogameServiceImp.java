package com.project.gamerfront.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerfront.beans.VideogameBean;
import com.project.gamerfront.proxies.GamerProxy;
import com.project.gamerfront.service.VideogameService;

@Service("videgameService")
public class VideogameServiceImp implements VideogameService{

	@Autowired
	private GamerProxy gamerProxy;
	
	@Override
	public List<VideogameBean> getAll() {
		return gamerProxy.getAllVideogames();
	}

}
