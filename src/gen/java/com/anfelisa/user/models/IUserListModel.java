package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=UserListModel.class)
public interface IUserListModel {

	java.util.List<com.anfelisa.user.models.IUserModel> getUserList();
	void setUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList);
	
	String getRole();
	void setRole(String role);
	
	
	List<String> equalsPrimitiveTypes(IUserListModel other);
	
}

/*       S.D.G.       */
