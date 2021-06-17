package com.cooksys.server.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.server.DTOs.UserCreateRequestDTO;
import com.cooksys.server.DTOs.UserEditRequestDTO;
import com.cooksys.server.DTOs.UserRequestAssignCompanyDTO;
import com.cooksys.server.DTOs.UserRequestAssignProjectDTO;
import com.cooksys.server.DTOs.UserRequestAssignRoleDTO;
import com.cooksys.server.DTOs.UserRequestAssignTeamDTO;
import com.cooksys.server.DTOs.UserResponseDTO;
import com.cooksys.server.DTOs.UserSignInRequestDTO;
import com.cooksys.server.entities.Company;
import com.cooksys.server.entities.Project;
import com.cooksys.server.entities.Role;
import com.cooksys.server.entities.Team;
import com.cooksys.server.entities.User;
import com.cooksys.server.exceptions.ImUsedException;
import com.cooksys.server.exceptions.NotFoundException;
import com.cooksys.server.mappers.UserMapper;
import com.cooksys.server.repositories.CompanyRepository;
import com.cooksys.server.repositories.ProjectRepository;
import com.cooksys.server.repositories.RoleRepository;
import com.cooksys.server.repositories.TeamRepository;
import com.cooksys.server.repositories.UserRepository;
import com.cooksys.server.services.UserService;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	private UserRepository userRepo;
	private TeamRepository teamRepo;
	private CompanyRepository companyRepo;
	private ProjectRepository projectRepo;
	private RoleRepository roleRepo;

	private UserMapper userMap;

	/*
	 * GET User if user doesn't exist or is deleted, throw exception
	 */
	@Override
	public UserResponseDTO getUser(String userName) {
		Optional<User> findUser = userRepo.findByUserName(userName);
		Utils.validateUserExistsAndNotDeleted(findUser,userName);
		return userMap.EntityToDTO(findUser.get());
	}

	/*
	 * POST (Create User)
	 * if user entity has been deleted, reactivate and return
	 * if username exists, throw exception
	 * if user role exists, set that user's role, else set to null
	 */
	@Override
	public UserResponseDTO postUser(UserCreateRequestDTO userRequest) {
		Optional<User> findUser = userRepo.findByUserName(userRequest.getCreateUser().getUserName());
		if (findUser.isPresent()) {
			if (findUser.get().getIsDeleted()) {
				findUser.get().setIsDeleted(false);
				return userMap.EntityToDTO(userRepo.saveAndFlush(findUser.get()));
			}
			throw new ImUsedException(String.format("User name: '%s' is taken.", findUser.get().getUserName()));
		}

		User createUser = userMap.DTOtoEntity(userRequest.getCreateUser());
		Optional<Company> findCompany = companyRepo.findByCompanyName(userRequest.getCompanyName());
		if (findCompany.isPresent()) {
			createUser.setUserCompany(findCompany.get());
		} else {
			throw new NotFoundException(String.format("Company name: '%s' does not exist.", findUser.get().getUserName()));
		}
		//This below is bad code (by me, nathan). It means we have to populate database with this role.
		//I'm not sure if we can default the Role assignment because it is an entity itself
		Optional<Role> findRole = roleRepo.findByroleTitle("Member");
		if(findRole.isEmpty()) {
			throw new NotFoundException(String.format("Role name: '%s' does not exist.", findUser.get().getUserName()));
		}
		createUser.setUserRole(findRole.get());
		createUser.setUpdated(new Timestamp(System.currentTimeMillis()));
		createUser = userRepo.saveAndFlush(createUser);
		createUser.setUpdatedBy(createUser);
		createUser = userRepo.saveAndFlush(createUser);
		return userMap.EntityToDTO(createUser);
	}

	/*
	 * PATCH User (edit user info) - only a user can edit their own info
	 * a user can only edit certain information (they can not add themselves to a team, or project)
	 * if user does not exist OR deleted throw exception
	 * if user credentials do not match throw exception
	 * set fields
	 */
	@Override
	public UserResponseDTO patchUser(String userName, UserEditRequestDTO userRequest) {
		Optional<User> findUser = userRepo.findByUserName(userName);
		Utils.validateUserExistsAndNotDeleted(findUser,userName);
		Utils.validateCredentials(findUser,userRequest.getCredentials().getUserName(),userRequest.getCredentials().getPassword());
		User user = findUser.get();
		
		if(userRequest.getNewData().getUserName() != null) {
			user.setUserName(userRequest.getNewData().getUserName());
		}
		if(userRequest.getNewData().getFirstName() != null) {
			user.setFirstName(userRequest.getNewData().getFirstName());
		}
		if(userRequest.getNewData().getLastName() != null) {
			user.setLastName(userRequest.getNewData().getLastName());
		}
		if(userRequest.getNewData().getPassword() != null) {
			user.setPassword(userRequest.getNewData().getPassword());
		}
		user.setNewUser(findUser.get().isNewUser());
		user.setUpdated(new Timestamp(System.currentTimeMillis()));
		user.setUpdatedBy(user);

		return userMap.EntityToDTO(userRepo.saveAndFlush(user));
	}

	/* 
	 * if user not found or deleted throw exception
	 * if user is a new user throw exception
	 * if boss not found or deleted throw exception
	 * if boss is a new user throw exception
	 * if boss is not of company role throw exception
	 * verify boss's credentials
	 * if project exists, set project's user property to this user
	 * else throw exception
	 */
	@Override
	public UserResponseDTO assignProject(String userName, UserRequestAssignProjectDTO userRequest) {
		Optional<User> findUser = userRepo.findByUserName(userName);	
		Optional<User> findBoss = userRepo.findByUserName(userRequest.getCredentials().getUserName());
		Utils.validateUserExistsAndNotDeleted(findUser,userName);
		Utils.validateNewUser(findUser);
		Utils.validateUserExistsAndNotDeleted(findBoss,userRequest.getCredentials().getUserName());
		Utils.validateNewUser(findBoss);
		Utils.validateAuthorization(findBoss, userRequest.getCredentials().getUserName());
		Utils.validateCredentials(findBoss,userRequest.getCredentials().getUserName(),userRequest.getCredentials().getPassword());
		Utils.validateBossIsSameCompanyAsUser(findBoss,findUser);
		
		Optional<Project> findProject = projectRepo.findByName(userRequest.getProjectName());
		if(findProject.isPresent() && findProject.get().getIsDeleted() != true) {
			findProject.get().setUser(findUser.get());
			findProject.get().setUpdated(new Timestamp(System.currentTimeMillis()));
			findProject.get().setUpdatedBy(findBoss.get());
			projectRepo.saveAndFlush(findProject.get());
		}else {
			throw new NotFoundException(String.format("Project with name: '%s' not found or deleted.", userRequest.getProjectName()));
		}
		findUser = userRepo.findByUserName(userName);
		return userMap.EntityToDTO(findUser.get());
	}

	/*
	 * if user not found or deleted throw exception
	 * if user is a new user throw exception
	 * if boss not found or deleted throw exception
	 * if boss is a new user throw exception
	 * if boss is not of company role throw exception
	 * verify boss's credentials
	 * if company exists, add user to company's list of users
	 * else throw exception
	 */
	@Override
	public UserResponseDTO assignCompany(String userName, UserRequestAssignCompanyDTO userRequest) {
		Optional<User> findUser = userRepo.findByUserName(userName);	
		Optional<User> findBoss = userRepo.findByUserName(userRequest.getCredentials().getUserName());
		Utils.validateUserExistsAndNotDeleted(findUser,userName);
		Utils.validateNewUser(findUser);
		Utils.validateUserExistsAndNotDeleted(findBoss,userRequest.getCredentials().getUserName());
		Utils.validateNewUser(findBoss);
		Utils.validateAuthorization(findBoss, userRequest.getCredentials().getUserName());
		Utils.validateCredentials(findBoss,userRequest.getCredentials().getUserName(),userRequest.getCredentials().getPassword());

		Optional<Company> findCompany = companyRepo.findByCompanyName(userRequest.getCompanyName());
		if(findCompany.isPresent()) {
			findUser.get().setUserCompany(findCompany.get());
			findUser.get().setUpdated(new Timestamp(System.currentTimeMillis()));
			findUser.get().setUpdatedBy(findBoss.get());
			userRepo.saveAndFlush(findUser.get());
		}else {
			throw new NotFoundException(String.format("Company with name: '%s' not found.", userRequest.getCompanyName()));
		}
		return userMap.EntityToDTO(userRepo.saveAndFlush(findUser.get()));
	}

	/* if user not found or deleted throw exception
	 * if user is a new user throw exception
	 * if boss not found or deleted throw exception
	 * if boss is a new user throw exception
	 * if boss is not of company role throw exception
	 * verify boss's credentials
	 * if team exists, set user's team to this team
	 * else throw exception
	 */
	@Override
	public UserResponseDTO assignTeam(String userName, UserRequestAssignTeamDTO userRequest) {
		Optional<User> findUser = userRepo.findByUserName(userName);	
		Optional<User> findBoss = userRepo.findByUserName(userRequest.getCredentials().getUserName());
		Utils.validateUserExistsAndNotDeleted(findUser,userName);
		Utils.validateNewUser(findUser);
		Utils.validateUserExistsAndNotDeleted(findBoss,userRequest.getCredentials().getUserName());
		Utils.validateNewUser(findBoss);
		Utils.validateAuthorization(findBoss, userRequest.getCredentials().getUserName());
		Utils.validateCredentials(findBoss,userRequest.getCredentials().getUserName(),userRequest.getCredentials().getPassword());
		Utils.validateBossIsSameCompanyAsUser(findBoss,findUser);

		Optional<Team> findTeam = teamRepo.findByTeamNameIgnoreCase(userRequest.getTeamName());
		if(findTeam.isPresent() && findTeam.get().getIsDeleted() != true) {
			findUser.get().setAssociatedTeam(findTeam.get());
			findUser.get().setUpdated(new Timestamp(System.currentTimeMillis()));
			findUser.get().setUpdatedBy(findBoss.get());
			userRepo.saveAndFlush(findUser.get());
		}else {
			throw new NotFoundException(String.format("Team with name: '%s' not found or deleted.", userRequest.getTeamName()));
		}
		return userMap.EntityToDTO(userRepo.saveAndFlush(findUser.get()));
	}
	
	/*
	 * if user doesn't exist or is deleted throw exception
	 * validate credentials
	 * delete user (only a user can delete himself)
	 */
	@Override
	public UserResponseDTO deleteUser(String userName, UserSignInRequestDTO userRequest) {
		Optional<User> findUser = userRepo.findByUserName(userName);
		Utils.validateUserExistsAndNotDeleted(findUser,userName);
		Utils.validateCredentials(findUser,userRequest.getUserName(),userRequest.getPassword());

		findUser.get().setIsDeleted(true);
		findUser.get().setUpdated(new Timestamp(System.currentTimeMillis()));
		findUser.get().setUpdatedBy(findUser.get());
		userRepo.saveAndFlush(findUser.get());
		return userMap.EntityToDTO(findUser.get());
	}
/*
 * if user doesn't exist or is deleted throw exception
 * validate credentials
 */
	@Override
	public UserResponseDTO login(UserSignInRequestDTO userRequest) {
		Optional<User> findUser = userRepo.findByUserName(userRequest.getUserName());
		Utils.validateUserExistsAndNotDeleted(findUser,userRequest.getUserName());
		Utils.validateCredentials(findUser,userRequest.getUserName(),userRequest.getPassword());

		return userMap.EntityToDTO(findUser.get());
	}

	/*
	 * return all non deleted users
	 */
	@Override
	public List<UserResponseDTO> getAllUsers() {
		return userMap.EntitiesToDTO(userRepo.findByisDeletedFalse());
	}

	/*
	 * if user doesn't exist or is deleted throw exception
	 * if boss doesn't exist or is deleted throw exception
	 * if boss is a new user throw exception
	 * if boss doesn't have authorization throw exception
	 * if boss's credentials are incorrect throw exception
	 * if user role doesn't exist throw exception
	 */
	@Override
	public UserResponseDTO assignUserRole(String userName, UserRequestAssignRoleDTO userRequest) {
		Optional<User> findUser = userRepo.findByUserName(userName);	
		Optional<User> findBoss = userRepo.findByUserName(userRequest.getCredentials().getUserName());
		Utils.validateUserExistsAndNotDeleted(findUser,userName);
		Utils.validateUserExistsAndNotDeleted(findBoss,userRequest.getCredentials().getUserName());
		Utils.validateNewUser(findBoss);
		Utils.validateAuthorization(findBoss, userRequest.getCredentials().getUserName());
		Utils.validateCredentials(findBoss,userRequest.getCredentials().getUserName(),userRequest.getCredentials().getPassword());
		Utils.validateBossIsSameCompanyAsUser(findBoss,findUser);

		Optional<Role> findRole = roleRepo.findByroleTitle(userRequest.getRoleName());
		if(findRole.isPresent()) {
			findUser.get().setUserRole(findRole.get());
			findUser.get().setNewUser(false);
			findUser.get().setUpdated(new Timestamp(System.currentTimeMillis()));
			findUser.get().setUpdatedBy(findBoss.get());
			userRepo.saveAndFlush(findUser.get());
		}else {
			throw new NotFoundException(String.format("Role with name: '%s' not found.", userRequest.getRoleName()));
		}
		return userMap.EntityToDTO(findUser.get());
	}
}
