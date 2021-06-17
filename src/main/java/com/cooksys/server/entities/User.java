package com.cooksys.server.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String userName;

	private String firstName;

	private String lastName;

	private String password;
	
	private boolean newUser = true;

	@CreationTimestamp

	private final Timestamp created = new Timestamp(System.currentTimeMillis());

	@UpdateTimestamp
	private Timestamp updated;

	@Column(nullable = false)
	private Boolean isDeleted = false;

	@ManyToOne
	private Team associatedTeam;

	@OneToOne
	private User updatedBy;

	@ManyToOne
	private Company userCompany;

	@OneToMany(mappedBy = "user")
	private List<Project> projects = new ArrayList<>();

	@ManyToOne
	private Role userRole;

	@Override
	public String toString() {
		String retString = String.format("id %d userName %s isDeleted %b firstName %s lastName %s", id, userName,
				isDeleted, firstName, lastName);
		retString += associatedTeam != null ? "\n" + associatedTeam.toString() : "";
		retString += userCompany != null ? "\n" + userCompany.toString() : "";
		return retString;

	}

	/*
	 * equals() compares the database entries by id and the objects in memory in
	 * Java
	 */
	@Override
	public boolean equals(Object obj) {

		// check null and class
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}

		// compare pointers
		if (obj == this) {
			return true;
		}

		// compare id's
		return ((User) obj).getId() == this.getId();
	}

	@Override
	public int hashCode() {
		/*
		 * Simplified hash. Use id field instead of username, since username can change
		 * in the database.
		 */
		return Objects.hash(this.id);
	}

}
