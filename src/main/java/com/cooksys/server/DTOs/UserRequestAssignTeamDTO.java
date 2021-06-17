package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequestAssignTeamDTO {
	private UserSignInRequestDTO credentials;

	private String teamName;
}
