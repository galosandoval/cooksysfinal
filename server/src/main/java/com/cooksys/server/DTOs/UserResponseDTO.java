package com.cooksys.server.DTOs;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponseDTO {
	private String userName;
	
	private String firstName;

	private String lastName;
	
	private UserResponseTeamDTO associatedTeam; 

	private Boolean isDeleted;
	
	private UserResponseCompanyDTO userCompany;

	private UserResponseRoleDTO userRole;
	
	private List<UserResponseProjectDTO> projects;
	
	private boolean newUser;
}
