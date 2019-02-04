package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=UserWithAccessListModel.class)
public interface IUserWithAccessListModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList();
	void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList);
	
	
	List<String> equalsPrimitiveTypes(IUserWithAccessListModel other);
	
}

/*       S.D.G.       */
