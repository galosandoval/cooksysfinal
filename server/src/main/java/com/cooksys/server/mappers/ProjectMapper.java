package com.cooksys.server.mappers;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.cooksys.server.DTOs.ProjectDTO;
import com.cooksys.server.DTOs.ProjectRequestDTO;
import com.cooksys.server.DTOs.ProjectResponseDTO;
import com.cooksys.server.entities.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
	
	ProjectDTO entityToDTO(Project project);
	
	Project DTOtoEntity(ProjectDTO projectDTO);

	Project requestDtoToEntity(ProjectRequestDTO projectRequestDTO);

	@Mappings({
		@Mapping(target="company", source="project.user.userCompany.companyName")
	})
	ProjectResponseDTO entityToResponseDTO(Project project);

	List<ProjectResponseDTO> entitiesToResponseDTOs(List<Project> projects);

}

