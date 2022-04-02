package com.cesi.ressourcesrelationnelles.security.configuration;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cesi.ressourcesrelationnelles.security.session.SessionFilter;
import com.cesi.ressourcesrelationnelles.security.user.CurrentUserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	private final CurrentUserService currentUserService;
	private final SessionFilter sessionFilter;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public SpringSecurityConfig(CurrentUserService currentUserService, SessionFilter sessionFilter,
			PasswordEncoder passwordEncoder) {
		super();
		this.currentUserService = currentUserService;
		this.sessionFilter = sessionFilter;
		this.passwordEncoder = passwordEncoder;
	}

	// Attention, l'ordre des méthode et des filtres est important

	// TODO replace in code users and admin informations with DB informations
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(currentUserService).passwordEncoder(passwordEncoder);
	}

	
	// TODO adapter le matcher patern pour mettre la bonne url de la page de connexion
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http = http.cors().and().csrf().disable();
		http = http.exceptionHandling().authenticationEntryPoint(
				(request, response, ex) -> {
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
				}
				).and();
		http.authorizeHttpRequests()
			.antMatchers("/api/login").permitAll()
			.anyRequest().authenticated();
		
		http.addFilterBefore(sessionFilter, UsernamePasswordAuthenticationFilter.class);	
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
