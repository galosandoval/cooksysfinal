
package com.cooksys.server.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.server.entities.Project;
import com.cooksys.server.entities.Team;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	Optional<Project> findByName(String projectName);
	
	List<Project> findAllByIsDeletedFalse();

	Optional<Project> findByNameAndIsDeletedFalse(String name);

	Optional<Project> findByIdAndIsDeletedFalse(Long id);

	Optional<Project> findByTeamAndIsDeletedFalse(Team team);
}

