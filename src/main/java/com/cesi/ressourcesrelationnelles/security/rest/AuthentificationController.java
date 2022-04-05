package com.cesi.ressourcesrelationnelles.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesi.ressourcesrelationnelles.security.dto.ResponseDTO;
import com.cesi.ressourcesrelationnelles.security.dto.UserDTO;
import com.cesi.ressourcesrelationnelles.security.session.InMemorySessionRegistry;

//TODO remplacer le endpoint  ?
@RestController
@RequestMapping("/api")
public class AuthentificationController {

	@Autowired
	public AuthenticationManager manager;
	
	@Autowired
	public InMemorySessionRegistry sessionRegistry;

	@PostMapping("/login")
	@CrossOrigin("http://localhost:4200/")
	public ResponseEntity<ResponseDTO> login(@RequestBody UserDTO user) {
		manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		final String sessionId = sessionRegistry.registerSession(user.getUsername());
		ResponseDTO response = new ResponseDTO();
		
		response.setSessionId(sessionId);
		
		return ResponseEntity.ok(response);
	}

}
