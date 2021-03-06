/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

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
public class GetInvitedUsersResponse implements IGetInvitedUsersResponse {
	
	private java.util.List<String> invitedUsernames;
	
	public GetInvitedUsersResponse() {
	}
	
	public GetInvitedUsersResponse(com.anfelisa.category.models.IAlreadyInvitedUsernamesModel data) {
		invitedUsernames = data.getInvitedUsernames();
	}
	
	@JsonProperty
	public java.util.List<String> getInvitedUsernames() {
		return this.invitedUsernames;
	}
	
}



/******* S.D.G. *******/



