package org.exparity.expectamundo.sample.mapper;

import java.util.Date;

public class UserDTO {

	private String username, firstName, surname;
	private Date dateOfBirth;

	public UserDTO(String username, String firstName, String surname, Date dateOfBirth) {
		this.username = username;
		this.firstName = firstName;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

}
