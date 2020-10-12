/********************************************************************************
 * generated by de.acegen 0.9.12
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class ForgotPasswordPayload implements IForgotPasswordPayload {
	
	private String username;
	
	private String language;
	
	public ForgotPasswordPayload() {
	}
	
	public ForgotPasswordPayload(com.anfelisa.user.models.IForgotPasswordModel data) {
		username = data.getUsername();
		language = data.getLanguage();
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	
}



/******* S.D.G. *******/



