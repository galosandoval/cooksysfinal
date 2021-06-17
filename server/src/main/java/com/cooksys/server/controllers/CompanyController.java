package com.cooksys.server.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.cooksys.server.DTOs.CompanyCreateRequestDTO;
import com.cooksys.server.DTOs.CompanyEditRequestDTO;
import com.cooksys.server.DTOs.CompanyResponseDTO;
import com.cooksys.server.services.CompanyService;


import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("company")
@AllArgsConstructor

public class CompanyController {
	private CompanyService compServ;
	
	@GetMapping
	public List<CompanyResponseDTO> getAllCompanies(){
		return compServ.getAllCompanies();
	}
	
	@GetMapping("/{companyName}")
	@ResponseStatus(HttpStatus.OK)
	public CompanyResponseDTO getCompany(@PathVariable("companyName") String companyName) {
		return compServ.getCompany(companyName);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CompanyResponseDTO postCompany(@RequestBody CompanyCreateRequestDTO companyRequest) {
		return compServ.postCompany(companyRequest);
	}
	
	@PutMapping("/{companyName}")
	@ResponseStatus(HttpStatus.OK)
	public CompanyResponseDTO updateCompanyDescription(@PathVariable("companyName") String companyName, @RequestBody CompanyEditRequestDTO companyUpdate) {
		return compServ.updateCompanyDescription(companyName, companyUpdate);
	}
	
	
}
