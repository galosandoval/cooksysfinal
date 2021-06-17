package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyResponseFilterUsersDTO {
	private String userName;
	
	private String firstName;

	private String lastName;
	
	private Boolean isDeleted;
	
	private RoleResponseDTO userRole;
	
	private boolean newUser;
	
	private TeamDTO associatedTeam;
}
