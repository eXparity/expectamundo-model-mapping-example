package org.exparity.expectamundo.sample.mapper;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.exparity.dates.en.FluentDate.AUG;
import static org.exparity.expectamundo.Expectamundo.expect;
import static org.exparity.expectamundo.Expectamundo.expectThat;
import static org.exparity.expectamundo.Expectamundo.prototype;

public class UserRepositoryTest {

	private static String FIRST_NAME = "John", SURNAME = "Smith", USERNAME = "JohnSmith";
	private static Date DATE_OF_BIRTH = AUG(9, 1975);
	private static User EXPECTED_USER;
	static {
		EXPECTED_USER = prototype(User.class);
		expect(EXPECTED_USER.getCreateTs()).isWithin(1, TimeUnit.SECONDS, new Date());
		expect(EXPECTED_USER.getFirstName()).isEqualTo(FIRST_NAME);
		expect(EXPECTED_USER.getSurname()).isEqualTo(SURNAME);
		expect(EXPECTED_USER.getUsername()).isEqualTo(USERNAME);
		expect(EXPECTED_USER.getUserId()).isNull();
		expect(EXPECTED_USER.getDateOfBirth()).isComparableTo(DATE_OF_BIRTH);
	}

	@Test
	public void canGetAll() {
		User user = new User(USERNAME, FIRST_NAME, SURNAME, DATE_OF_BIRTH);
		UserRespository repos = new UserRespository();
		repos.addUser(user);
		expectThat(repos.getAll()).contains(EXPECTED_USER);
	}

	@Test
	public void canGetByUsername() {
		User user = new User(USERNAME, FIRST_NAME, SURNAME, DATE_OF_BIRTH);
		UserRespository repos = new UserRespository();
		repos.addUser(user);
		expectThat(repos.getUserByUsername(USERNAME)).matches(EXPECTED_USER);
	}
}