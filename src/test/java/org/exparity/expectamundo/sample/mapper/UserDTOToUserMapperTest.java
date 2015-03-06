package org.exparity.expectamundo.sample.mapper;

import static org.exparity.dates.en.FluentDate.AUG;
import static org.exparity.expectamundo.Expectamundo.expect;
import static org.exparity.expectamundo.Expectamundo.expectThat;
import static org.exparity.expectamundo.Expectamundo.prototype;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class UserDTOToUserMapperTest {

	@Test
	public void canMapUserDTOToUser() {

		UserDTO dto = new UserDTO("JohnSmith", "John", "Smith", AUG(9, 1975));
		User actual = new UserDTOToUserMapper().map(dto);

		User expected = prototype(User.class);
		expect(expected.getCreateTs()).isWithin(1, TimeUnit.SECONDS, new Date());
		expect(expected.getFirstName()).isEqualTo("John");
		expect(expected.getSurname()).isEqualTo("Smith");
		expect(expected.getUsername()).isEqualTo("JohnSmith");
		expect(expected.getUserId()).isNull();
		expect(expected.getDateOfBirth()).isComparableTo(AUG(9, 1975));
		expectThat(actual).matches(expected);
	}
}
