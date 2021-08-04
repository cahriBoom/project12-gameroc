package com.project.gamerfront.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gamerfront.beans.EventBean;
import com.project.gamerfront.proxies.GamerProxy;
import com.project.gamerfront.service.EventService;

@Service("eventService")
public class EventServiceImp implements EventService{

	@Autowired
	private GamerProxy gamerProxy;
	
	@Override
	public List<EventBean> getAllEvents() {
		return gamerProxy.getAllEvents();
	}

	@Override
	public EventBean getEventById(int id) {
		return gamerProxy.getEventById(id);
	}

}
