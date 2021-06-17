package com.cooksys.server.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.server.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findAllByIsDeletedFalse();
	
	Optional<Team> findByTeamNameAndIsDeletedFalse(String teamName);

	Optional<Team> findByTeamNameIgnoreCase(String teamName);

	Optional<Team> findByTeamName(String teamName);
}
