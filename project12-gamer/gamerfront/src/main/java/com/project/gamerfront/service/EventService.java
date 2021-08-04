package com.project.gamerfront.service;

import java.util.List;

import com.project.gamerfront.beans.EventBean;

public interface EventService {

	List<EventBean> getAllEvents();
	
	EventBean getEventById(int id);
}
