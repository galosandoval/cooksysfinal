package com.cooksys.server.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSignInRequestDTO {
	private String userName;
	
	private String password;
}
