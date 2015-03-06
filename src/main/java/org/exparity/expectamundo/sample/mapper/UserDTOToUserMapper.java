package org.exparity.expectamundo.sample.mapper;

public class UserDTOToUserMapper {

	public User map(final UserDTO userDTO) {
		return new User(userDTO.getUsername(), userDTO.getFirstName(), userDTO.getSurname(), userDTO.getDateOfBirth());
	}
}
