package com.cooksys.server.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Role {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "userRole")
	private List<User> users = new ArrayList<>();

	private String roleTitle;

	@Override
	public String toString() {
		return (String.format("id %d roleTitle %s", id, roleTitle));
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
		return ((Role) obj).getId() == this.getId();
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
