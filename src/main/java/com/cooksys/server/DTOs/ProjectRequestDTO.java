package com.cooksys.server.DTOs;

import java.util.List;

import com.cooksys.server.entities.Team;
import com.cooksys.server.entities.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProjectRequestDTO {
	private String name;

	private String description;

	private Team projectTeam;

	private List<User> projectUsers;

}

