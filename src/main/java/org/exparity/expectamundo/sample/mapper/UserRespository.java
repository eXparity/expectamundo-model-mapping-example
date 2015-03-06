package org.exparity.expectamundo.sample.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRespository {

	private Map<String,User> userMap = new HashMap<>();
	
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
