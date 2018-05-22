package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;
import com.anfelisa.user.models.ILanguageModel;
import com.anfelisa.user.models.IEmailConfirmationModel;

@SuppressWarnings("all")
public class UserRegistrationPresentationalData implements IUserRegistrationPresentationalData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
	
	@NotNull
	private String role;
	
	@NotNull
	private Boolean emailConfirmed = false;
	
	@NotNull
	private String language;
	
	@NotNull
	private String token;
	
	
	public UserRegistrationPresentationalData(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed,
		@JsonProperty("language") String language,
		@JsonProperty("token") String token
	) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
		this.language = language;
		this.token = token;
		
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public UserRegistrationPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserRegistrationPresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRegistrationPresentationalData withPassword(String password) {
		this.password = password;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserRegistrationPresentationalData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserRegistrationPresentationalData withRole(String role) {
		this.role = role;
		return this;
	}
	
	@JsonProperty
	public Boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}
	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	public UserRegistrationPresentationalData withEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
		return this;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public UserRegistrationPresentationalData withLanguage(String language) {
		this.language = language;
		return this;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserRegistrationPresentationalData withToken(String token) {
		this.token = token;
		return this;
	}
	
}

/*       S.D.G.       */
