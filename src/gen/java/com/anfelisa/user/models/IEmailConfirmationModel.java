package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=EmailConfirmationModel.class)
public interface IEmailConfirmationModel {

	String getToken();
	void setToken(String token);
	
	String getUserId();
	void setUserId(String userId);
	
	
	List<String> equalsPrimitiveTypes(IEmailConfirmationModel other);
	
}

/*       S.D.G.       */
