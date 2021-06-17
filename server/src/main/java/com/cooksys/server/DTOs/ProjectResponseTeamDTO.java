package com.cooksys.server.DTOs;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProjectResponseTeamDTO {
	private String teamName;

	private String teamDescription;
		
	private List<ProjectResponseUserDTO> teamMembers;
		
	private Boolean isDeleted;
}
