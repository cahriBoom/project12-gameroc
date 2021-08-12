package com.project.gamerback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.gamerback.model.Event;

@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event, Integer>{

}
