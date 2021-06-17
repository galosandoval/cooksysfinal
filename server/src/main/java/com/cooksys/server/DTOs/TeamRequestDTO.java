package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TeamRequestDTO {
	private UserSignInRequestDTO credentials;
	
	private TeamDTO team;

}
