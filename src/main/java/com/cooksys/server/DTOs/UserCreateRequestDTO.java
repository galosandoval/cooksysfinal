package com.cooksys.server.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCreateRequestDTO {
	
	private UserDTO createUser;
	
	private String companyName;
}
