/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class UsernameAvailableModel implements IUsernameAvailableModel {

	private String username;

	private Boolean available = false;


	public UsernameAvailableModel() {
	}

	public UsernameAvailableModel(
		@JsonProperty("username") String username,
		@JsonProperty("available") Boolean available
	) {
		this.username = username;
		this.available = available;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	

}



/******* S.D.G. *******/



