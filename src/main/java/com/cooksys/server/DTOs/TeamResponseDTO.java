package com.cooksys.server.DTOs;

import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TeamResponseDTO {
	private String teamName;

	private String teamDescription;
	
	private TeamResponseCompanyDTO parentCompany;
	
	private List<TeamResponseUsersDTO> teamMembers;
	
	private List<TeamResponseProjectsDTO> projects;
	
	private Boolean isDeleted;
	
}
