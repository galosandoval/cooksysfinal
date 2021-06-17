package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProjectCreateRequestDTO {
	private UserSignInRequestDTO credentials;

	private ProjectDTO project;
}
