package com.cesi.ressourcesrelationnelles.security.session;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cesi.ressourcesrelationnelles.security.user.CurrentUser;
import com.cesi.ressourcesrelationnelles.security.user.CurrentUserService;

@Component
public class SessionFilter extends OncePerRequestFilter {

	private final InMemorySessionRegistry sessionRegistry;
	private final CurrentUserService currentUserService;

	public SessionFilter(final InMemorySessionRegistry sessionRegistry, final CurrentUserService currentUserService) {
		super();
		this.sessionRegistry = sessionRegistry;
		this.currentUserService = currentUserService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String sessionId = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (sessionId == null || sessionId.length() == 0) {
			filterChain.doFilter(request, response);
			return;
		}

		final String username = sessionRegistry.getUsernameForSession(sessionId);
		if (username == null) {
			filterChain.doFilter(request, response);
			return;
		}

		final CurrentUser currentUser = currentUserService.loadUserByUsername(username);

		final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				currentUser, null, currentUser.getAuthorities());
		
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		filterChain.doFilter(request, response);
	}

}
