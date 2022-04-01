package com.cesi.ressourcesrelationnelles.configuration;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * TEMPORARY CLASS MUST BE DELETED WHEN DATABASE CONNEXION WILL BE SETTED
 * 
 * @author rcarr
 *
 */

//TODO Delete when database is connected
@Component
public class UserInMemoryRepository {

	private static final HashMap<String, CurrentUser> REGISTRED_USERS = new HashMap<>(2);
	
	@PostConstruct
	private void setUpUsers() {
		REGISTRED_USERS.put("user", buildCurrentUser(
				"user",
				"user123"));
		REGISTRED_USERS.put("admin", buildCurrentUser(
				"admin",
				"admin123"));
	}
	
	
	public CurrentUser findUserByName(final String username) {
		return REGISTRED_USERS.get(username);
	}
	
	
	private CurrentUser buildCurrentUser(String username, String password) {
		final CurrentUser currentUser = new CurrentUser();
		currentUser.setUserName(username);
		currentUser.setPassword(password);
		
		return currentUser;
	}
	
}
