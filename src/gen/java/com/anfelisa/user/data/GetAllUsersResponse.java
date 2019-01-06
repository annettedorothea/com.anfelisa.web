package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetAllUsersResponse implements IGetAllUsersResponse {
	
	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	
	public GetAllUsersResponse(com.anfelisa.user.models.IUserListModel data) {
		userList = data.getUserList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.user.models.IUserModel> getUserList() {
		return this.userList;
	}
	
}

/*       S.D.G.       */