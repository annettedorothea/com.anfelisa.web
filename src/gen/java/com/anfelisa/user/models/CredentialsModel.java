package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class CredentialsModel implements ICredentialsModel {

	@NotNull
	private String username;
	
	@NotNull
	private String role;
	

	public CredentialsModel(
		@JsonProperty("username") String username,
		@JsonProperty("role") String role
	) {
		this.username = username;
		this.role = role;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}

/*       S.D.G.       */
