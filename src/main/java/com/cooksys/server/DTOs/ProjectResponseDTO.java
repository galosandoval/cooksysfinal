package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProjectResponseDTO {
	private String name;
	
	private String description;
	
	private String company;
	
	private ProjectResponseUserDTO user;
	
	private ProjectResponseTeamDTO team;
	
	private Boolean isDeleted;
}

