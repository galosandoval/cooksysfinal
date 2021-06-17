package com.cooksys.server.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyEditRequestDTO {
	private UserSignInRequestDTO credentials;
	
	private CompanyDTO newCompany;
}
