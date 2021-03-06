
package org.exparity.expectamundo.sample.mapper;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.hamcrest.*;
import org.junit.Test;
import static org.exparity.dates.en.FluentDate.AUG;
import static org.exparity.hamcrest.BeanMatchers.hasProperty;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserRepositoryHamcrestTest {

	private static String FIRST_NAME = "John", SURNAME = "Smith", USERNAME = "JohnSmith";
	private static Date DATE_OF_BIRTH = AUG(9, 1975);

	private static final Matcher<User> EXPECTED_USER = Matchers.allOf(
			hasProperty("CreateTs", within(1, TimeUnit.SECONDS, new Date())),
			hasProperty("FirstName", equalTo(FIRST_NAME)),
			hasProperty("Surname", equalTo(SURNAME)),
			hasProperty("Username", equalTo(USERNAME)),
			hasProperty("UserId", nullValue()),
			hasProperty("DateOfBirth", sameDay(DATE_OF_BIRTH)));

	@Test
	public void canGetAll() {
		User user = new User(USERNAME, FIRST_NAME, SURNAME, DATE_OF_BIRTH);
		UserRepository repos = new UserRepository();
		repos.addUser(user);
		assertThat(repos.getAll(), hasItem(EXPECTED_USER));
	}

	@Test
	public void canGetByUsername() {
		User user = new User(USERNAME, FIRST_NAME, SURNAME, DATE_OF_BIRTH);
		UserRepository repos = new UserRepository();
		repos.addUser(user);
		assertThat(repos.getUserByUsername(USERNAME), is(EXPECTED_USER));
	}
}