package com.cooksys.server.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
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
public class Company {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String companyName;

	private String companyDescription;

	@OneToMany(mappedBy = "parentCompany")
	private List<Team> teams = new ArrayList<>();

	//TODO: is this good coding? list of objects defaults to null, is it ideal to 
	//declare emptpy ArrayList as default? if so is their a better default collection?
	@OneToMany(mappedBy = "userCompany")
	private List<User> users = new ArrayList<>();

	@Override
	public String toString() {

		String retString = String.format("id %d company name %s descript %s", id, companyName, companyDescription);
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
		return ((Company) obj).getId() == this.getId();
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
