
package org.exparity.expectamundo.sample.mapper;

import java.util.*;

public class UserRepository {

	private Map<String, User> userMap = new HashMap<>();

	public List<User> getAll() {
		return new ArrayList<>(userMap.values());
	}

	public void addUser(final User user) {
		this.userMap.put(user.getUsername(), user);
	}

	public User getUserByUsername(final String username) {
		return userMap.get(username);
	}

}
