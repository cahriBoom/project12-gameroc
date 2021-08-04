package com.project.gamerback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.gamerback.model.Videogame;

@RepositoryRestResource
public interface VideogameRepository extends JpaRepository<Videogame, Integer>{

}
