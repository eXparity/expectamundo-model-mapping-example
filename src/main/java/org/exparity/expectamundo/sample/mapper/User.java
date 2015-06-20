package org.exparity.expectamundo.sample.mapper;

import java.util.Date;

public class User {

	private Integer userId;
	private Date createTs = new Date();
	private String username, firstName, surname;
	private Date dateOfBirth;

	public User(final String username, final String firstName, final String surname, final Date dateOfBirth) {
		this.username = username;
		this.firstName = firstName;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(final Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTs() {
		return createTs;
	}

	public void setCreateTs(final Date createTs) {
		this.createTs = createTs;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(final Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
