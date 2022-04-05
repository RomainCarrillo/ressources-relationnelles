package com.cesi.ressourcesrelationnelles.security.session;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * Used to store sessions in the application memory
 * might be replace with databse session storage
 * 
 * @author rcarr
 *
 */

@Component
public class InMemorySessionRegistry {

	private static final HashMap<String, String> SESSIONS = new HashMap<>();
	
	public String registerSession(final String username) {
		if (username == null) {
			throw new RuntimeException("User name note provided");
		}
		final String sessionId = generateSessionId();
		SESSIONS.put(sessionId, username);
		return sessionId;
	}
	
	public String getUsernameForSession(final String sessionId) {
		return SESSIONS.get(sessionId);
	}
	
	private String generateSessionId() {
		return new String(
				Base64.getEncoder().encode(
						UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)
						)
				);
	}
	
}
