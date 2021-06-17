package com.cooksys.server.DTOs;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyResponseTeamDTO {
	private String teamName;

	private String teamDescription;
	
	private Boolean isDeleted;
	
	private List<CompanyResponseUserDTO> teamMembers;
}
