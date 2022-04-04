package com.cesi.ressourcesrelationnelles.security.user;

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
	
	//Les mots de passe doivent être stockés DEJA HASCHES avec bcrypt
	
	@PostConstruct
	private void setUpUsers() {
		REGISTRED_USERS.put("user", buildCurrentUser(
				"user",
				"$2a$10$4EvCE3wPMBPYEV/FA8B.3e1mrlCGaVuq.cO0x0fmrt198H61q/dFG")); //"user1"
		REGISTRED_USERS.put("admin", buildCurrentUser(
				"admin",
				"$2y$10$GB/cpo7FbfPrx5uVFjUnEeJrsk8drXtIFJaoCh3SapGcyuK3vOXyS")); //"admin"
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
