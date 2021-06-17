package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponseTeamDTO {
	private String teamName;

	private String teamDescription;
}
