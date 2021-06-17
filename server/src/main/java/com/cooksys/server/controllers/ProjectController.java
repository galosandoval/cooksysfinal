package com.cooksys.server.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.server.DTOs.ProjectCreateRequestDTO;
import com.cooksys.server.DTOs.ProjectResponseDTO;
import com.cooksys.server.DTOs.UserSignInRequestDTO;
import com.cooksys.server.services.ProjectService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("project")
@AllArgsConstructor
public class ProjectController {

	private ProjectService projectService;

	@GetMapping
	public List<ProjectResponseDTO> getAllProjects() {
		return projectService.getAllProjects();
	}

	@GetMapping("/{projectName}")
	@ResponseStatus(HttpStatus.OK)
	public ProjectResponseDTO getProjectByName(@PathVariable String projectName) {
		return projectService.getProjectByName(projectName);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProjectResponseDTO createProject(@RequestBody ProjectCreateRequestDTO projectRequestDTO) {
		return projectService.createProject(projectRequestDTO);
	}

	@PatchMapping("/{updateProject}")
	@ResponseStatus(HttpStatus.OK)
	public ProjectResponseDTO updateProject(@PathVariable("updateProject") String projectName,
			@RequestBody ProjectCreateRequestDTO projectRequestDTO) {
		return projectService.updateProject(projectName, projectRequestDTO);
	}

	@DeleteMapping("/{projectName}")
	@ResponseStatus(HttpStatus.OK)
	public ProjectResponseDTO deleteProject(@PathVariable("projectName") String projectName,
			@RequestBody UserSignInRequestDTO credentials) {
		return projectService.deleteProject(projectName, credentials);
	}

}