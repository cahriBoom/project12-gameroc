package com.project.gamerback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.gamerback.model.Gamer;

@RepositoryRestResource
public interface GamerRepository extends JpaRepository<Gamer, Integer>{

	Optional<Gamer> findByEmail(String email);
}
