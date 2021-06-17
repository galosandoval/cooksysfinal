package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TeamResponseUsersDTO {
	private String userName;

	private String firstName;

	private String lastName;

	private String password;
	
	private RoleResponseDTO userRole;
}
