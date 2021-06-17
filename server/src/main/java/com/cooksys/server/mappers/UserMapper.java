package com.cooksys.server.mappers;
import java.util.List;

import org.mapstruct.Mapper;
import com.cooksys.server.DTOs.CompanyResponseUserDTO;
import com.cooksys.server.DTOs.UserDTO;
import com.cooksys.server.DTOs.UserResponseDTO;
import com.cooksys.server.DTOs.UserSignInRequestDTO;
import com.cooksys.server.entities.User;


@Mapper(componentModel = "spring")
public interface UserMapper {	
	CompanyResponseUserDTO EntityToCompanyResponseUserDTO(User user);
	
	User DTOtoEntity(UserDTO userDTO);
	
	UserResponseDTO EntityToDTO(User user);
	
	List<UserResponseDTO> EntitiesToDTO(List<User> users);

	User UserSignInDTOtoEntity(UserSignInRequestDTO userSignInRequestDTO);
}
