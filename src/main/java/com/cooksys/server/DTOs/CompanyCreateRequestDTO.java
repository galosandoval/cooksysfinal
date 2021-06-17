package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyCreateRequestDTO {
	private CompanyDTO seedCompany;
	
	private UserSignInRequestDTO seedUser;
}
