package com.cesi.ressourcesrelationnelles.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService implements UserDetailsService {

	private final UserInMemoryRepository repository;
	
	@Autowired
	public CurrentUserService(UserInMemoryRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final CurrentUser currentUser = repository.findUserByName(username);
		if (currentUser == null) {
			throw new UsernameNotFoundException("User not found by name : " + username);
		}
		
		return currentUser;
	}

}
