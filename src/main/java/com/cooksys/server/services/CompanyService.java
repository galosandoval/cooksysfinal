package com.cooksys.server.services;

import java.util.List;

import com.cooksys.server.DTOs.CompanyCreateRequestDTO;
import com.cooksys.server.DTOs.CompanyEditRequestDTO;
import com.cooksys.server.DTOs.CompanyResponseDTO;

public interface CompanyService {

	List<CompanyResponseDTO> getAllCompanies();

	CompanyResponseDTO getCompany(String companyName);

	CompanyResponseDTO postCompany(CompanyCreateRequestDTO companyRequest);
	
	CompanyResponseDTO updateCompanyDescription(String companyName, CompanyEditRequestDTO companyUpdate);
}
