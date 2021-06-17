package com.cooksys.server.services;

import java.util.List;

import com.cooksys.server.DTOs.ProjectCreateRequestDTO;
import com.cooksys.server.DTOs.ProjectResponseDTO;
import com.cooksys.server.DTOs.UserSignInRequestDTO;

public interface ProjectService {

	ProjectResponseDTO createProject(ProjectCreateRequestDTO projectRequestDTO);

	List<ProjectResponseDTO> getAllProjects();

	ProjectResponseDTO getProjectByName(String name);

	ProjectResponseDTO deleteProject(String projectName, UserSignInRequestDTO credentials);

	ProjectResponseDTO updateProject(String projectName, ProjectCreateRequestDTO projectRequestDTO);
}
