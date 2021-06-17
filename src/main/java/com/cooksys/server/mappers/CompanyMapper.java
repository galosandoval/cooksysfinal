package com.cooksys.server.mappers;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.server.DTOs.CompanyDTO;
import com.cooksys.server.DTOs.CompanyResponseDTO;
import com.cooksys.server.DTOs.CompanyResponseFilterUsersDTO;
import com.cooksys.server.entities.Company;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
	@BeanMapping(qualifiedByName = "Filter")
	CompanyResponseDTO entityToResponseDTO(Company company);
	//This filters users so that CompanyResponseDTO only contains users that aren't
	//assigned to a team in its "users" json property. All other users that are assigned
	//to a team will be seen under the "teams" json property
	@Named("Filter")
	@AfterMapping
	default void filterUsers(@MappingTarget CompanyResponseDTO companyResponseDTO) {
		List<CompanyResponseFilterUsersDTO> filterUsers = new ArrayList<>();
		for(CompanyResponseFilterUsersDTO user: companyResponseDTO.getUsers()) {
			if(user.getAssociatedTeam() == null) {
				filterUsers.add(user);
			}
		}
		companyResponseDTO.setUsers(filterUsers);
	}
	
	Company CompanyDTOtoEntity(CompanyDTO companyDTO);
	
	List<CompanyResponseDTO> entitiesToResponseDTOs(List<Company> companies);
}
