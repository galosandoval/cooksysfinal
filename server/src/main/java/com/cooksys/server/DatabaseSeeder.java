package com.cooksys.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cooksys.server.entities.Company;
import com.cooksys.server.entities.Project;
import com.cooksys.server.entities.Role;
import com.cooksys.server.entities.Team;
import com.cooksys.server.entities.User;
import com.cooksys.server.repositories.CompanyRepository;
import com.cooksys.server.repositories.ProjectRepository;
import com.cooksys.server.repositories.RoleRepository;
import com.cooksys.server.repositories.TeamRepository;
import com.cooksys.server.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {
	private CompanyRepository companyRepo;
	private TeamRepository teamRepo;
	private UserRepository userRepo;
	private ProjectRepository projectRepo;
	private RoleRepository roleRepo;

	@Override
	public void run(String... args) throws Exception {
		//-------------TODO: These Roles MUST be seeded (not only in testing).-------------------------//
		//I'm curious to know how permissions are generally, algorithmically dealt with
		Role worker = new Role();
		worker.setRoleTitle("Member");
		Role comp = new Role();

		comp.setRoleTitle("Company");
		//---------------------------------------------------------------------------------------------//
		roleRepo.saveAndFlush(worker);
		roleRepo.saveAndFlush(comp);
		
		Company dunderMifflin = new Company();
		dunderMifflin.setCompanyName("Dunder Mifflin");
		dunderMifflin.setCompanyDescription("Paper and paper accessories.");

		Company krustyKrab = new Company();
		krustyKrab.setCompanyName("Krusty Krab");
		krustyKrab.setCompanyDescription("The squeaking of the horrible boots!");

		companyRepo.saveAndFlush(dunderMifflin);
		companyRepo.saveAndFlush(krustyKrab);

		Team salesTeam = new Team();
		Team accountingTeam = new Team();

		salesTeam.setParentCompany(dunderMifflin);
		salesTeam.setTeamName("Sales");
		salesTeam.setTeamDescription("Sell products to Clients.");

		accountingTeam.setParentCompany(dunderMifflin);
		accountingTeam.setTeamName("Accounting");
		accountingTeam.setTeamDescription("Crunch the numbers.");

		Team kitchen = new Team();
		Team cashier = new Team();

		kitchen.setParentCompany(krustyKrab);
		kitchen.setTeamName("Kitchen Staff");
		kitchen.setTeamDescription("How the Sausage is made.");

		cashier.setParentCompany(krustyKrab);
		cashier.setTeamName("Service Staff");
		cashier.setTeamDescription("Customer Service");
		
		Team deletedTeam = new Team();
		
		deletedTeam.setParentCompany(dunderMifflin);
		deletedTeam.setTeamName("Crossfit");
		deletedTeam.setTeamDescription("Pain.");
		deletedTeam.setIsDeleted(true);
		
		Team deletedTeam2 = new Team();
		
		deletedTeam2.setParentCompany(dunderMifflin);
		deletedTeam2.setTeamName("TeamA");
		deletedTeam2.setTeamDescription("TeamA description");
		deletedTeam2.setIsDeleted(true);

		teamRepo.saveAndFlush(salesTeam);
		teamRepo.saveAndFlush(accountingTeam);
		teamRepo.saveAndFlush(kitchen);
		teamRepo.saveAndFlush(cashier);
		teamRepo.saveAndFlush(deletedTeam);
		teamRepo.saveAndFlush(deletedTeam2);

		User Jim = new User();
		Jim.setFirstName("Jim");
		Jim.setLastName("Halpert");
		Jim.setPassword("Pranks");
		Jim.setAssociatedTeam(salesTeam);
		Jim.setUserRole(worker);
		Jim.setUserName("Loki");
		Jim.setNewUser(false);
		Jim.setUserCompany(dunderMifflin);

		User Dwight = new User();
		Dwight.setFirstName("Dwight");
		Dwight.setLastName("Schrute");
		Dwight.setPassword("Beets");
		Dwight.setAssociatedTeam(salesTeam);
		Dwight.setUserRole(worker);
		Dwight.setUserName("Darth Shrewt");
		Dwight.setNewUser(false);
		Dwight.setUserCompany(dunderMifflin);

		User Stanley = new User();
		Stanley.setFirstName("Stanley");
		Stanley.setLastName("Hudson");
		Stanley.setPassword("Money");
		Stanley.setAssociatedTeam(accountingTeam);
		Stanley.setUserRole(worker);
		Stanley.setUserName("Stanley0689");
		Stanley.setIsDeleted(true);
		Stanley.setNewUser(false);
		Stanley.setUserCompany(dunderMifflin);

		User Ryan = new User();
		Ryan.setFirstName("Ryan");
		Ryan.setLastName("Howard");
		Ryan.setPassword("Temp");
		Ryan.setAssociatedTeam(accountingTeam);
		Ryan.setUserRole(worker);
		Ryan.setUserName("Wunderkind");
		Ryan.setIsDeleted(true);
		Ryan.setNewUser(false);
		Ryan.setUserCompany(dunderMifflin);

		User spongeBob = new User();
		spongeBob.setFirstName("Spongebob");
		spongeBob.setLastName("Squarepants");
		spongeBob.setPassword("Gary");
		spongeBob.setAssociatedTeam(kitchen);
		spongeBob.setUserRole(worker);
		spongeBob.setUserName("The Quickster");
		spongeBob.setNewUser(false);
		spongeBob.setUserCompany(krustyKrab);

		User squidWard = new User();
		squidWard.setFirstName("Squidward");
		squidWard.setLastName("Tentacles");
		squidWard.setPassword("Clarinet");
		squidWard.setAssociatedTeam(cashier);
		squidWard.setUserRole(worker);
		squidWard.setUserName("Captain Magma");
		squidWard.setNewUser(false);
		squidWard.setUserCompany(krustyKrab);
		
		User Pearl = new User();
		Pearl.setFirstName("Pearl");
		Pearl.setLastName("Whale");
		Pearl.setPassword("Sugar");
		Pearl.setUserCompany(krustyKrab);
		Pearl.setUserRole(comp);
		Pearl.setUserName("GD");
		Pearl.setIsDeleted(true);
		Pearl.setNewUser(false);
		Pearl.setUserCompany(krustyKrab);

		User mrKrabbs = new User();
		mrKrabbs.setFirstName("Mr.");
		mrKrabbs.setLastName("Krabbs");
		mrKrabbs.setPassword("Money");
		mrKrabbs.setUserRole(comp);
		mrKrabbs.setUserCompany(krustyKrab);
		mrKrabbs.setUserName("JP Lobster");
		mrKrabbs.setNewUser(false);
		mrKrabbs.setUserCompany(krustyKrab);

		User michael = new User();
		michael.setFirstName("Michael");
		michael.setLastName("Scott");
		michael.setPassword("Friendship");
		michael.setUserRole(comp);
		michael.setUserCompany(dunderMifflin);
		michael.setUserName("Michael Scarn");
		michael.setNewUser(false);
		michael.setUserCompany(dunderMifflin);
		
		User kelly = new User();
		kelly.setFirstName("kelly");
		kelly.setLastName("Whoof");
		kelly.setPassword("OMG");
		kelly.setUserCompany(dunderMifflin);
		kelly.setUserName("Kgurl");
		kelly.setNewUser(true);
		kelly.setUserCompany(dunderMifflin);
		
		User will = new User();
		will.setFirstName("Will");
		will.setLastName("Ferrill");
		will.setPassword("Elf");
		will.setUserCompany(dunderMifflin);
		will.setNewUser(true);
		will.setUserName("StepBro");

		userRepo.saveAndFlush(mrKrabbs);
		userRepo.saveAndFlush(michael);
		userRepo.saveAndFlush(Jim);
		userRepo.saveAndFlush(Dwight);
		userRepo.saveAndFlush(Stanley);
		userRepo.saveAndFlush(Ryan);
		userRepo.saveAndFlush(spongeBob);
		userRepo.saveAndFlush(squidWard);
		userRepo.saveAndFlush(Pearl);
		userRepo.saveAndFlush(kelly);
		userRepo.saveAndFlush(will);

		Project manageKrustyKrab = new Project();
		manageKrustyKrab.setUser(mrKrabbs);
		manageKrustyKrab.setName("Count ma money!");
		manageKrustyKrab.setDescription("Stop the squeaking of horrible boots!");

		Project managedunderMifflin = new Project();
		managedunderMifflin.setUser(michael);
		managedunderMifflin.setName("Make Friends, Don't die alone.");
		managedunderMifflin.setDescription("Make more 'thats what she said' jokes.");

		Project sellPaper = new Project();
		sellPaper.setUser(michael);
		sellPaper.setTeam(salesTeam);
		sellPaper.setName("Sell Paper");
		sellPaper.setDescription("Without watermarks.");

		Project crunchNumbers = new Project();
		crunchNumbers.setUser(michael);
		crunchNumbers.setTeam(accountingTeam);
		crunchNumbers.setName("Count Paper");
		crunchNumbers.setDescription("At least the sales team can get away from Michael.");

		Project prankDwight = new Project();
		prankDwight.setUser(Jim);
		prankDwight.setUser(Jim);
		prankDwight.setName("Prank Dwight.");
		prankDwight.setDescription("Bears, Beets, BattleStar Galactica.");

		Project flipBurgers = new Project();
		flipBurgers.setUser(mrKrabbs);
		flipBurgers.setTeam(kitchen);
		flipBurgers.setName("The perfect burger.");
		flipBurgers.setDescription("Imagination!");

		Project serviceCust = new Project();
		serviceCust.setUser(mrKrabbs);;
		serviceCust.setTeam(cashier);
		serviceCust.setName("Endure.");
		serviceCust.setDescription("Envy SpongeBob.");

		Project yolo = new Project();
		yolo.setUser(spongeBob);
		yolo.setName("Living life like GOAT.");
		yolo.setDescription("Bring it around town!");
		
		Project testDelete = new Project();
		testDelete.setUser(michael);
		testDelete.setName("Have fun at the office.");
		testDelete.setDescription("Michael likes to have fun.");
		testDelete.setIsDeleted(true);

		projectRepo.saveAndFlush(manageKrustyKrab);
		projectRepo.saveAndFlush(managedunderMifflin);
		projectRepo.saveAndFlush(sellPaper);
		projectRepo.saveAndFlush(crunchNumbers);
		projectRepo.saveAndFlush(prankDwight);
		projectRepo.saveAndFlush(flipBurgers);
		projectRepo.saveAndFlush(serviceCust);
		projectRepo.saveAndFlush(yolo);
		projectRepo.saveAndFlush(testDelete);

	}

}