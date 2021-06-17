package com.cooksys.server.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.server.DTOs.TeamDTO;
import com.cooksys.server.DTOs.TeamResponseDTO;
import com.cooksys.server.entities.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper {
	Team DTOtoEntity(TeamDTO teamDTO);
	
	TeamResponseDTO EntityToDto(Team team);

	List<TeamResponseDTO> entitesToResponseDTO(List<Team> getAllTeams);
}
