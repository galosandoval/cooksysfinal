package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserResponseCompanyDTO {
	private String companyName;

	private String companyDescription;	
}
