package com.cooksys.server.DTOs;

import java.util.List;

import com.cooksys.server.entities.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoleDTO {
	private List<User> users;
	
	private String roleTitle;
}
