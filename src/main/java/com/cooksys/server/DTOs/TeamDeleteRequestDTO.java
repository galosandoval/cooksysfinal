package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TeamDeleteRequestDTO {
	private UserSignInRequestDTO credentials;
}
