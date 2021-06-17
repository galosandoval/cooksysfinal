package com.cooksys.server.mappers;

import org.mapstruct.Mapper;

import com.cooksys.server.DTOs.RoleDTO;
import com.cooksys.server.entities.Role;


@Mapper(componentModel = "spring")
public interface RoleMapper {
	Role DTOtoEntity(RoleDTO roleDTO);
}
