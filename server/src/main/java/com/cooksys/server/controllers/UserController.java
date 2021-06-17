package com.cooksys.server.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.cooksys.server.DTOs.UserCreateRequestDTO;
import com.cooksys.server.DTOs.UserEditRequestDTO;
import com.cooksys.server.DTOs.UserRequestAssignCompanyDTO;
import com.cooksys.server.DTOs.UserRequestAssignProjectDTO;
import com.cooksys.server.DTOs.UserRequestAssignRoleDTO;
import com.cooksys.server.DTOs.UserRequestAssignTeamDTO;
import com.cooksys.server.DTOs.UserResponseDTO;
import com.cooksys.server.DTOs.UserSignInRequestDTO;
import com.cooksys.server.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
	private UserService userServ;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserResponseDTO> getAllUsers() {
		return userServ.getAllUsers();
	}
	
	@GetMapping("/{username}")
	@ResponseStatus(HttpStatus.OK)
	public UserResponseDTO getUser(@PathVariable("username") String userName) {
		return userServ.getUser(userName);
	}

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public UserResponseDTO loginUser(@RequestBody UserSignInRequestDTO userRequest) {
		return userServ.login(userRequest);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponseDTO createUser(@RequestBody UserCreateRequestDTO userRequest) {
		return userServ.postUser(userRequest);
	}
	
	@PatchMapping("/{username}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserResponseDTO updateUser(@PathVariable("username") String userName, @RequestBody UserEditRequestDTO userRequest) {
		return userServ.patchUser(userName,userRequest);
	}
	
	@PatchMapping("/{username}/role")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserResponseDTO patchUserRole(@PathVariable("username") String userName, @RequestBody UserRequestAssignRoleDTO userRequest) {
		return userServ.assignUserRole(userName,userRequest);
	}
	
	@PatchMapping("/{username}/project")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserResponseDTO assignUserProj(@PathVariable("username") String userName, @RequestBody UserRequestAssignProjectDTO userRequest) {
		return userServ.assignProject(userName, userRequest);
	}
	
	@PatchMapping("/{username}/company")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserResponseDTO assignUserCompany(@PathVariable("username") String userName, @RequestBody UserRequestAssignCompanyDTO userRequest) {
		return userServ.assignCompany(userName, userRequest);
	}
	
	@PatchMapping("/{username}/team")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserResponseDTO assignUserTeam(@PathVariable("username") String userName, @RequestBody UserRequestAssignTeamDTO userRequest) {
		return userServ.assignTeam(userName, userRequest);
	}
	
	@DeleteMapping("/{username}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserResponseDTO deleteUser(@PathVariable("username") String userName, @RequestBody UserSignInRequestDTO userRequest) {
		return userServ.deleteUser(userName, userRequest);
	}
}
