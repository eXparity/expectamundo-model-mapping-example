package org.exparity.expectamundo.sample.mapper;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.exparity.dates.en.FluentDate.AUG;
import static org.exparity.expectamundo.Expectamundo.*;
import static org.exparity.hamcrest.date.Moments.now;

public class UserDTOToUserMapperTest {

	@Test
	public void canMapUserDTOToUser() {

		UserDTO dto = new UserDTO("JohnSmith", "John", "Smith", AUG(9, 1975));
		User actual = new UserDTOToUserMapper().map(dto);

		User expected = prototype(User.class);
		expect(expected.getCreateTs()).isWithin(1, TimeUnit.SECONDS, now());
		expect(expected.getFirstName()).isEqualTo("John");
		expect(expected.getSurname()).isEqualTo("Smith");
		expect(expected.getUsername()).isEqualTo("JohnSmith");
		expect(expected.getUserId()).isNull();
		expect(expected.getDateOfBirth()).isSameDay(AUG(9, 1975));
		expectThat(actual).matches(expected);
	}
}
