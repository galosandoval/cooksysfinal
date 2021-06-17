package com.cooksys.server.services;

import java.util.List;

import com.cooksys.server.DTOs.UserCreateRequestDTO;
import com.cooksys.server.DTOs.UserEditRequestDTO;
import com.cooksys.server.DTOs.UserRequestAssignCompanyDTO;
import com.cooksys.server.DTOs.UserRequestAssignProjectDTO;
import com.cooksys.server.DTOs.UserRequestAssignRoleDTO;
import com.cooksys.server.DTOs.UserRequestAssignTeamDTO;
import com.cooksys.server.DTOs.UserResponseDTO;
import com.cooksys.server.DTOs.UserSignInRequestDTO;

public interface UserService {

	UserResponseDTO getUser(String userName);

	UserResponseDTO postUser(UserCreateRequestDTO userRequest);

	UserResponseDTO patchUser(String userName, UserEditRequestDTO userRequest);
	
	UserResponseDTO assignProject(String userName, UserRequestAssignProjectDTO userRequest);

	UserResponseDTO assignCompany(String userName, UserRequestAssignCompanyDTO userRequest);

	UserResponseDTO deleteUser(String userName, UserSignInRequestDTO userRequest);

	UserResponseDTO assignTeam(String userName, UserRequestAssignTeamDTO userRequest);

	UserResponseDTO login(UserSignInRequestDTO userRequest);

	List<UserResponseDTO> getAllUsers();

	UserResponseDTO assignUserRole(String userName, UserRequestAssignRoleDTO userRequest);
}
