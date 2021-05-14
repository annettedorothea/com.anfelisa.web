/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.IUserToCategoryInvitationModel;

@JsonDeserialize(as=UserToCategoryInvitationData.class)
public interface IUserToCategoryInvitationData extends IUserToCategoryInvitationModel, IDataContainer {
	
	IUserToCategoryInvitationData withCategoryId(String categoryId);
	
	IUserToCategoryInvitationData withUserId(String userId);
	
	IUserToCategoryInvitationData withInvitedUsername(String invitedUsername);
	
	IUserToCategoryInvitationData withInvitedUserId(String invitedUserId);
	
	IUserToCategoryInvitationData withBoxForInvitedUser(com.anfelisa.box.models.IBoxModel boxForInvitedUser);
	
	
}



/******* S.D.G. *******/



