package com.anfelisa.auth;

import java.security.Principal;

public class AuthUser implements Principal {

	private String userId;
	
	private String username;
	
	private String password;
	
	private String role;
	

	public AuthUser (
		String userId,
		String username,
		String password,
		String role
	) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUserId() {
		return this.userId;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getName() {
		return "AuthUser";
	}
}

/*       S.D.G.       */