
package org.exparity.expectamundo.sample.mapper;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.exparity.dates.en.FluentDate.AUG;
import static org.exparity.hamcrest.date.DateMatchers.within;
import static org.exparity.hamcrest.date.Moments.now;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserDTOToUserMapperHamcrestTest {

	@Test
	public void canMapUserDTOToUser() {

		UserDTO dto = new UserDTO("JohnSmith", "John", "Smith", AUG(9, 1975));
		User actual = new UserDTOToUserMapper().map(dto);

		assertThat(actual.getCreateTs(), within(1, TimeUnit.SECONDS, now()));
		assertThat(actual.getFirstName(), equalTo("John"));
		assertThat(actual.getSurname(), equalTo("Smith"));
		assertThat(actual.getUsername(), equalTo("JohnSmith"));
		assertThat(actual.getUserId(), nullValue());
		assertThat(actual.getDateOfBirth(), comparesEqualTo(AUG(9, 1975)));
	}
}
